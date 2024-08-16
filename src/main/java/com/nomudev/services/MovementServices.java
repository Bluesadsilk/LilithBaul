/*

Creada el 16 ago 2024,14:58:19

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomudev.models.MovementModel;
import com.nomudev.repositories.IMovementRepo;

@Service
public class MovementServices {
    @Autowired
    IMovementRepo movementRepo;

    public List<MovementModel> getAllMovements() {
        return movementRepo.findAll();
    }

    public MovementModel getMovementById(Long id) {
        return movementRepo.findById(id).orElse(null);
    }

    public MovementModel saveMovement(MovementModel movement) {
        return movementRepo.save(movement);
    }

    public Boolean deleteMovementById(Long id) {

        try {
            movementRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }
}
