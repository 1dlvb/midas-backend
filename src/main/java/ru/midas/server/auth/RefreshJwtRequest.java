package ru.midas.server.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshJwtRequest {

    public String refreshToken;
}
