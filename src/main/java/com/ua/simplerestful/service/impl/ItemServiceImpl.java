package com.ua.simplerestful.service.impl;

import com.ua.simplerestful.model.Item;
import com.ua.simplerestful.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Map<Integer, Item> ITEM_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger ITEM_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Item item) {
        final int id = ITEM_ID_HOLDER.incrementAndGet();
        item.setId(id);
        ITEM_REPOSITORY_MAP.put(id, item);
    }

    @Override
    public Item read(Integer id) {
        return ITEM_REPOSITORY_MAP.get(id);
    }

    @Override
    public List<Item> readALl() {
        return new ArrayList<>(ITEM_REPOSITORY_MAP.values());
    }

    @Override
    public boolean update(Integer id, Item item) {
        if (ITEM_REPOSITORY_MAP.containsKey(id) && item != null) {
            item.setId(id);
            ITEM_REPOSITORY_MAP.put(id, item);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return ITEM_REPOSITORY_MAP.remove(id) != null;
    }
}
