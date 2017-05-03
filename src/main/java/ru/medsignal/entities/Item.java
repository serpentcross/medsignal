package ru.medsignal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Integer id;

    @Column(name = "artikul")
    @Getter @Setter
    private String artikul;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "price")
    @Getter @Setter
    private int price;

    @Column(name = "description")
    @Getter @Setter
    private String description;
}
