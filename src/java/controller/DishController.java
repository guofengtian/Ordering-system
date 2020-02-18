/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Dao.DishDao;
import Dao.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import pojo.Dish;





/**
 *
 * @author root
 */
public class DishController extends SimpleFormController {
    


    

    
   
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
      
              
        HttpSession session = request.getSession();
        ModelAndView mv = null;
        Dish dish;
        DishDao dd = (DishDao) getApplicationContext().getBean("DishDAO");        
        String dishName = request.getParameter("dishName");
        String dishNumber = request.getParameter("dishNumber");
        String dishPrice = request.getParameter("dishPrice");
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        switch (option) {
            case "update":
                try{
                int a = Integer.parseInt(dishNumber); 
                int b = Integer.parseInt(dishPrice);
                    
                int update = 0;
                if(dishName != "" && dishNumber != "" && dishPrice != "")
                {
                update = 1;    
                }
                if (update == 1 && dd.updateDish(dishName, dishNumber, dishPrice)==1){
                    mv = new ModelAndView("manage");
                } else {
                    mv = new ModelAndView("error");
                }
                break;
                }
                catch (Exception e) {          
                  mv = new ModelAndView("error");
                  break;
                } 
             
            case "add":
                try{
                int a = Integer.parseInt(dishNumber); 
                int b = Integer.parseInt(dishPrice);
                int add = 0;
                if(dishName != "" && dishNumber != "" && dishPrice != "")
                {
                add = 1;    
                }
            
                if (add == 1 && dd.addDish(dishName,dishNumber,dishPrice)==1) {      
                    dish = new Dish(dishName,dishNumber,dishPrice);
                    session.setAttribute("DISH", dish);
                    mv = new ModelAndView("manage");
                    
                } else {
                    mv = new ModelAndView("error");
                }
                break;
                }
                catch (Exception e) {          
                  mv = new ModelAndView("error");
                  break;
                } 
            default:
                mv = new ModelAndView("manage");      
            
        }
 
        return mv;
    }
    
  @Override
    protected void doSubmitAction(Object dish) throws Exception
    {
       DishDao dd = new DishDao();
       Dish dishob = (Dish)dish;
       dd.addDish(dishob.getDishName(), dishob.getDishNumber(), dishob.getDishPrice());
       
       
    }
    
    
     public DishController() {
        setCommandClass(Dish.class);
        setCommandName("Dish");
        setSuccessView("dishManage");
        setFormView("manage");
        
    }
    
    
    
    
}
