/*

Creada el 16 ago 2024,14:48:12

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

import com.nomudev.models.SizeModel;
import com.nomudev.services.SizeServices;

@RestController
@RequestMapping("/sizes")
public class SizeController {
    @Autowired
    private SizeServices SizeService;

    @GetMapping
    public List<SizeModel> get() {
        return SizeService.getAllSizes();
    }

    @GetMapping("/{id}")

    public ResponseEntity<SizeModel> getSizeById(@PathVariable Long id) {
        SizeModel size = SizeService.getSizeById(id);
        if (size != null) {
            return ResponseEntity.ok(size);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSizeById(@PathVariable Long id) {
        Boolean isDeleted = SizeService.deleteSizeById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public SizeModel addClient(@RequestBody SizeModel size) {
        return SizeService.saveSize(size);
    }
}
