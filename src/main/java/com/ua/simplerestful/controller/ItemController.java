package com.ua.simplerestful.controller;

import com.ua.simplerestful.model.Item;
import com.ua.simplerestful.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> readAll() {
        final List<Item> items = itemService.readALl();
        return items != null && !items.isEmpty()
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/items/{items_id}")
    public ResponseEntity<Item> read(@PathVariable(name = "items_id") Integer id) {
        final Item item = itemService.read(id);
        return item != null
                ? new ResponseEntity<>(item, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/items")
    public ResponseEntity<?> create(@RequestBody Item item) {
        itemService.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/items/{items_id}")
    public ResponseEntity<?> update(@PathVariable(name = "items_id") Integer id,
                                    @RequestBody Item item) {
        final boolean updated = itemService.update(id, item);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/items/{items_id}")
    public ResponseEntity<?> delete(@PathVariable(name = "items_id") Integer id) {
        final boolean deleted = itemService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
