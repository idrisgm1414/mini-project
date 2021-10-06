package com.project.mini.controller;


import com.project.mini.service.OrderService;
import com.project.mini.service.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderWrapper orderWrapper ) {
        try {
            String RegistrasiId =  orderService.createOrder(orderWrapper).getRegistrationId().toString();
            return ResponseEntity.ok("Pesanan telah diterima dengan nomor register " + RegistrasiId);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("request tidak valid");
        }
    }

    @PutMapping("/quantity")
    public ResponseEntity<?> changeQuantityByRegister(@RequestBody OrderWrapper orderWrapper) {
        try {
            return ResponseEntity.ok(orderService.changeQuantityByRegisterId(orderWrapper));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("request tidak valid");
        }
    }

    @PostMapping("/getbyname")
    public ResponseEntity<?> getAllByCustomerName(@RequestBody OrderWrapper orderWrapper) {
        try {
            return ResponseEntity.ok(orderService.getAllByCustomerName(orderWrapper));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("request tidak valid");
        }
    }
}
