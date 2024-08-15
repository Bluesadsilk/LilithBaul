/*
*
* 
*
* Creada el 08 ago 2024, 14:31:05
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
@Table(name = "categories")
@Data
public class CatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
}
