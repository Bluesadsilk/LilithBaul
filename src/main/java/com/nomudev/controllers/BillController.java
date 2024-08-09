/*
*
* 
*
* Creada el 09 ago 2024, 20:05:41
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
import com.nomudev.models.BillModel;
import com.nomudev.services.BillServices;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillServices BillService;

    @GetMapping
    public List<BillModel> get() {
        return BillService.getAllBills();
    }

    @GetMapping("/{id}")

    public ResponseEntity<BillModel> getBillById(@PathVariable Long id) {
        BillModel bill = BillService.getBillById(id);
        if (bill != null) {
            return ResponseEntity.ok(bill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillById(@PathVariable Long id) {
        Boolean isDeleted = BillService.deleteBillById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public BillModel addClient(@RequestBody BillModel bill) {
        return BillService.saveBill(bill);
    }

}
