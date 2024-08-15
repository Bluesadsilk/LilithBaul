/*

Creada el 16 ago 2024,0:47:18

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
