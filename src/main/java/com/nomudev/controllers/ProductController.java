/*
*
* 
*
* Creada el 09 ago 2024, 20:07:09
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
import com.nomudev.models.ProductModel;
import com.nomudev.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productServices.getAllProducts();
    }

    @GetMapping("/{id}")

    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id) {
        ProductModel product = productServices.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        Boolean isDeleted = productServices.deleteProductById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public ProductModel saveProduct(@RequestBody ProductModel product) {
        return productServices.saveProduct(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductModel> updateProductFields(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        try {
            ProductModel updatedProduct = productServices.updateProductField(id, updates);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
