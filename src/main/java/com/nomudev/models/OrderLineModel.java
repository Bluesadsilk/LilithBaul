/*
*
* 
*
* Creada el 08 ago 2024, 14:32:06
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ORDERLINES")
@Data
public class OrderLineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderLineId;

    @Column(nullable = false)
    private int orderLineAmount;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private OrderModel order;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private ProductModel product;

    @ManyToOne
    @JoinColumn(name = "variantId", nullable = false)
    private VariantModel variant;

}
