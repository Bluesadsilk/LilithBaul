/*

Creada el 16 ago 2024,14:46:32

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.nomudev.models.DiscountModel;
import com.nomudev.services.DiscountServices;
import java.util.List;
import java.util.Map;
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

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    private DiscountServices discountServices;

    @GetMapping
    public List<DiscountModel> get() {
        return discountServices.getAllDiscounts();
    }

    @GetMapping("/{id}")

    public ResponseEntity<DiscountModel> getDiscountById(@PathVariable Long id) {
        DiscountModel discount = discountServices.getDiscountById(id);
        if (discount != null) {
            return ResponseEntity.ok(discount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscountById(@PathVariable Long id) {
        Boolean isDeleted = discountServices.deleteDiscoutById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public DiscountModel addDiscount(@RequestBody DiscountModel discount) {
        return discountServices.saveDiscount(discount);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DiscountModel> updateDiscountFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            DiscountModel updatedDiscount = discountServices.updateDiscountField(id, updates);
            return new ResponseEntity<>(updatedDiscount, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
