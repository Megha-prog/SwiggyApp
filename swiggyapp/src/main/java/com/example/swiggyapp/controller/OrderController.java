package com.example.swiggyapp.controller;

import com.example.swiggyapp.model.Order;
import com.example.swiggyapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/swiggy")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/giveOrders")
    public List<Order> persistOrder(@RequestBody List<Order> order){
        return orderService.persistOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
            return orderService.getAllOrders();
    }

    @GetMapping("/order")
    public Optional<Order> getOrder(@RequestParam("orderId") Integer orderId){
        return orderService.getOrder(orderId);
    }
}
