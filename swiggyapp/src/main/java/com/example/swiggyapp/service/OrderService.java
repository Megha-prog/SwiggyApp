package com.example.swiggyapp.service;

import com.example.swiggyapp.model.Order;
import com.example.swiggyapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> persistOrder(List<Order> order){
        if(order.isEmpty() || order.size()==0)
            throw  new IllegalStateException("Order can not be proccessed");
        return orderRepository.saveAll(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

        public Optional<Order> getOrder(Integer orderId){
        if(orderId.equals(null))
            throw new IllegalStateException("OrderId can not be null");
        return orderRepository.findById(orderId);
    }


}
