/*
*
* 
*
* Creada el 08 ago 2024, 14:55:16
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
import com.nomudev.models.usersDataModel;
import com.nomudev.repositories.IUsersDataRepo;

@Service
public class UsersDataServices {
    @Autowired
    IUsersDataRepo usersDataRepo;

    public List<usersDataModel> getAllUsers() {
        return usersDataRepo.findAll();
    }

    public usersDataModel getUsersById(Long id) {
        return usersDataRepo.findById(id).orElse(null);
    }

    public usersDataModel saveUser(usersDataModel bill) {
        return usersDataRepo.save(bill);
    }

    public Boolean deleteUserById(Long id) {

        try {
            usersDataRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
