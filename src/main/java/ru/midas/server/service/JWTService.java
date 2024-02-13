package ru.midas.server.service;

import jakarta.annotation.PostConstruct;
import ru.midas.server.model.MidasUser;
public interface JWTService {

    @PostConstruct
    void postConstruct();
    String generateJWT(MidasUser user);

}
