/*
*
* 
*
* Creada el 08 ago 2024, 14:49:01
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 08 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 08 ago 2024
*/
package com.nomudev.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name = "clientId", nullable = false)
    private ClientModel client;

    @OneToMany(mappedBy = "order")
    private List<OrderLineModel> orderLines;

    @OneToMany(mappedBy = "order")
    private List<BillModel> bills;

}
