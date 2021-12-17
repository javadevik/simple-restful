package com.ua.simplerestful.service;

import com.ua.simplerestful.model.Item;

import java.util.List;

public interface ItemService {

    /**
     * Create new item
     * @param item for create
     * */
    void create(Item item);

    /**
     * Read item from basket
     * @param id item returning
     * @return item
     * */
    Item read(Integer id);

    /**
     * Read all items from repository
     * @return list of items
     * */
    List<Item> readALl();

    /**
     * Update item
     * @param  id item updating
     * @param item updating
     * @return true when updating success, else false*/
    boolean update(Integer id, Item item);

    /**
     * Delete item
     * @param id item deleting
     * @return true when item deleted, else false*/
    boolean delete(Integer id);
}
