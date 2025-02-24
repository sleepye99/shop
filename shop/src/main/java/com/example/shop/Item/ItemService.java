package com.example.shop.Item;

import com.example.shop.Category.Category;
import com.example.shop.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Item addItem(Item item, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        item.setCategory(category);
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(itemDetails.getName());
        item.setPrice(itemDetails.getPrice());
        item.setStockQuantity(itemDetails.getStockQuantity());
        return itemRepository.save(item);
    }

    public PurchaseData buyItem(Long id, int quantity){
        Item item = itemRepository.findById(id).orElseThrow(
                ()
                -> new RuntimeException("Item not found.")
        );
        if(item.getStockQuantity()<quantity){
            throw new RuntimeException("Not enough stock available you choose "+ quantity +
                    " items but there is only" + item.getStockQuantity() + " items");
        }

        double totalCost = item.getPrice() * quantity;

        item.setStockQuantity(item.getStockQuantity()-quantity);
        itemRepository.save(item);

        return new PurchaseData(item.getStockQuantity(),totalCost);


    }
}
