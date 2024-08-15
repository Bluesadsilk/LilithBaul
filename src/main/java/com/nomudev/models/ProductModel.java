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

import java.util.Locale.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private Long categoryID;
    private Long subCategoryID;
    private String productName;
    private String productDescription;
    private String productImageLink;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private SubcategoryModel subcategories;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
}
