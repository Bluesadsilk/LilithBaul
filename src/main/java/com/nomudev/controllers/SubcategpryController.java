/*

Creada el 16 ago 2024,14:48:32

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.nomudev.models.SubcategoryModel;
import com.nomudev.models.SubcategoryModel;
import com.nomudev.services.SubcategoryServices;

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
@RequestMapping("/subcategory")
public class SubcategpryController {

    @Autowired
    private SubcategoryServices subcategoryServices;

    @GetMapping
    public List<SubcategoryModel> get() {
        return subcategoryServices.getAllSubcategorys();
    }

    @GetMapping("/{id}")

    public ResponseEntity<SubcategoryModel> getSubcategoryById(@PathVariable Long id) {
        SubcategoryModel subcategory = subcategoryServices.getSubcategoryById(id);
        if (subcategory != null) {
            return ResponseEntity.ok(subcategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubcategoryById(@PathVariable Long id) {
        Boolean isDeleted = subcategoryServices.deleteSubcategoryById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public SubcategoryModel addSubcategory(@RequestBody SubcategoryModel subcategory) {
        return subcategoryServices.saveSubcategory(subcategory);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SubcategoryModel> updateSubcategoryFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            SubcategoryModel updatedSubcategory = subcategoryServices.updateSubcategoryField(id, updates);
            return new ResponseEntity<>(updatedSubcategory, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
