/*

Creada el 16 ago 2024,14:49:13

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.nomudev.models.VariantModel;
import com.nomudev.services.VariantServices;
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
@RequestMapping("/Variants")
public class VariantController {
    @Autowired
    private VariantServices variantServices;

    @GetMapping
    public List<VariantModel> get() {
        return variantServices.getAllVariants();
    }

    @GetMapping("/{id}")

    public ResponseEntity<VariantModel> getVariantById(@PathVariable Long id) {
        VariantModel variant = variantServices.getVariantById(id);
        if (variant != null) {
            return ResponseEntity.ok(variant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariantById(@PathVariable Long id) {
        Boolean isDeleted = variantServices.deleteVariantById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public VariantModel addVariant(@RequestBody VariantModel variant) {
        return variantServices.saveVariant(variant);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VariantModel> updateVariantFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            VariantModel updatedVariant = variantServices.updateVariantField(id, updates);
            return new ResponseEntity<>(updatedVariant, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
