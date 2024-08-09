/*
*
* 
*
* Creada el 08 ago 2024, 14:31:20
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

import com.nomudev.models.ClientModel;
import com.nomudev.repositories.IClientRepo;

@Service
public class ClientServices {
    @Autowired
    private IClientRepo clientRepo;

    public List<ClientModel> getAllClients() {
        return clientRepo.findAll();
    }

    public ClientModel getClientById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    public ClientModel saveClient(ClientModel client) {
        return clientRepo.save(client);
    }

    public Boolean deleteClientById(Long id) {

        try {
            clientRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
