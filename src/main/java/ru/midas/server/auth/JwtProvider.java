package ru.midas.server.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import ru.midas.server.model.MidasUser;


import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Component
@Getter
public class JwtProvider {

    private final SecretKey jwtAccessSecret;
    private final SecretKey jwtRefreshSecret;

    public JwtProvider(
            @Value("${jwt.secret.access}") String jwtAccessSecret,
            @Value("${jwt.secret.refresh}") String jwtRefreshSecret
    )  {
        this.jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecret));
        this.jwtRefreshSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtRefreshSecret));
    }
    public String generateAccessToken(@NonNull MidasUser user){
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusHours(1).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);

        return Jwts.builder()
                .setSubject(user.getPhoneNumber())
                .setExpiration(accessExpiration)
                .signWith(jwtAccessSecret)
                .claim("roles", user.getRoles())
                .claim("name", user.getName())
                .compact();
    }
    public String generateRefreshToken(@NonNull MidasUser user){
        final LocalDateTime now = LocalDateTime.now();
        final Instant refreshExpirationInstant = now.plusDays(7).atZone(ZoneId.systemDefault()).toInstant();
        final Date refreshExpiration = Date.from(refreshExpirationInstant);
        return Jwts.builder()
                .setSubject(user.getPhoneNumber())
                .setExpiration(refreshExpiration)
                .signWith(jwtRefreshSecret)
                .compact();
    }

    public boolean validateAccessToken(@NonNull String accessToken){
        return validateToken(accessToken, jwtAccessSecret);
    }
    public boolean validateRefreshToken(@NonNull String refreshToken){
        return validateToken(refreshToken, jwtRefreshSecret);
    }

    public Claims getAccessClaims(@NonNull String token){
        return getClaims(token, jwtAccessSecret);
    }

    public Claims getRefreshClaims(@NonNull String token){
        return getClaims(token, jwtRefreshSecret);
    }

    private boolean validateToken(@NonNull String token, @NonNull Key secret){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch (ExpiredJwtException expEx) {log.error("Token expired", expEx);}
        catch (UnsupportedJwtException unsEx) {log.error("Unsupported jwt", unsEx);}
        catch (MalformedJwtException mlEx) {log.error("Malformed jwt", mlEx);}
        catch (SignatureException sigEx) {log.error("Invalid signature", sigEx);}
        catch (Exception e) {log.error("Invalid token");}

        return false;
    }

    private Claims getClaims(@NonNull String token, @NonNull Key secret) {

        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
