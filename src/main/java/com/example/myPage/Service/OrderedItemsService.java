package com.example.myPage.Service;

import com.example.myPage.Entity.Cart;
import com.example.myPage.Entity.CartItems;
import com.example.myPage.Entity.OrderHistory;
import com.example.myPage.Entity.OrderedItems;
import com.example.myPage.Repository.OrderHistoryRepository;
import com.example.myPage.Repository.OrderedItemsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderedItemsService {
    private final OrderedItemsRepository orderedItemsRepository;
    private final OrderHistoryRepository orderHistoryRepository;

    public OrderedItemsService(OrderedItemsRepository orderedItemsRepository, OrderHistoryRepository orderHistoryRepository) {
        this.orderedItemsRepository = orderedItemsRepository;
        this.orderHistoryRepository = orderHistoryRepository;
    }

    public List<OrderedItems> getOrderedItemsByUserId(Long userId) {
        List<OrderHistory> orderHistories = orderHistoryRepository.findByUserId(userId);
        List<OrderedItems> orderedItems = new ArrayList<>();

        for (OrderHistory orderHistory : orderHistories) {
            orderedItems.addAll(orderedItemsRepository.findByOrderHistoryId(orderHistory.getOrderHistoryId()));
        }

        return orderedItems;
    }

}
