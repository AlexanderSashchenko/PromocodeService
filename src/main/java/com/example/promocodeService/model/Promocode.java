package com.example.promocodeService.model;

import jakarta.persistence.*;

@Entity
@Table(name = "promocodes")
public class Promocode {

    @Id
    @SequenceGenerator(
            name = "promocodes_sequence",
            sequenceName = "promocodes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "promocodes_sequence"
    )
    private Long id;
    private String value;


    public Promocode() {

    }

    public Promocode(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Promocode{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
