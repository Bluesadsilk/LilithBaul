/*

Creada el 16 ago 2024,1:06:59

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomudev.models.SubcategoryModel;
import com.nomudev.repositories.ISubcategoryRepo;

@Service
public class SubcategoryServices {
    @Autowired
    private ISubcategoryRepo subcategoryRepo;

    public List<SubcategoryModel> getAllSubcategorys() {
        return subcategoryRepo.findAll();
    }

    public SubcategoryModel getSubcategoryById(long id) {
        return subcategoryRepo.findById(id).orElse(null);
    }

    public SubcategoryModel saveSubcategory(SubcategoryModel entity) {
        return subcategoryRepo.save(entity);
    }

    public boolean deleteSubcategoryById(Long id) {
        try {
            subcategoryRepo
                    .deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public SubcategoryModel updateSubcategoryField(Long id, Map<String, Object> updates) {
        SubcategoryModel subcategory;

        // Intentar obtener la subcategoria por ID
        try {
            subcategory = subcategoryRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Subcategory not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando la subcategoria no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "id":
                        subcategory.setSubcategoryId((Long) value);
                        break;
                    case "name":
                        subcategory.setSubcategoryName((String) value);
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

        // Intentar guardar la subcategoria actualizado
        try {
            return subcategoryRepo.save(subcategory);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving subcategory: " + e.getMessage());
            throw new RuntimeException("Error saving subcategory", e); // Re-lanzar para permitir que el llamador maneje
                                                                       // el
            // error
        }
    }
}
