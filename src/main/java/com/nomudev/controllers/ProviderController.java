/*
*
* 
*
* Creada el 09 ago 2024, 20:06:20
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

import java.security.Provider;
import java.util.List;
import java.util.Map;

import com.nomudev.models.ProviderModel;
import com.nomudev.models.ProviderModel;
import com.nomudev.services.ProviderServices;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    @Autowired
    private ProviderServices providerServices;

    @GetMapping
    public List<ProviderModel> getAllProviders() {
        return providerServices.getAllProviders();
    }

    @GetMapping("/{id}")

    public ResponseEntity<ProviderModel> getProviderById(@PathVariable Long id) {
        ProviderModel provider = providerServices.getProviderById(id);
        if (provider != null) {
            return ResponseEntity.ok(provider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProviderById(@PathVariable Long id) {
        Boolean isDeleted = providerServices.deleteProviderById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public ProviderModel saveProvider(@RequestBody ProviderModel provider) {
        return providerServices.saveProvider(provider);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProviderModel> updateProviderFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            ProviderModel updatedProvider = providerServices.updateProviderField(id, updates);
            return new ResponseEntity<>(updatedProvider, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
