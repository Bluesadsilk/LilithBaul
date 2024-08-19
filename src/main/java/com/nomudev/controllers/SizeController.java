/*

Creada el 16 ago 2024,14:48:12

Desarrollada por Bluesadsilk en l'empresa Abastos el dia 16 ago 2024

Email de contacto:bluesadsilk@proton.me


* @autor Bluesadsilk
* @date 16 ago 2024
*/
package com.nomudev.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.nomudev.models.SizeModel;
import com.nomudev.models.SizeModel;
import com.nomudev.services.SizeServices;

@RestController
@RequestMapping("/sizes")
public class SizeController {
    @Autowired
    private SizeServices sizeServices;

    @GetMapping
    public List<SizeModel> get() {
        return sizeServices.getAllSizes();
    }

    @GetMapping("/{id}")

    public ResponseEntity<SizeModel> getSizeById(@PathVariable Long id) {
        SizeModel size = sizeServices.getSizeById(id);
        if (size != null) {
            return ResponseEntity.ok(size);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSizeById(@PathVariable Long id) {
        Boolean isDeleted = sizeServices.deleteSizeById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public SizeModel addSize(@RequestBody SizeModel size) {
        return sizeServices.saveSize(size);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SizeModel> updateSizeFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            SizeModel updatedSize = sizeServices.updateSizeField(id, updates);
            return new ResponseEntity<>(updatedSize, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
