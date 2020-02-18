/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Dao.DishDao;
import Dao.OrderDao;
import Dao.OrderDetailDao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import pojo.Dish;
import pojo.Order;
import pojo.OrderDetail;
import pojo.User;



/**
 *
 * @author root
 */
public class OrderController extends SimpleFormController {
   
    
   
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
      
        HttpSession session = request.getSession();
        ModelAndView mv = null;
        Order order;
        User user;
        int n = 0;
        
        
        Set<Dish> orderDishes = new HashSet<Dish>();
        ArrayList<String> orderNumber = new ArrayList<String>();
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        OrderDao od = (OrderDao) getApplicationContext().getBean("OrderDAO");
        DishDao dd = (DishDao) getApplicationContext().getBean("DishDAO");
        OrderDetailDao odd = (OrderDetailDao) getApplicationContext().getBean("OrderDetailDAO");
        String aaa = "Add Success";
        List<Dish> dishes = dd.getAllDishes();
        user = (User) session.getAttribute("USER");
        String maxid;
        String orderid;
        try{
        orderid = od.MaxId();  
        session.setAttribute("MAX", orderid);
        for(int i = 1; i <= dishes.size();i++){  
        String id = String.valueOf(i);
        String number = request.getParameter(String.valueOf(id));
        try{
        n = Integer.parseInt(number);
        }
        catch (Exception e) {          
        } 
        if(n > 0 && n <= Integer.parseInt(dishes.get(i-1).getDishNumber())){
        orderDishes.add(dishes.get(i-1));
        od.updateOrder(dishes.get(i-1).getDishName(), number);
        orderNumber.add(String.valueOf(n));
        session.setAttribute("ON", orderNumber);
        }
        }
        }
        catch (Exception e) {     
        orderid = "1";   
        } 
        String userid = String.valueOf(user.getId());
        switch (option) {
            case "add":
                    if (od.addOrder(userid, orderDishes)==1) {      
                        mv = new ModelAndView("order","dishes", dishes);   
                    }
                    break; 
            case "view":
                    int total = 0; 
                    maxid = (String) session.getAttribute("MAX");
                    List<Dish> odish = odd.getOrderDishes(maxid);
                    ArrayList<String> s = (ArrayList<String>) session.getAttribute("ON");
                    for(int i = 0; i < odish.size(); i++){
                       odd.addOrderDetail(orderid, userid, odish.get(i).getDishName(), odish.get(i).getDishPrice(), s.get(i));
                       int a = Integer.parseInt(odish.get(i).getDishPrice());
                       int b = Integer.parseInt(s.get(i));
                       total += a * b;
                       }
                    if(total != 0){
                    String t = String.valueOf(total);
                    mv = new ModelAndView("orderDetail","dishes", odish);
                    mv.addObject("keyword", maxid);
                    List<OrderDetail> orders = odd.getOrder(orderid, userid);
                    mv = new ModelAndView("orderDetail","orders", orders);
                    mv.addObject("total", t);
                    mv.addObject("userId", userid);
                    mv.addObject("keyword", orderid);
                    }
                    else{
                    mv = new ModelAndView("error");
                    }
                    break;
            default:
               mv = new ModelAndView("order","dishes", dishes);   
        
        }
        
        
        
        
        return mv;
        
    }
  

    
    
     public OrderController() {
        setCommandClass(Order.class);
        setCommandName("Order");
        setSuccessView("success");
        setFormView("order");

    }
    
    
    
}
