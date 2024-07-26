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
@Table(name = "personal_items")
public class PersonalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personal_items_id_gen")
    @SequenceGenerator(name = "personal_items_id_gen", sequenceName = "items_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner", nullable = false)
    private Person owner;

    @Override
    public String toString() {
        return  "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", owner=" + owner.getNickname();
    }
}