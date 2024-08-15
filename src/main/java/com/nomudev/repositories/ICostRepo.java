/*
*
* 
*
* Creada el 15 ago 2024, 23:09:36
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 15 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 15 ago 2024
*/
package com.nomudev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nomudev.models.CostModel;

@Repository
public interface ICostRepo extends JpaRepository<CostModel, Long> {

}
