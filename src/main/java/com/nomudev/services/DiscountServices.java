/*

Creada el 16 ago 2024,0:47:18

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

import com.nomudev.models.DiscountModel;
import com.nomudev.models.DiscountModel;
import com.nomudev.repositories.IDiscountRepo;

@Service
public class DiscountServices {
    @Autowired
    private IDiscountRepo discountRepo;

    public List<DiscountModel> getAllDiscounts() {
        return discountRepo.findAll();
    }

    public DiscountModel getDiscountById(long id) {
        return discountRepo.findById(id).orElse(null);
    }

    public DiscountModel saveDiscount(DiscountModel entity) {
        return discountRepo.save(entity);
    }

    public boolean deleteDiscoutById(Long id) {
        try {
            discountRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public DiscountModel updateDiscountField(Long id, Map<String, Object> updates) {
        DiscountModel discount;

        // Intentar obtener el descuento por ID
        try {
            discount = discountRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Discount not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el descuento no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "Id":
                        discount.setDiscountId((Long) value);
                        break;
                    case "amount":
                        discount.setDiscountAmount((float) value);
                        break;
                    case "activeFrom":
                        discount.setDiscountActiveFrom((Date) value);
                        break;
                    case "activeUntil":
                        discount.setDiscountActiveUntil((Date) value);
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

        // Intentar guardar el descuento actualizado
        try {
            return discountRepo.save(discount);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving Discount: " + e.getMessage());
            throw new RuntimeException("Error saving Discount", e); // Re-lanzar para permitir que el llamador maneje el
                                                                    // error
        }
    }
}
