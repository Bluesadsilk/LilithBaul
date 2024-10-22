package com.nomudev.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ORDERS")
@Data
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private int orderStatus;

    @Column(nullable = false)
    private int orderType;

    @Column(nullable = false)
    private Date orderDate;

    @Column(length = 30, nullable = false)
    private String orderDirLine1;

    @Column(length = 30)
    private String orderDirLine2;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = true)
    @JsonBackReference(value = "client-orders")
    private ClientModel client;

    @OneToMany(mappedBy = "order")
    @JsonManagedReference(value = "order-orderLine")
    private List<OrderLineModel> orderLines;

    @OneToMany(mappedBy = "order")
    @JsonManagedReference(value = "order-bill")
    private List<BillModel> bills;
}
