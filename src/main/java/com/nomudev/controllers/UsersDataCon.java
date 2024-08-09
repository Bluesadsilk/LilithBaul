/*
*
* 
*
* Creada el 09 ago 2024, 20:06:32
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
import com.nomudev.models.usersDataModel;
import com.nomudev.services.UsersDataServices;

@RestController
@RequestMapping("/users_data")
public class UsersDataCon {
    @Autowired
    private UsersDataServices usersDataService;

    @GetMapping
    public List<usersDataModel> getAllUsers() {
        return usersDataService.getAllUsers();
    }

    @GetMapping("/{id}")

    public ResponseEntity<usersDataModel> getUsersById(@PathVariable Long id) {
        usersDataModel user = usersDataService.getUsersById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> de(@PathVariable Long id) {
        Boolean isDeleted = usersDataService.deleteUserById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public usersDataModel saveUser(@RequestBody usersDataModel user) {
        return usersDataService.saveUser(user);
    }

}
