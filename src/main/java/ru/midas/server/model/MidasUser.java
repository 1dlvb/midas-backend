package ru.midas.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import jakarta.validation.constraints.Pattern;


@Data
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MidasUser {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;

    //TODO: add number validation
    @Column(nullable = false)
    String phoneNumber;

//    @Column(nullable = true)
//    Cart cart;


}
