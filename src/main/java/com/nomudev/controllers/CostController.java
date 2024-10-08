/*

Creada el 16 ago 2024,14:35:17

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nomudev.models.CostModel;
import com.nomudev.services.CostServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/costs")
public class CostController {
    @Autowired
    private CostServices costService;

    @GetMapping()
    public List<CostModel> get() {
        return costService.getAllCosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostModel> getCostByName(@PathVariable Long id) {
        CostModel cost = costService.getCostById(id);
        if (cost != null) {
            return ResponseEntity.ok(cost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCostById(@PathVariable Long id) {
        Boolean isDeleted = costService.deleteCostById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public CostModel addCost(@RequestBody CostModel cost) {
        return costService.saveCost(cost);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CostModel> updateCostFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            CostModel updatedCost = costService.updateCostField(id, updates);
            return new ResponseEntity<>(updatedCost, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
