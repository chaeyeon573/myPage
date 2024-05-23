package com.example.myPage.Controller;

import com.example.myPage.Entity.MergedOrderedItems;
import com.example.myPage.Entity.OrderedItems;
import com.example.myPage.Service.MergedOrderedItemsService;
import com.example.myPage.Service.OrderedItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private MergedOrderedItemsService mergedOrderedItemsService;

    @PostMapping
    public ResponseEntity<MergedOrderedItems> createOrder() {
        MergedOrderedItems mergedOrderedItems = new MergedOrderedItems();
        mergedOrderedItemsService.saveMergedOrderedItem(mergedOrderedItems);
        return new ResponseEntity<>(mergedOrderedItems, HttpStatus.CREATED);
    }
}

