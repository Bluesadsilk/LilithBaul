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

import java.util.List;

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
@Table(name = "SUBCATEGORIES")
@Data
public class SubcategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcategoryId;

    @Column(length = 30, nullable = false)
    private String subcategoryName;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryModel category;

    @OneToMany(mappedBy = "subcategory")
    private List<ProductModel> products;

}
