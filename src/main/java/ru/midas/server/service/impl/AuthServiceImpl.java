package ru.midas.server.service.impl;

import io.jsonwebtoken.Claims;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.midas.server.auth.JwtAuthentication;
import ru.midas.server.auth.JwtProvider;
import ru.midas.server.auth.JwtRequest;
import ru.midas.server.auth.JwtResponse;
import ru.midas.server.model.MidasUser;
import ru.midas.server.service.AuthService;
import ru.midas.server.service.MidasUserService;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MidasUserService userService;
    private final Map<String, String> refreshStorage = new HashMap<>();
    private final JwtProvider jwtProvider;

    @Override
    public JwtResponse login(@NonNull JwtRequest authRequest) throws AuthException {
        final MidasUser user = userService.findUserByPhoneNumber(authRequest.getPhoneNumber())
                .orElseThrow(() -> new AuthException("User not found"));
        if(user.getPassword().equals(authRequest.getPassword())){
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getPhoneNumber(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        }
        else {
            throw new AuthException("Wrong password");
        }
    }

    @Override
    public JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)){
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String phoneNumber = claims.getSubject();
            final String savedRefreshToken = refreshStorage.get(phoneNumber);
            if(savedRefreshToken != null && savedRefreshToken.equals(refreshToken)){
                final MidasUser user = userService.findUserByPhoneNumber(phoneNumber)
                        .orElseThrow(() -> new AuthException("User not found"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    @Override
    public JwtResponse refresh(@NonNull String refreshToken) throws AuthException {
        if(jwtProvider.validateRefreshToken(refreshToken)){
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String phoneNumber = claims.getSubject();
            final String savedRefreshToken = refreshStorage.get(phoneNumber);
            if(savedRefreshToken != null && savedRefreshToken.equals(refreshToken)){
                final MidasUser user = userService.findUserByPhoneNumber(phoneNumber)
                        .orElseThrow(() -> new AuthException("User not found"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getPhoneNumber(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Invalid JWT");
    }

    @Override
    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
