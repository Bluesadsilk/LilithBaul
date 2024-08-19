/*

Creada el 16 ago 2024,0:53:51

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.services;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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

    public OrderLineModel updateOrderLineField(Long id, Map<String, Object> updates) {
        OrderLineModel orderLine;

        // Intentar obtener la linea de pedido por ID
        try {
            orderLine = orderLineRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Order line not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando la linea de pedido no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "id":
                        orderLine.setOrderLineId((Long) value);
                        break;
                    case "amount":
                        orderLine.setOrderLineAmount((Long) value);
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

        // Intentar guardar la linea de pedido actualizado
        try {
            return orderLineRepo.save(orderLine);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving orderLine: " + e.getMessage());
            throw new RuntimeException("Error saving orderLine", e); // Re-lanzar para permitir que el llamador maneje
                                                                     // el
                                                                     // error
        }
    }

}
