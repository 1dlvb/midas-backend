package ru.midas.server.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "hot dishes")
public class HotDishes extends Product{

    @Column(name = "portion weight (grams)")
    private int PortionWeight;


}
