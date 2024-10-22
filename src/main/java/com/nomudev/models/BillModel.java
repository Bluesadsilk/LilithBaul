package com.nomudev.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JoinColumn(name = "clientId", nullable = false)
    @JsonBackReference(value = "client-bills") // Asegúrate de que este valor coincide con el utilizado en ClientModel
    private ClientModel client;

    @ManyToOne
    @JoinColumn(name = "providerId")
    @JsonBackReference(value = "provider-bills") // Cambia este valor para ser único
    private ProviderModel provider;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference(value = "order-bill") // Asegúrate de que este valor coincide con el utilizado en OrderModel
    private OrderModel order;
}
