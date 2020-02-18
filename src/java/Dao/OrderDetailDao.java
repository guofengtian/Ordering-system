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
import pojo.OrderDetail;


/**
 *
 * @author shiva
 */
public class OrderDetailDao{
    
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




    public int addOrderDetail(String OrderId, String userId, String dishName, String dishPrice, String orderNumber) {
        OrderDetail od = null;
        int addSuccess = 0;
        try {
            beginTransaction();
            od = new OrderDetail();
            od.setOrderId(OrderId);
            od.setUserId(userId);
            od.setDishName(dishName);
            od.setDishPrice(dishPrice);
            od.setOrderNumber(orderNumber);
            getSession().save(od);
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
    
    public List<Dish> getOrderDishes(String orderId) {
        List<Dish> alldishes = new ArrayList<Dish>();
        try {
            beginTransaction();
            Query q= getSession().createQuery("from Dish where orderId= :orderId");
            q.setString("orderId", orderId);
            alldishes = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }
        return alldishes;
    }
    
    public List<OrderDetail> getOrder(String orderId, String userid) {
        List<OrderDetail> orders = new ArrayList<OrderDetail>();
        try {
            beginTransaction();
            Query q= getSession().createQuery("from OrderDetail where orderId= :orderId AND userid= :userid");
            q.setString("orderId", orderId);
            q.setString("userid", userid);
            orders = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }
        return orders;
    }
    
  
    
    
    
}
