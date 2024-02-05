package ru.midas.server.api.controller.auth;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.midas.server.api.model.RegistrationBody;
import ru.midas.server.exception.UserAlreadyExistsException;
import ru.midas.server.model.MidasUser;
import ru.midas.server.service.MidasUserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/midas/auth")
public class AuthenticationController {

    @NonNull
    private final MidasUserService service;
    @PostMapping("/register")
    public ResponseEntity<MidasUser> registerUser(@Valid @RequestBody RegistrationBody registrationBody){
         try{
             service.registerUser(registrationBody);
             return ResponseEntity.ok().build();
         } catch (UserAlreadyExistsException e) {
             return ResponseEntity.status(HttpStatus.CONFLICT).build();
         }
    }
}
