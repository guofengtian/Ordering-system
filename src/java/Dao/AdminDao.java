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
import pojo.Admin;


/**
 *
 * @author shiva
 */
public class AdminDao{
    
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

    public Admin authenticateLogin(String adminName, String password) {      
        Admin loggedInAdmin =null;
        
        try {
            beginTransaction();
            Query q= getSession().createQuery("from Admin where adminName= :adminName AND password= :password");
            q.setString("adminName", adminName);
            q.setString("password", password);
            loggedInAdmin = (Admin)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }

        return loggedInAdmin;
    }


    public int addAdmin(String adminName, String password) {
        Admin newAdmin = null;
        int registerSuccess = 0;
        try {
            beginTransaction();
            
            newAdmin = new Admin();
            newAdmin.setAdminName(adminName);
            newAdmin.setPassword(password);
            getSession().save(newAdmin);
            commit();
            registerSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }

        return registerSuccess;

    }
    
    
    
}
