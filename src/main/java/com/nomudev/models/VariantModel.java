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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "VARIANTS")
@Data
public class VariantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variantId;

    @Column(length = 30, nullable = false)
    private String variantName;

    @Column
    private String variantImageLink;

    @Column(nullable = false)
    private Boolean variantHaveDiscount;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productId", nullable = false)
    private ProductModel product;

    @OneToMany(mappedBy = "variant")
    @JsonManagedReference
    private List<SizeModel> sizes;

    @OneToMany(mappedBy = "variant")
    @JsonManagedReference
    private List<PriceModel> prices;

    @OneToMany(mappedBy = "variant")
    @JsonManagedReference
    private List<DiscountModel> discounts;

    @OneToMany(mappedBy = "variant")
    @JsonManagedReference
    private List<CostModel> costs;

}
