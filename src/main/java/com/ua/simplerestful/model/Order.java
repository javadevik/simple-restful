package com.ua.simplerestful.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Integer id;
    private final Map<Integer, Item> items = new HashMap<>();
    private Double total = 0.0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.put(item.getId(), item);
    }

    public boolean removeItem(Integer item_id) {
        return items.remove(item_id) != null;
    }

    public void recountTotal() {
        items.forEach((id, item) -> total += item.getPrice());
    }
}
