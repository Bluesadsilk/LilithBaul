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

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "client_nif", length = 30, nullable = false)
    private String clientNif;

    @Column(name = "client_name", length = 50, nullable = false)
    private String clientName;

    @Column(name = "client_lastname", length = 50)
    private String clientLastName;

    @Column(name = "client_email", length = 60, nullable = false)
    private String clientEmail;

    @Column(name = "client_dir_line_2", length = 50)
    private String clientDirLine1;

    @Column(name = "client_dir_line_1", length = 50)
    private String clientDirLine2;

    @Column(name = "client_phone_number", length = 30, nullable = false)
    private String clientPhoneNumber;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference(value = "client-orders")
    private List<OrderModel> orders;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference(value = "client-bills")
    private List<BillModel> bills;
}
