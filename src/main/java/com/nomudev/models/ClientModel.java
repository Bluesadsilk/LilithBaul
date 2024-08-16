/*
*
* 
*
* Creada el 08 ago 2024, 14:31:20
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

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENTS")
@Data
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(length = 30, nullable = false)
    private String clientNif;

    @Column(length = 50, nullable = false)
    private String clientName;

    @Column(length = 50)
    private String clientLastName;

    @Column(length = 30, nullable = false)
    private String clientEmail;

    @Column(length = 50)
    private String clientDirLine1;

    @Column(length = 50)
    private String clientDirLine2;

    @Column(length = 30, nullable = false)
    private String clientPhoneNumber;

    @OneToMany(mappedBy = "client")
    private List<OrderModel> orders;

    @OneToMany(mappedBy = "client")
    private List<BillModel> bills;
}
