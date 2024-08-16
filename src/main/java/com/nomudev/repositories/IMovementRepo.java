/*

Creada el 16 ago 2024,15:01:05

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nomudev.models.MovementModel;

@Repository
public interface IMovementRepo extends JpaRepository<MovementModel, Long> {

}
