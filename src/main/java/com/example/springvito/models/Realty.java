package com.example.springvito.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CompositeType;
import org.springframework.format.number.money.MonetaryAmountFormatter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "realty")
@NoArgsConstructor
public class Realty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(max = 20)
    @NotNull
    @Column(name = "type")
    private String type;

    @Size(max = 100)
    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "room_size")
    private Integer roomSize;

    @Column(name = "plot_size")
    private Integer plotSize;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Person owner;

    @Override
    public String toString() {
        return
                "id=" + id +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", roomSize=" + roomSize +
                ", plotSize=" + plotSize +
                ", price=" + price +
                ", owner=" + owner.getNickname();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Realty realty = (Realty) o;
        return id == realty.id && Objects.equals(type, realty.type) && Objects.equals(address, realty.address) && Objects.equals(roomSize, realty.roomSize) && Objects.equals(plotSize, realty.plotSize) && Objects.equals(price, realty.price) && Objects.equals(owner, realty.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, address, roomSize, plotSize, price, owner);
    }
}