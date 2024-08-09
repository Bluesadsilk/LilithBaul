/*
*
* 
*
* Creada el 09 ago 2024, 20:06:45
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.nomudev.models.ProvBillModel;
import com.nomudev.services.ProvBillServices;

@RestController
@RequestMapping("/provider_bills")
public class ProvBillController {
    @Autowired
    private ProvBillServices provBillServices;

    @GetMapping
    public List<ProvBillModel> getAllProviderBills() {
        return provBillServices.getAllProviderBills();
    }

    @GetMapping("/{id}")

    public ResponseEntity<ProvBillModel> getProviderBillById(@PathVariable Long id) {
        ProvBillModel providerBill = provBillServices.getProviderBillById(id);
        if (providerBill != null) {
            return ResponseEntity.ok(providerBill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProviderBillById(@PathVariable Long id) {
        Boolean isDeleted = provBillServices.deleteProviderBillById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public ProvBillModel saveProviderBill(@RequestBody ProvBillModel providerBill) {
        return provBillServices.saveProviderBill(providerBill);
    }
}
