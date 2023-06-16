package com.example.promocodeService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "promocodes")
public class Promocode {

    @Id
    private Long id;
    private String value;
    private Long user_id;

    public Promocode() {

    }

    public Promocode(String value, Long user_id) {
        this.value = value;
        this.user_id = user_id;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Promocode{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
