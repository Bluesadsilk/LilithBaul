/*
*
* 
*
* Creada el 08 ago 2024, 14:48:12
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 08 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 08 ago 2024
*/
package com.nomudev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.nomudev.models.ProvBillModel;
import com.nomudev.repositories.IProvBillRepo;

@Service
public class ProvBillServices {
    @Autowired
    IProvBillRepo provBillRepo;

    public List<ProvBillModel> getAllCats() {
        return provBillRepo.findAll();
    }

    public ProvBillModel getCatById(Long id) {
        return provBillRepo.findById(id).orElse(null);
    }

    public ProvBillModel saveBill(ProvBillModel bill) {
        return provBillRepo.save(bill);
    }

    public Boolean deleteCatById(Long id) {

        try {
            provBillRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
