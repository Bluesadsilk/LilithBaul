/*

Creada el 16 ago 2024,1:11:28

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;

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

}
