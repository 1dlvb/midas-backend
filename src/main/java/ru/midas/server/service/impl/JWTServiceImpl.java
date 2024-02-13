package ru.midas.server.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.midas.server.model.MidasUser;
import ru.midas.server.service.JWTService;

import java.util.Date;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("jwt.algorithm.key")
    private String algorithmKey;

    @Value("jwt.issuer")
    private String issuer;

    @Value("jwt.expiry.in.seconds")
    private String expiryInSeconds;

    @Setter
    @Getter
    private Algorithm algorithm;
    private static final String EMAIL_KEY = "EMAIL";

    @Override
    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    @Override
    public String generateJWT(MidasUser user){
        return JWT.create()
                .withClaim(EMAIL_KEY, user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000L * Integer.parseInt(expiryInSeconds))))
                .withIssuer(issuer)
                .sign(algorithm);
    }

}
