/*
*
* 
*
* Creada el 09 ago 2024, 20:05:49
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 09 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 09 ago 2024
*/
package com.nomudev.controllers;

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
import java.util.List;
import java.util.Map;

import com.nomudev.models.CategoryModel;
import com.nomudev.services.CategoryServices;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryServices catServices;

    @GetMapping
    public List<CategoryModel> getCats() {
        return catServices.getAllCats();
    }

    @GetMapping("/{id}")

    public ResponseEntity<CategoryModel> getCatById(@PathVariable Long id) {
        CategoryModel cat = catServices.getCatById(id);
        if (cat != null) {
            return ResponseEntity.ok(cat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatById(@PathVariable Long id) {
        Boolean isDeleted = catServices.deleteCatById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public CategoryModel addOrder(@RequestBody CategoryModel cat) {
        return catServices.saveCat(cat);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryModel> updateCategoryFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            CategoryModel updatedCategory = catServices.updateCategoryField(id, updates);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
