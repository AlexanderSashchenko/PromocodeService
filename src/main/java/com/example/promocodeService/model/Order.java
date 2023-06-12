package com.example.promocodeService.model;

import com.example.promocodeService.model.constants.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(
            name = "orders_sequence",
            sequenceName = "orders_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orders_sequence"
    )
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private Promocode promocode;
    private String status;

    public Order() {

    }

    public Order(User user, Promocode promocode, Status status) {
        this.user = user;
        this.promocode = promocode;
        this.status = status.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Promocode getPromocode() {
        return promocode;
    }

    public void setPromocode(Promocode promocode) {
        this.promocode = promocode;
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status.toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", promocode=" + promocode +
                ", status=" + status +
                '}';
    }
}
