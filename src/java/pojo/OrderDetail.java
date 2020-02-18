/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author fengt
 */
public class OrderDetail {
    private long id;
    private String OrderId;
    private String userId;
    private String dishName;
    private String dishPrice;
    private String orderNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public OrderDetail(String OrderId, String userId, String dishName, String dishPrice, String orderNumber) {
        this.OrderId = OrderId;
        this.userId = userId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.orderNumber = orderNumber;
    }
    
    public OrderDetail() {
    }
    
    
    
}
