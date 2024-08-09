/*
*
* 
*
* Creada el 08 ago 2024, 16:27:46
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 08 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 08 ago 2024
*/
package com.nomudev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nomudev.models.ProductModel;

@Repository
public interface IProductRepo extends JpaRepository<ProductModel, Long> {

}
