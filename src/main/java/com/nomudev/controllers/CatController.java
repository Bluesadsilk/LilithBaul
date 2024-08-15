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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.nomudev.models.CategoryModel;
import com.nomudev.services.CatServices;

@RestController
@RequestMapping("/categories")
public class CatController {
    @Autowired
    private CatServices catService;

    @GetMapping
    public List<CategoryModel> getCats() {
        return catService.getAllCats();
    }

    @GetMapping("/{id}")

    public ResponseEntity<CategoryModel> getCatById(@PathVariable Long id) {
        CategoryModel cat = catService.getCatById(id);
        if (cat != null) {
            return ResponseEntity.ok(cat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatById(@PathVariable Long id) {
        Boolean isDeleted = catService.deleteCatById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public CategoryModel addOrder(@RequestBody CategoryModel cat) {
        return catService.saveCat(cat);
    }

}
