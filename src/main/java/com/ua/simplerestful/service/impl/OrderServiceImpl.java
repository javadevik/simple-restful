package com.ua.simplerestful.service.impl;

import com.ua.simplerestful.model.Item;
import com.ua.simplerestful.model.Order;
import com.ua.simplerestful.service.ItemService;
import com.ua.simplerestful.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Map<Integer, Order> ORDERS_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger ORDER_ID_HOLDER = new AtomicInteger();
    private final ItemService itemService;

    @Autowired
    public OrderServiceImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public void create(Integer client_id, Order order) {
        final int id = ORDER_ID_HOLDER.incrementAndGet();
        order.setId(id);
        ORDERS_REPOSITORY_MAP.put(client_id, order);
    }

    @Override
    public List<Order> readAll() {
        return new ArrayList<>(ORDERS_REPOSITORY_MAP.values());
    }

    @Override
    public Order read(Integer client_id) {
        return ORDERS_REPOSITORY_MAP.get(client_id);
    }

    @Override
    public boolean update(Integer client_id, Integer id, Order order) {
        if (ORDERS_REPOSITORY_MAP.containsKey(client_id)) {
            order.setId(id);
            ORDERS_REPOSITORY_MAP.put(client_id, order);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer client_id) {
        return ORDERS_REPOSITORY_MAP.remove(client_id) != null;
    }

    @Override
    public void addToOrder(Integer client_id, Integer item_id) {
        final Item item = itemService.read(item_id);
        ORDERS_REPOSITORY_MAP.get(client_id).addItem(item);
    }

    @Override
    public boolean deleteItem(Integer client_id, Integer item_id) {
        return ORDERS_REPOSITORY_MAP.get(client_id).removeItem(item_id);
    }
}
