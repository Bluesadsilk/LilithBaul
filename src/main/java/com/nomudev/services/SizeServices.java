/*

Creada el 16 ago 2024,1:03:03

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomudev.models.SizeModel;
import com.nomudev.repositories.ISizeRepo;

@Service
public class SizeServices {
    @Autowired
    private ISizeRepo sizeRepo;

    public List<SizeModel> getAllSizes() {
        return sizeRepo
                .findAll();
    }

    public SizeModel getSizeById(long id) {
        return sizeRepo
                .findById(id).orElse(null);
    }

    public SizeModel saveSize(SizeModel entity) {
        return sizeRepo
                .save(entity);
    }

    public boolean deleteSizeById(Long id) {
        try {
            sizeRepo
                    .deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
