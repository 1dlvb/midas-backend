package ru.midas.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Data
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "midas_user")
public class MidasUser{

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Column(length = 512)
    private String address;

    private Set<Role> roles;
}
