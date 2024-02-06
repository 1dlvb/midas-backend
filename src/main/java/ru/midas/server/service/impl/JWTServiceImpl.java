package ru.midas.server.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.midas.server.model.MidasUser;
import ru.midas.server.service.JWTService;

import java.util.Date;

@Service
public class JWTServiceImpl implements JWTService {

    private final Dotenv dotenv = Dotenv.load();
    private final String algorithmKey = dotenv.get("JWT.ALGORITHM.KEY");
    private final String issuer = dotenv.get("JWT.ISSUER");
    private final int expiryInSeconds = Integer.parseInt(dotenv.get("JWT.EXPIRY_IN_SECONDS"));

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
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000L * expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }

}
