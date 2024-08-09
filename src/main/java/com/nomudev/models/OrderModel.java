/*
*
* 
*
* Creada el 08 ago 2024, 14:49:01
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
@Table(name = "orders")
@Data
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nif;
    private String name;
    private String lastname;
    private String lineDir1;
    private String lineDir2;
    private String date;

}
