/*

Creada el 16 ago 2024,14:47:22

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomudev.models.OrderLineModel;
import com.nomudev.services.OrderLineServices;

@RestController
@RequestMapping("/orderlines")
public class OrderLineController {
    @Autowired
    private OrderLineServices OrderLineService;

    @GetMapping
    public List<OrderLineModel> get() {
        return OrderLineService.getAllOrderLines();
    }

    @GetMapping("/{id}")

    public ResponseEntity<OrderLineModel> getOrderLineById(@PathVariable Long id) {
        OrderLineModel orderLine = OrderLineService.getOrderLineById(id);
        if (orderLine != null) {
            return ResponseEntity.ok(orderLine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderLineById(@PathVariable Long id) {
        Boolean isDeleted = OrderLineService.deleteOrderLineById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public OrderLineModel addClient(@RequestBody OrderLineModel orderLine) {
        return OrderLineService.saveOrderLine(orderLine);
    }
}
