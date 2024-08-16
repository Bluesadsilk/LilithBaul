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
import com.nomudev.services.SubcategoryServices;

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
@RequestMapping("/subcategories")
public class SubcategpryController {

    @Autowired
    private SubcategoryServices SubcategoryService;

    @GetMapping
    public List<SubcategoryModel> get() {
        return SubcategoryService.getAllSubcategorys();
    }

    @GetMapping("/{id}")

    public ResponseEntity<SubcategoryModel> getSubcategoryById(@PathVariable Long id) {
        SubcategoryModel subcategory = SubcategoryService.getSubcategoryById(id);
        if (subcategory != null) {
            return ResponseEntity.ok(subcategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubcategoryById(@PathVariable Long id) {
        Boolean isDeleted = SubcategoryService.deleteSubcategoryById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public SubcategoryModel addClient(@RequestBody SubcategoryModel subcategory) {
        return SubcategoryService.saveSubcategory(subcategory);
    }
}
