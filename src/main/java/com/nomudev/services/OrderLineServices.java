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

    public List<OrderLineModel> getAllOrderLines() {
        return orderLineRepo.findAll();
    }

    public OrderLineModel getOrderLineById(Long id) {
        return orderLineRepo.findById(id).orElse(null);
    }

    public OrderLineModel saveOrderLine(OrderLineModel entity) {
        return orderLineRepo.save(entity);
    }

    public boolean deleteOrderLineById(Long id) {
        try {
            orderLineRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
