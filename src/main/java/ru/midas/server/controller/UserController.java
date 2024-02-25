package ru.midas.server.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.midas.server.model.MidasUser;
import ru.midas.server.service.AuthService;
import ru.midas.server.service.MidasUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/midas/user")
public class UserController {
    @NonNull
    private final MidasUserService userService;
    private final AuthService authService;

    @GetMapping()
    public ResponseEntity<List<MidasUser>> fetchAllUsers(){
        return ResponseEntity.ok().body(userService.fetchAllUsers());
    }

    @PostMapping("/save")
    public ResponseEntity<MidasUser> saveUser(@RequestBody MidasUser midasUser){
        return ResponseEntity.ok().body(userService.saveUser(midasUser));
    }

    @GetMapping("/{id}")
    public MidasUser findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }


    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MidasUser updateUser(@RequestBody MidasUser midasUser, @PathVariable  Long id){
        midasUser.setId(id);
        return userService.updateUser(midasUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return String.format("Id:%d is deleted successfully.", id);
    }

}
