package com.example.springvito.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autos_id_gen")
    @SequenceGenerator(name = "autos_id_gen", sequenceName = "autos_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "brand", nullable = false, length = 20)
    private String brand;

    @Size(max = 20)
    @NotNull
    @Column(name = "model", nullable = false, length = 20)
    private String model;

    @NotNull
    @Column(name = "year", nullable = false)
    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Person owner;

    @Column(name = "price")
    private BigDecimal price;

    @Override
    public String toString() {
        return  "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", owner=" + owner.getNickname();
    }
}