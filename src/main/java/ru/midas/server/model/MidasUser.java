package ru.midas.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "midas_user")
public class MidasUser {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 1000)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String LastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(length = 512)
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

}
