/*
*
* 
*
* Creada el 08 ago 2024, 14:32:06
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

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nomudev.models.BillModel;
import com.nomudev.repositories.IBillRepo;

@Service
public class BillServices {
    @Autowired
    IBillRepo billRepo;

    public List<BillModel> getAllBills() {
        return billRepo.findAll();
    }

    public BillModel getBillById(Long id) {
        return billRepo.findById(id).orElse(null);
    }

}
