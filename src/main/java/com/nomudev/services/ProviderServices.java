/*
*
* 
*
* Creada el 08 ago 2024, 14:31:34
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
import com.nomudev.models.ProviderModel;
import com.nomudev.repositories.IProviderRepo;

@Service
public class ProviderServices {
    @Autowired
    IProviderRepo providerRepo;

    public List<ProviderModel> getAllProviders() {
        return providerRepo.findAll();
    }

    public ProviderModel getProviderById(Long id) {
        return providerRepo.findById(id).orElse(null);
    }

    public ProviderModel saveProvider(ProviderModel bill) {
        return providerRepo.save(bill);
    }

    public Boolean deleteProviderById(Long id) {

        try {
            providerRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }
}
