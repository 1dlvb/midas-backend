package ru.midas.server.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrationBody {

    @NotNull
    @NotBlank
    private String phoneNumber;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String password;

    @Email
    private String email;

}
