/*
*
* 
*
* Creada el 08 ago 2024, 14:31:05
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 08 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 08 ago 2024
*/
package com.nomudev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Locale.Category;

import com.nomudev.models.CategoryModel;

import com.nomudev.repositories.ICategoryRepo;

@Service
public class CategoryServices {
    @Autowired
    ICategoryRepo catRepo;

    public List<CategoryModel> getAllCats() {
        return catRepo.findAll();
    }

    public CategoryModel getCatById(Long id) {
        return catRepo.findById(id).orElse(null);
    }

    public CategoryModel saveCat(CategoryModel bill) {
        return catRepo.save(bill);
    }

    public Boolean deleteCatById(Long id) {

        try {
            catRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public CategoryModel updateCategoryField(Long id, Map<String, Object> updates) {
        CategoryModel category;

        // Intentar obtener la categoria por ID
        try {
            category = catRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Cost not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando la categoria no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "Id":
                        category.setCategoryId((Long) value);
                        break;
                    case "lastName":
                        category.setCategoryName((String) value);
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

        // Intentar guardar la categoria actualizado
        try {
            return catRepo.save(category);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving category: " + e.getMessage());
            throw new RuntimeException("Error saving category", e); // Re-lanzar para permitir que el llamador maneje el
                                                                    // error
        }
    }
}
