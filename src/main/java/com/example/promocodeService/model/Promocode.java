package com.example.promocodeService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "promocodes")
public class Promocode {

    @Id
    private Long id;
    private String value;
    private Long user_id;
    private String status;

    public Promocode() {

    }

    public Promocode(Long user_id, Status status) {
        this.user_id = user_id;
        this.status = status.toString();
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

    public Status getStatus() {
        return Status.valueOf(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.toString();
    }

    @Override
    public String toString() {
        return "Promocode{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", user_id=" + user_id +
                ", status='" + status + '\'' +
                '}';
    }
}
