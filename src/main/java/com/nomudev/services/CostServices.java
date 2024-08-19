/*

Creada el 16 ago 2024,0:30:43

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nomudev.models.CostModel;
import com.nomudev.repositories.ICostRepo;

@Service
public class CostServices {
    @Autowired
    private ICostRepo costRepo;

    public List<CostModel> getAllCosts() {
        return costRepo.findAll();
    }

    public CostModel getCostById(Long id) {
        return costRepo.findById(id).orElse(null);
    }

    public CostModel saveCost(CostModel entity) {
        return costRepo.save(entity);
    }

    public boolean deleteCostById(Long id) {
        try {
            costRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public CostModel updateCostField(Long id, Map<String, Object> updates) {
        CostModel cost;

        // Intentar obtener el coste por ID
        try {
            cost = costRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("cost not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el coste no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "costId":
                        cost.setCostId((Long) value);
                        break;
                    case "lastName":
                        cost.setCostAmount((Long) value);
                        break;
                    case "nif":
                        cost.setCostActiveFrom((Date) value);
                        break;
                    case "email":
                        cost.setCostActiveUntil((Date) value);
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

        // Intentar guardar el coste actualizado
        try {
            return costRepo.save(cost);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving cost: " + e.getMessage());
            throw new RuntimeException("Error saving cost", e); // Re-lanzar para permitir que el llamador maneje el
                                                                // error
        }
    }

}
