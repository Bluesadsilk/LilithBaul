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
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "sizes")
@Data
public class SizeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;
    private Long productId;
    private String sizeName;
    private int sizeStock;
}
