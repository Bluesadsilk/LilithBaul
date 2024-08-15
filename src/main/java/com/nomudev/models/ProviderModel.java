/*
*
* 
*
* Creada el 08 ago 2024, 14:31:34
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
@Table(name = "providers")
@Data
public class ProviderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;
    private String providerCif;
    private String providerName;
    private String providerEmail;
    private String providerDirLane1;
    private String providerDirLane2;
    private String providerPhoneNumber;
}
