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

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String clientNif;
    private String clientName;
    private String clientLastName;
    private String clientEmail;
    private String clientDirLine1;
    private String clientDirLine2;
    private String clientPhoneNumber;

}
