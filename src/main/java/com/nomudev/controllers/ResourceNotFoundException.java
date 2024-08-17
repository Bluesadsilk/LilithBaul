/*
*
* ResourceNotFoundException.java
*
* Creada el 17 ago 2024, 3:02:03
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 17 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 17 ago 2024
*/
package com.nomudev.controllers;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
