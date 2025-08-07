package com.service;

import com.entity.Inventory;
import com.entity.Orders;
import com.entity.Product;
import com.repository.InventoryRepository;
import com.repository.OrderRepository;
import com.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    private static long orderIdCounter = 1000;

    @Transactional
    public String placeOrder(Long productId, int quantity) {
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            return "Product not found";
        }

        Inventory inventory = inventoryRepository.findByProductObj(product);
        if (inventory == null || inventory.getStock() < quantity) {
            Orders failedOrder = new Orders();
            failedOrder.setId(orderIdCounter++);
            failedOrder.setProductObj(product);
            failedOrder.setQuantity(quantity);
            failedOrder.setStatus("FAILED");
            orderRepository.save(failedOrder);
            return "Insufficient stock";
        }

        try {
            // Simulate failure by flag if needed
            boolean simulateFailure = false;
            if (simulateFailure) {
                throw new RuntimeException("Simulated failure");
            }

            inventory.setStock(inventory.getStock() - quantity);
            inventoryRepository.save(inventory);

            Orders order = new Orders();
            order.setId(orderIdCounter++);
            order.setProductObj(product);
            order.setQuantity(quantity);
            order.setStatus("PLACED");
            orderRepository.save(order);

            return "Order placed successfully";

        } catch (Exception e) {
            Orders failedOrder = new Orders();
            failedOrder.setId(orderIdCounter++);
            failedOrder.setProductObj(product);
            failedOrder.setQuantity(quantity);
            failedOrder.setStatus("FAILED");
            orderRepository.save(failedOrder);
            return "Order failed due to internal error";
        }
    }
}
