/*

Creada el 16 ago 2024,1:00:51

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomudev.models.PriceModel;
import com.nomudev.repositories.IPriceRepo;

@Service
public class PriceServices {
    @Autowired
    private IPriceRepo priceRepo;

    public List<PriceModel> getAllDiscounts() {
        return priceRepo.findAll();
    }

    public PriceModel getDiscountById(long id) {
        return priceRepo.findById(id).orElse(null);
    }

    public PriceModel saveDiscount(PriceModel entity) {
        return priceRepo.save(entity);
    }

    public boolean deleteDiscoutById(Long id) {
        try {
            priceRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
