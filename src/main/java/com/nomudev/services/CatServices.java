/*
*
* 
*
* Creada el 08 ago 2024, 14:31:05
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
import com.nomudev.models.CategoryModel;
import com.nomudev.repositories.ICatRepo;

@Service
public class CatServices {
    @Autowired
    ICatRepo catRepo;

    public List<CategoryModel> getAllCats() {
        return catRepo.findAll();
    }

    public CategoryModel getCatById(Long id) {
        return catRepo.findById(id).orElse(null);
    }

    public CategoryModel saveCat(CategoryModel bill) {
        return catRepo.save(bill);
    }

    public Boolean deleteCatById(Long id) {

        try {
            catRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }
}
