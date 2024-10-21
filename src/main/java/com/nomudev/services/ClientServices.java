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
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nomudev.models.ClientModel;
import com.nomudev.repositories.IClientRepo;

import java.util.NoSuchElementException;

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

    public ClientModel updateClientField(Long id, Map<String, Object> updates) {
        ClientModel client;

        // Intentar obtener el cliente por ID
        try {
            client = clientRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Client not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el cliente no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "name":
                        client.setClientName((String) value);
                        break;
                    case "lastName":
                        client.setClientLastName((String) value);
                        break;
                    case "nif":
                        client.setClientNif((String) value);
                        break;
                    case "email":
                        client.setClientEmail((String) value);
                        break;
                    case "phoneNumber":
                        client.setClientPhoneNumber((String) value);
                        break;
                    case "lineDir1":
                        client.setClientDirLine1((String) value);
                        break;
                    case "lineDir2":
                        client.setClientDirLine2((String) value);
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

        // Intentar guardar el cliente actualizado
        try {
            return clientRepo.save(client);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving client: " + e.getMessage());
            throw new RuntimeException("Error saving client", e); // Re-lanzar para permitir que el llamador maneje el
                                                                  // error
        }
    }

}