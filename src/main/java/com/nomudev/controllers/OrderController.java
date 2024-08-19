/*
*
* 
*
* Creada el 09 ago 2024, 20:06:04
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 09 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 09 ago 2024
*/
package com.nomudev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import com.nomudev.models.OrderModel;
import com.nomudev.services.OrderServices;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @GetMapping
    public List<OrderModel> getAllOrders() {
        return orderServices.getAllOrders();
    }

    @GetMapping("/{id}")

    public ResponseEntity<OrderModel> getOrderById(@PathVariable Long id) {
        OrderModel order = orderServices.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        Boolean isDeleted = orderServices.deleteOrderById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public OrderModel saveOrder(@RequestBody OrderModel order) {
        return orderServices.saveOrder(order);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderModel> updateOrderFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            OrderModel updatedOrder = orderServices.updateOrderField(id, updates);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
