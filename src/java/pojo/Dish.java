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
public class Dish {
    private long id;
    private String dishName;
    private String dishNumber;
    private String dishPrice;
    
    public Dish() {
    }

    public Dish(String dishName) {
	this.dishName = dishName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(String dishNumber) {
        this.dishNumber = dishNumber;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }
    

     
     public Dish(String dishName, String dishNumber, String dishPrice) {
        this.dishName = dishName;
        this.dishNumber = dishNumber;
        this.dishPrice = dishPrice;
    }
    
    
    
    
}
