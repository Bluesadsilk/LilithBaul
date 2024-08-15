/*

Creada el 16 ago 2024,1:06:59

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomudev.models.SubcategoryModel;
import com.nomudev.repositories.ISubcategoryRepo;

@Service
public class SubcategoryServices {
    @Autowired
    private ISubcategoryRepo subcategoryRepo;

    public List<SubcategoryModel> getAllDiscounts() {
        return subcategoryRepo.findAll();
    }

    public SubcategoryModel getDiscountById(long id) {
        return subcategoryRepo.findById(id).orElse(null);
    }

    public SubcategoryModel saveDiscount(SubcategoryModel entity) {
        return subcategoryRepo.save(entity);
    }

    public boolean deleteDiscoutById(Long id) {
        try {
            subcategoryRepo
                    .deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
