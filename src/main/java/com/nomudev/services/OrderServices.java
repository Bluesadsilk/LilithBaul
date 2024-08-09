/*
*
* 
*
* Creada el 08 ago 2024, 14:49:01
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

import com.nomudev.models.OrderModel;
import java.util.List;
import com.nomudev.repositories.IOrderRepo;

@Service
public class OrderServices {
    @Autowired
    IOrderRepo orderRepo;

    public List<OrderModel> getAllCats() {
        return orderRepo.findAll();
    }

    public OrderModel getCatById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public OrderModel saveBill(OrderModel bill) {
        return orderRepo.save(bill);
    }

    public Boolean deleteCatById(Long id) {

        try {
            orderRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
