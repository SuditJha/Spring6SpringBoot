package com.controller;

import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place/{productId}/{quantity}")
    public ResponseEntity<String> placeOrder(@PathVariable Long productId, @PathVariable int quantity) {
        String result = orderService.placeOrder(productId, quantity);

        switch (result) {
            case "Order placed successfully":
                return new ResponseEntity<>(result, HttpStatus.OK);
            case "Product not found":
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            case "Insufficient stock":
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            case "Order failed due to internal error":
                return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
            default:
                return new ResponseEntity<>("Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
