/*
*
* 
*
* Creada el 08 ago 2024, 14:32:06
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 08 ago 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 08 ago 2024
*/
package com.nomudev.services;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nomudev.models.BillModel;
import com.nomudev.repositories.IBillRepo;

@Service
public class BillServices {
    @Autowired
    IBillRepo billRepo;

    public List<BillModel> getAllBills() {
        return billRepo.findAll();
    }

    public BillModel getBillById(Long id) {
        return billRepo.findById(id).orElse(null);
    }

    public BillModel saveBill(BillModel bill) {
        return billRepo.save(bill);
    }

    public Boolean deleteBillById(Long id) {

        try {
            billRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public BillModel updateBillField(Long id, Map<String, Object> updates) {
        BillModel bill;

        // Intentar obtener el bill por ID
        try {
            bill = billRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Bill not found with id " + id));
        } catch (NoSuchElementException e) {
            // Manejar el caso cuando el bill no se encuentra
            System.err.println(e.getMessage());
            throw e; // Re-lanzar para permitir que el llamador maneje el error
        }

        // Intentar actualizar los campos
        try {
            updates.forEach((field, value) -> {
                switch (field) {
                    case "billId":
                        bill.setBillId((Long) value);
                        break;
                    case "billEntityType":
                        bill.setBillEntityType((String) value);
                        break;
                    case "billLastName":
                        bill.setBillAmount((Float) value);
                        break;
                    case "billNif":
                        bill.setBillDate((Date) value);
                        break;
                    case "billEmail":
                        bill.setBillImageLink((String) value);
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

        // Intentar guardar el bill actualizado
        try {
            return billRepo.save(bill);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el guardado
            System.err.println("Error saving bill: " + e.getMessage());
            throw new RuntimeException("Error saving bill", e); // Re-lanzar para permitir que el llamador maneje el
                                                                // error
        }
    }
}
