/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.Dish;
import pojo.Order;


/**
 *
 * @author shiva
 */
public class OrderDao{
    
    private static final SessionFactory sf = new  Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;
    private Session getSession(){
        if (session == null || !session.isOpen()){
            session = sf.openSession();
        }
        return session;
    }
   
    
    private void beginTransaction(){
        getSession().beginTransaction();
    }
    
    private void commit(){
        getSession().getTransaction().commit();;
    }
    
    
    private void close(){
        if (session !=null)
        {
            getSession().close();
        }
    }
    
    private void rollbackTransaction(){
        getSession().getTransaction().rollback();
    }
    public String MaxId(){
        String max = null;
        Order newOrder = null;
        try {
        beginTransaction();
        Query q= getSession().createQuery("from Order where id = (SELECT max(id) FROM Order)");
        newOrder = (Order)q.uniqueResult();  
        max = String.valueOf(newOrder.getId());
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }
        return max;
    }




    public int addOrder(String userId, Set<Dish> dishes) {
        Order newOrder = null;
        int addSuccess = 0;
        try {
            beginTransaction();
            newOrder = new Order();
            newOrder.setUserId(userId);
            newOrder.setDishes(dishes);
            getSession().save(newOrder);
            commit();
            addSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }

        return addSuccess;

    }
    
    public int updateOrder(String dishName, String dishNumber){
        Dish newDish = null;
        int updateSuccess = 0;
        try {
            beginTransaction();
            newDish = new Dish();
            Query q= getSession().createQuery("from Dish where dishName= :dishName");
            q.setString("dishName", dishName);
            newDish = (Dish)q.uniqueResult();
            String a = newDish.getDishNumber();
            int b = Integer.parseInt(a);
            int c = Integer.parseInt(dishNumber);
            int n = b - c;
            String result = String.valueOf(n);
            newDish.setDishNumber(result);
            if(n <=0 ){
            newDish.setDishNumber("0");
            }
            getSession().update(newDish);
            commit();
            updateSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }

        return updateSuccess;
    
    }
    
      
    
    
}
