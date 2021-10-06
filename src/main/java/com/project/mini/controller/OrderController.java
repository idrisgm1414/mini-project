package com.project.mini.controller;


import com.project.mini.service.OrderService;
import com.project.mini.service.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderWrapper orderWrapper ) {
        try {
            String RegistrasiId =  orderService.createOrder(orderWrapper).getRegistrationId().toString();
            return ResponseEntity.ok("Pesanan telah diterima dengan nomor register " + RegistrasiId);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("request tidak valid");
        }
    }

    @PutMapping("/quantity")
    public ResponseEntity<?> changeQuantityByRegister(@RequestBody String registerId, Integer quantity) {
        try {
            return ResponseEntity.ok(orderService.changeQuantityByRegisterId(registerId, quantity));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("request tidak valid");
        }
    }

    public ResponseEntity<?> getAllByCustomerName(@RequestBody String customerName) {
        try {
            return ResponseEntity.ok(orderService.getAllByCustomerName(customerName));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("request tidak valid");
        }
    }
}
