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
@Table(name = "midas_order_quantities")
public class MidasOrderQuantities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private MidasOrder order;

}
