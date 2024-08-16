/*

Creada el 16 ago 2024,14:46:59

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.nomudev.models.MovementModel;
import com.nomudev.services.MovementServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/movements")
public class MovementController {
    @Autowired
    private MovementServices MovementService;

    @GetMapping
    public List<MovementModel> get() {
        return MovementService.getAllMovements();
    }

    @GetMapping("/{id}")

    public ResponseEntity<MovementModel> getMovementById(@PathVariable Long id) {
        MovementModel movement = MovementService.getMovementById(id);
        if (movement != null) {
            return ResponseEntity.ok(movement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementById(@PathVariable Long id) {
        Boolean isDeleted = MovementService.deleteMovementById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public MovementModel addClient(@RequestBody MovementModel movement) {
        return MovementService.saveMovement(movement);
    }

}
