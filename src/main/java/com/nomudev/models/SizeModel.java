/*
*
* 
*
* Creada el 15 ago 2024, 23:03:32
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 15 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 15 ago 2024
*/
package com.nomudev.models;

import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Table(name = "SIZES")
@Data
public class SizeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;

    @Column(length = 30, nullable = false)
    private String sizeName;

    @Column(nullable = false)
    private int sizeStock;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "variantId")
    private VariantModel variant;
}
