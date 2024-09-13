/*
*
* 
*
* Creada el 08 ago 2024, 14:32:06
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
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "BILLS")
@Data
public class BillModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @Column(length = 10, nullable = false)
    private String billEntityType;

    @Column(nullable = false)
    private float billAmount;

    @Column(nullable = false)
    private Date billDate;

    @Column(nullable = false)
    private String billImageLink;

    @ManyToOne
    @JsonBackReference(value = "client-bills")
    @JoinColumn(name = "clientId")
    private ClientModel client;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "providerId")
    private ProviderModel provider;

    @ManyToOne
    @JsonManagedReference(value = "client-orders")
    @JoinColumn(name = "order_id")
    private OrderModel order;

}
