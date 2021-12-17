package com.ua.simplerestful.service;

import com.ua.simplerestful.model.Order;

import java.util.List;

public interface OrderService {

    /**
     * Create a new order
     * @param client_id client
     * @param order order to create
     * */
    void create(Integer client_id, Order order);

    /**
     * Return all client's orders
     * @return list of orders
     * */
    List<Order> readAll();

    /**
     * Return client's order by id
     * @param client_id whom order will return
     * @return client's order
     * */
    Order read(Integer client_id);

    /**
     * Update order information
     * @param client_id whom order will be update
     * @param id order's id
     * @param order order to change
     * @return true if updated, else return false
     * */
    boolean update(Integer client_id, Integer id, Order order);

    /**
     * Delete order
     * @param client_id client which order delete
     * @return true if deleted, else false
     * */
    boolean delete(Integer client_id);

    /**
     * Add item to order
     * @param order_id order to adding item
     * @param item_id to add
     * */
    void addToOrder(Integer order_id, Integer item_id);

    /**
     * Delete item from order
     * @param client_id client from order delete
     * @param item_id item to delete
     * @return true if item deleted, else false
     * */
    boolean deleteItem(Integer client_id, Integer item_id);
}
