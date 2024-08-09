/*
*
* 
*
* Creada el 10 ago 2024, 1:06:37
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 10 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 10 ago 2024
*/
package com.nomudev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.nomudev.models.ProductModel;
import com.nomudev.repositories.IProductRepo;

@Service
public class ProductServices {
    @Autowired
    IProductRepo productRepo;

    public List<ProductModel> getAllProducts() {
        return productRepo.findAll();
    }

    public ProductModel getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public ProductModel saveProduct(ProductModel bill) {
        return productRepo.save(bill);
    }

    public Boolean deleteProductById(Long id) {

        try {
            productRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
