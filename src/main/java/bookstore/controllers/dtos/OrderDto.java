package bookstore.controllers.dtos;

import bookstore.models.entities.*;

import java.util.*;

public class OrderDto {
    private Double amount;
    private String orderDate;

    public OrderDto(Double amount, String orderDate) {
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
