/*

Creada el 16 ago 2024,1:00:51

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nomudev.models.PriceModel;
import com.nomudev.repositories.IPriceRepo;

@Service
public class PriceServices {
    @Autowired
    private IPriceRepo priceRepo;

    public List<PriceModel> getAllPrices() {
        return priceRepo.findAll();
    }

    public PriceModel getPriceById(long id) {
        return priceRepo.findById(id).orElse(null);
    }

    public PriceModel savePrice(PriceModel entity) {
        return priceRepo.save(entity);
    }

    public boolean deletePriceById(Long id) {
        try {
            priceRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public PriceModel updatePriceField(Long id, Map<String, Object> updates) {
        PriceModel price;

        // Intentar obtener el precio por ID
        try {
            price = priceRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Price not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el precio no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "id":
                        price.setPriceId((Long) value);
                        break;
                    case "activeFrom":
                        price.setPriceActiveFrom((Date) value);
                        break;
                    case "activeUntil":
                        price.setPriceActiveUntil((Date) value);
                        break;
                    case "amount":
                        price.setPriceAmount((float) value);
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

        // Intentar guardar el precio actualizado
        try {
            return priceRepo.save(price);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving price: " + e.getMessage());
            throw new RuntimeException("Error saving price", e); // Re-lanzar para permitir que el llamador maneje el
                                                                 // error
        }
    }
}
