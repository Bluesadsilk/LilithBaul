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
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.nomudev.repositories.IOrderRepo;

@Service
public class OrderServices {
    @Autowired
    IOrderRepo orderRepo;

    public List<OrderModel> getAllOrders() {
        return orderRepo.findAll();
    }

    public OrderModel getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public OrderModel saveOrder(OrderModel bill) {
        return orderRepo.save(bill);
    }

    public Boolean deleteOrderById(Long id) {

        try {
            orderRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public OrderModel updateOrderField(Long id, Map<String, Object> updates) {
        OrderModel order;

        // Intentar obtener el orden por ID
        try {
            order = orderRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Order not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el orden no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "id":
                        order.setOrderId((Long) value);
                        break;
                    case "lastName":
                        order.setOrderStatus((int) value);
                        break;
                    case "nif":
                        order.setOrderType((int) value);
                        break;
                    case "email":
                        order.setOrderDate((Date) value);
                        break;
                    case "dirLine1":
                        order.setOrderDirLine1((String) value);
                        break;
                    case "dirLine2":
                        order.setOrderDirLine2((String) value);
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

        // Intentar guardar el orden actualizado
        try {
            return orderRepo.save(order);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving order: " + e.getMessage());
            throw new RuntimeException("Error saving order", e); // Re-lanzar para permitir que el llamador maneje el
                                                                 // error
        }
    }

}
