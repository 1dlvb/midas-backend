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
@Table(name = "midas_users")
public class MidasUser {
    private static final String SEQ_NAME = "midas_user_seq";

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    //TODO: add number validation
    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Cart cart;

    @Enumerated(EnumType.STRING)
    private Role role;


}
