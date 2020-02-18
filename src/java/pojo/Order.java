/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author fengt
 */
public class Order {
    private long id;
    private String userId;
    private Set<Dish> dishes = new HashSet<Dish>();
    
    public Order(String userId, Set<Dish> dishes) {
	this.userId = userId;
        this.dishes = dishes;
    }
    
    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

   

    

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }
    
    @Override
	public String toString() {
		return "Order [Id=" + id + ", userId=" + userId
				+ ", dishes=" + dishes + "]";
	}
    
    
    
}
