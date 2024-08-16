/*
*
* 
*
* Creada el 16 ago 2024, 1:08:51
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MOVEMENTS")
@Data
public class MovementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;

    @Column(length = 30, nullable = false)
    private String movementConcept;

    @Column(nullable = false)
    private float movementAmount;

    @Column(nullable = false)
    private Date movementDate;

    @Column(length = 10, nullable = false)
    private String movementType;

    @ManyToOne
    @JoinColumn(name = "billId", nullable = false)
    private BillModel bill;

}
