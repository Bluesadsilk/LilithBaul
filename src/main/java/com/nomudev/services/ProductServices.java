/*
*
* 
*
* Creada el 10 ago 2024, 1:06:37
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 10 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 10 ago 2024
*/
package com.nomudev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import com.nomudev.models.ProductModel;
import com.nomudev.repositories.IProductRepo;

@Service
public class ProductServices {
    @Autowired
    IProductRepo productRepo;

    public List<ProductModel> getAllProducts() {
        return productRepo.findAll();
    }

    public Long countAllProducts() {
        return productRepo.count();
    }

    public ProductModel getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public ProductModel saveProduct(ProductModel bill) {
        return productRepo.save(bill);
    }

    public Boolean deleteProductById(Long id) {

        try {
            productRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public ProductModel updateProductField(Long id, Map<String, Object> updates) {
        ProductModel product;

        // Intentar obtener el producto por ID
        try {
            product = productRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Product not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el producto no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "productId":
                        product.setProductId((Long) value);
                        break;
                    case "productName":
                        product.setProductName((String) value);
                        break;
                    case "productDescription":
                        product.setProductDescription((String) value);
                        break;
                    case "productImageLink":
                        product.setProductImageLink((String) value);
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

        // Intentar guardar el producto actualizado
        try {
            return productRepo.save(product);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving product: " + e.getMessage());
            throw new RuntimeException("Error saving product", e); // Re-lanzar para permitir que el llamador maneje el
                                                                   // error
        }
    }
}
