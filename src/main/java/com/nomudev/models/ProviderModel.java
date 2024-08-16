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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "PROVIDERS")
@Data
public class ProviderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    @Column(length = 12)
    private String providerCif;

    @Column(length = 30, nullable = false)
    private String providerName;

    @Column(length = 30, nullable = false)
    private String providerEmail;

    @Column(length = 30, nullable = false)
    private String providerDirLine1;

    @Column(length = 30)
    private String providerDirLine2;

    @Column(length = 20, nullable = false)
    private String providerPhoneNumber;

    @OneToMany(mappedBy = "provider")
    private List<BillModel> bills;
}
