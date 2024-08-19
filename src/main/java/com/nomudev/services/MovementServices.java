/*

Creada el 16 ago 2024,14:58:19

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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

    public MovementModel updateMovementField(Long id, Map<String, Object> updates) {
        MovementModel movement;

        // Intentar obtener el movimiento por ID
        try {
            movement = movementRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Movement not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el movimiento no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "id":
                        movement.setMovementId((Long) value);
                        break;
                    case "concept":
                        movement.setMovementConcept((String) value);
                        break;
                    case "amount":
                        movement.setMovementAmount((Long) value);
                        break;
                    case "date":
                        movement.setMovementDate((Date) value);
                        break;
                    case "type":
                        movement.setMovementType((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown field: " + field);
                }
            });
        } catch (IllegalArgumentException e) {
            // Manejar el caso cuando se pasa un campo desconocido
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar guardar el movimiento actualizado
        try {
            return movementRepo.save(movement);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving movement: " + e.getMessage());
            throw new RuntimeException("Error saving movement", e); // Re-lanzar para permitir que el llamador maneje el
                                                                    // error
        }
    }
}
