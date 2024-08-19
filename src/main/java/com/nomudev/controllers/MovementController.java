/*

Creada el 16 ago 2024,14:46:59

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.nomudev.models.ClientModel;
import com.nomudev.models.MovementModel;
import com.nomudev.services.MovementServices;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/movements")
public class MovementController {
    @Autowired
    private MovementServices movementServices;

    @GetMapping
    public List<MovementModel> get() {
        return movementServices.getAllMovements();
    }

    @GetMapping("/{id}")

    public ResponseEntity<MovementModel> getMovementById(@PathVariable Long id) {
        MovementModel movement = movementServices.getMovementById(id);
        if (movement != null) {
            return ResponseEntity.ok(movement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementById(@PathVariable Long id) {
        Boolean isDeleted = movementServices.deleteMovementById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public MovementModel addMovement(@RequestBody MovementModel movement) {
        return movementServices.saveMovement(movement);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovementModel> updateMovementFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            MovementModel updatedMovement = movementServices.updateMovementField(id, updates);
            return new ResponseEntity<>(updatedMovement, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
