/*

Creada el 16 ago 2024,1:03:03

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
import com.nomudev.models.SizeModel;
import com.nomudev.repositories.ISizeRepo;

@Service
public class SizeServices {
    @Autowired
    private ISizeRepo sizeRepo;

    public List<SizeModel> getAllSizes() {
        return sizeRepo
                .findAll();
    }

    public SizeModel getSizeById(long id) {
        return sizeRepo
                .findById(id).orElse(null);
    }

    public SizeModel saveSize(SizeModel entity) {
        return sizeRepo
                .save(entity);
    }

    public boolean deleteSizeById(Long id) {
        try {
            sizeRepo
                    .deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public SizeModel updateSizeField(Long id, Map<String, Object> updates) {
        SizeModel size;

        // Intentar obtener la talla por ID
        try {
            size = sizeRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Size not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando la talla no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "sizeId":
                        size.setSizeId((Long) value);
                        break;
                    case "sizeName":
                        size.setSizeName((String) value);
                        break;
                    case "sizeStock":
                        size.setSizeStock((int) value);
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

        // Intentar guardar la talla actualizado
        try {
            return sizeRepo.save(size);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving size: " + e.getMessage());
            throw new RuntimeException("Error saving size", e); // Re-lanzar para permitir que el llamador maneje el
                                                                // error
        }
    }
}
