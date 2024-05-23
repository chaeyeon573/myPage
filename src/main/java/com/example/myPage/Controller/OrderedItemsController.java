package com.example.myPage.Controller;

import com.example.myPage.Entity.OrderedItems;
import com.example.myPage.Service.OrderedItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/ordered-items")
public class OrderedItemsController {
    private final OrderedItemsService orderedItemsService;

    public OrderedItemsController(OrderedItemsService orderedItemsService) {
        this.orderedItemsService = orderedItemsService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderedItems>> getOrderedItemsByUserId(@PathVariable Long userId) {
        List<OrderedItems> orderedItems = orderedItemsService.getOrderedItemsByUserId(userId);
        return ResponseEntity.ok(orderedItems);
    }
}

