/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Dao.DishDao;
import Dao.UserDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import pojo.Dish;
import pojo.User;
//import validator.UserValidator;


/**
 *
 * @author root
 */
public class UserController extends SimpleFormController {
    


    

    
   
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
      
        HttpSession session = request.getSession();
        ModelAndView mv = null;
        DishDao dd = (DishDao) getApplicationContext().getBean("DishDAO");
        List<Dish> dishes = dd.getAllDishes();
        User user;
        UserDao ud = (UserDao) getApplicationContext().getBean("UserDAO");
    
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        switch (option) {
            case "login":
                
            user = ud.authenticateLogin(userName, password);
                if (user == null) {
                    mv = new ModelAndView("index");
                } else {
   
                    session.setAttribute("USER", user);
                    mv = new ModelAndView("order","dishes", dishes);
                    
                }
                break;
            case "register":
                
                int regiesterUser = 0;
                if(userName != "" && password != "")
                {
                regiesterUser = 1;    
                }
                if (regiesterUser == 1 && ud.addUser(userName, password)== 1) {      
                user = new User(userName, password);
                session.setAttribute("USER", user);
                mv = new ModelAndView("user");
                   
                } else {
                mv = new ModelAndView("user");
                }
                break;
            default:
               mv = new ModelAndView("index");        
         
        }
 
        return mv;
    }
    
  @Override
    protected void doSubmitAction(Object user) throws Exception
    {
       UserDao ud = new UserDao();
       User userob = (User)user;
       ud.addUser(userob.getUserName(), userob.getPassword());
       ud.authenticateLogin(userob.getUserName(), userob.getPassword());
       
    }
    
    
     public UserController() {
        setCommandClass(User.class);
        setCommandName("User");
        setSuccessView("order");
        setFormView("user");
        //UserValidator uv = new UserValidator();
        //setValidator(uv);
    }
    
    
    
    
}
