/*

Creada el 16 ago 2024,0:53:51

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomudev.models.OrderLineModel;
import com.nomudev.repositories.IOrderLineRepo;

@Service
public class OrderLineServices {
    @Autowired
    private IOrderLineRepo orderLineRepo;

    public List<OrderLineModel> getAllCosts() {
        return orderLineRepo.findAll();
    }

    public OrderLineModel getCostById(Long id) {
        return orderLineRepo.findById(id).orElse(null);
    }

    public OrderLineModel saveCost(OrderLineModel entity) {
        return orderLineRepo.save(entity);
    }

    public boolean deleteCostById(Long id) {
        try {
            orderLineRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
