package com.ua.simplerestful.controller;

import com.ua.simplerestful.model.Order;
import com.ua.simplerestful.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/clients/orders")
    public ResponseEntity<List<Order>> read() {
        final List<Order> orders = orderService.readAll();
        return orders != null && !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/clients/{client_id}/order")
    public ResponseEntity<Order> read(@PathVariable(name = "client_id") Integer client_id) {
        final Order order = orderService.read(client_id);
        return order != null
                ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/clients/{client_id}/order")
    public ResponseEntity<?> create(@PathVariable(name = "client_id") Integer client_id,
                                    @RequestBody Order order) {
        orderService.create(client_id, order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/clients/{client_id}/order/{order_id}")
    public ResponseEntity<?> update(@PathVariable(name = "client_id") Integer client_id,
                                    @PathVariable(name = "order_id") Integer id,
                                    @RequestBody Order order) {
        final boolean updated = orderService.update(client_id, id, order);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/clients/{client_id}/order")
    public ResponseEntity<?> delete(@PathVariable(name = "client_id") Integer client_id) {
        final boolean deleted = orderService.delete(client_id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/clients/{client_id}/order/{item_id}")
    public ResponseEntity<?> addToOrder(@PathVariable(name = "client_id") Integer client_id,
                                        @PathVariable(name = "item_id") Integer item_id) {
        orderService.addToOrder(client_id, item_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/clients/{client_id}/order/{item_id}")
    public ResponseEntity<?> removeItemFromOrder(@PathVariable(name = "client_id") Integer client_id,
                                                 @PathVariable(name = "item_id") Integer item_id) {
        final boolean itemDeleted = orderService.deleteItem(client_id, item_id);
        return itemDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
