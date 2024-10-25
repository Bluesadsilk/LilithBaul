/*

Creada el 16 ago 2024,1:11:28

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
import com.nomudev.models.VariantModel;
import com.nomudev.repositories.IVariantRepo;

@Service
public class VariantServices {
    @Autowired
    private IVariantRepo variantRepo;

    public List<VariantModel> getAllVariants() {
        return variantRepo.findAll();
    }

    public VariantModel getVariantById(Long id) {
        return variantRepo.findById(id).orElse(null);
    }

    public VariantModel saveVariant(VariantModel entity) {
        return variantRepo.save(entity);
    }

    public boolean deleteVariantById(Long id) {
        try {
            variantRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public VariantModel updateVariantField(Long id, Map<String, Object> updates) {
        VariantModel variant;

        // Intentar obtener la variante por ID
        try {
            variant = variantRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Variant not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando la variante no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "variantId":
                        variant.setVariantId((Long) value);
                        break;
                    case "variantName":
                        variant.setVariantName((String) value);
                        break;
                    case "variantImageLink":
                        variant.setVariantImageLink((String) value);
                        break;
                    case "variantHaveDiscount":
                        variant.setVariantHaveDiscount((boolean) value);
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

        // Intentar guardar la variante actualizado
        try {
            return variantRepo.save(variant);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving variant: " + e.getMessage());
            throw new RuntimeException("Error saving variant", e); // Re-lanzar para permitir que el llamador maneje el
                                                                   // error
        }
    }

}
