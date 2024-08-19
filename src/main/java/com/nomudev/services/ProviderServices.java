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
import java.util.Map;
import java.util.NoSuchElementException;
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

    public ProviderModel updateProviderField(Long id, Map<String, Object> updates) {
        ProviderModel provider;

        // Intentar obtener el proveedor por ID
        try {
            provider = providerRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Provider not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el proveedor no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "id":
                        provider.setProviderId((long) value);
                        break;
                    case "cif":
                        provider.setProviderCif((String) value);
                        break;
                    case "name":
                        provider.setProviderName((String) value);
                        break;
                    case "email":
                        provider.setProviderEmail((String) value);
                        break;
                    case "dirLine1":
                        provider.setProviderDirLine1((String) value);
                        break;
                    case "dirLine2":
                        provider.setProviderDirLine2((String) value);
                        break;
                    case "phoneNumber":
                        provider.setProviderPhoneNumber((String) value);
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

        // Intentar guardar el proveedor actualizado
        try {
            return providerRepo.save(provider);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving provider: " + e.getMessage());
            throw new RuntimeException("Error saving provider", e); // Re-lanzar para permitir que el llamador maneje el
                                                                    // error
        }
    }
}
