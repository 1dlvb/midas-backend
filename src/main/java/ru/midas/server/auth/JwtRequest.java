package ru.midas.server.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {
    private String phoneNumber;
    private String password;
}
