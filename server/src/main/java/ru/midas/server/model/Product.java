package ru.midas.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private String Description;

    @Column(nullable = false)
    private String ImageUrl;

    @Column(nullable = false)
    private Integer Quantity;

    @Column(nullable = false)
    private Integer Price;

    @Column(nullable = false)
    private Integer Weight;

}

