/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Dao.DishDao;
import java.util.List;
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
public class ViewController extends SimpleFormController {
   
    
   
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
      
              
        HttpSession session = request.getSession();
        ModelAndView mv = null;
        DishDao dd = (DishDao) getApplicationContext().getBean("DishDAO");
        List<Dish> dishes = dd.getAllDishes();
        mv = new ModelAndView("dishResult","dishes", dishes);
        return mv;
        
    }
  
    
    
     public ViewController() {
        setCommandClass(Dish.class);
        setCommandName("Dish");
        setSuccessView("dishResult");
        setFormView("manage");
    }
    
    
    
    
}
