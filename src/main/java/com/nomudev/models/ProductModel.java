/*
*
* 
*
* Creada el 08 ago 2024, 16:25:41
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRODUCTS")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 50, nullable = false)
    private String productName;

    @Column(length = 50)
    private String productDescription;

    @Column
    private String productImageLink;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "subcategoryId", nullable = false)
    private SubcategoryModel subcategory;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryModel category;

    @OneToMany(mappedBy = "product")
    private List<VariantModel> variants;
}
