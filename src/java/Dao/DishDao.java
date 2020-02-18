/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.Dish;
import pojo.User;

/**
 *
 * @author shiva
 */
public class DishDao{
    
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
    
    


    public List<Dish> getAllDishes() {
        List<Dish> alldishes = new ArrayList<Dish>();
        try {
            beginTransaction();
            Query q= getSession().createQuery("from Dish");
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

    public int addDish(String dishName, String dishNumber, String dishPrice) {
        Dish newDish = null;
        int addSuccess = 0;
        try {
            beginTransaction();
            
            newDish = new Dish();
            newDish.setDishName(dishName);
            newDish.setDishNumber(dishNumber);
            newDish.setDishPrice(dishPrice);
            getSession().save(newDish);
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
    
    public int updateDish(String dishName,  String dishNumber, String dishPrice){
        Dish newDish = null;
        int updateSuccess = 0;
        try {
            beginTransaction();
            newDish = new Dish();
            Query q= getSession().createQuery("from Dish where dishName= :dishName");
            q.setString("dishName", dishName);
            newDish = (Dish)q.uniqueResult();
            newDish.setDishNumber(dishNumber);
            newDish.setDishPrice(dishPrice);
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
