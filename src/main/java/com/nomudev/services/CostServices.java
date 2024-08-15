/*

Creada el 16 ago 2024,0:30:43

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;

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

}
