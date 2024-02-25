package ru.midas.server.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBody {

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String password;

}
