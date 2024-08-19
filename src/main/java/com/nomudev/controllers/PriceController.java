/*

Creada el 16 ago 2024,14:47:51

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomudev.models.PriceModel;
import com.nomudev.models.PriceModel;
import com.nomudev.services.PriceServices;

@RestController
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private PriceServices priceServices;

    @GetMapping
    public List<PriceModel> get() {
        return priceServices.getAllPrices();
    }

    @GetMapping("/{id}")

    public ResponseEntity<PriceModel> getPriceById(@PathVariable Long id) {
        PriceModel price = priceServices.getPriceById(id);
        if (price != null) {
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriceById(@PathVariable Long id) {
        Boolean isDeleted = priceServices.deletePriceById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public PriceModel addPrice(@RequestBody PriceModel price) {
        return priceServices.savePrice(price);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PriceModel> updatePriceFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            PriceModel updatedPrice = priceServices.updatePriceField(id, updates);
            return new ResponseEntity<>(updatedPrice, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
