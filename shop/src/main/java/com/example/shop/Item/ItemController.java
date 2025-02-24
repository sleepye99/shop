package com.example.shop.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/{categoryId}")
    public Item addItem(@PathVariable Long categoryId, @RequestBody Item item) {
        return itemService.addItem(item, categoryId);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @PostMapping("/{id}/buy")
    public PurchaseData buyItem(@PathVariable Long id, @RequestParam int quantity){
        return itemService.buyItem(id,quantity);
    }
}
