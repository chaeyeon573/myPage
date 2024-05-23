package com.example.myPage.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "ordered_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderedItemsId;

    @Column(nullable = false)
    @JoinColumn(name = "orderHistoryId", referencedColumnName = "orderHistoryId")
    private Long orderHistoryId;

    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp updatedAt;


}
