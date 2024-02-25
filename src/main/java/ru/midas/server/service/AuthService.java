package ru.midas.server.service;

import jakarta.security.auth.message.AuthException;
import ru.midas.server.auth.JwtAuthentication;
import ru.midas.server.auth.JwtRequest;
import ru.midas.server.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest authRequest) throws AuthException;
    JwtResponse getAccessToken(String refreshToken) throws AuthException;
    JwtResponse refresh(String refreshToken) throws AuthException;
    JwtAuthentication getAuthInfo();

}
