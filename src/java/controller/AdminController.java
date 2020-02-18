/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Dao.AdminDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import pojo.Admin;
//import validator.AdminValidator;


/**
 *
 * @author root
 */
public class AdminController extends SimpleFormController {
    


    

    
   
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
      
              
        HttpSession session = request.getSession();
        ModelAndView mv = null;
        Admin admin;
        AdminDao ad = (AdminDao) getApplicationContext().getBean("AdminDAO");
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("password");
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        switch (option) {
            case "login":
                
            admin = ad.authenticateLogin(adminName, password);
                if (admin == null) {
                    mv = new ModelAndView("admin");
                } else {
                    session.setAttribute("ADMIN", admin);
                    mv = new ModelAndView(new RedirectView("dishManage.htm", false));
                }
                break;
            case "register":
                
                int regiesterAdmin = 0;
                if(adminName != "" && password != "")
                {
                regiesterAdmin = 1;    
                }
                if (ad.addAdmin(adminName, password) == 1 && regiesterAdmin == 1) {      
                admin = new Admin(adminName, password);
                session.setAttribute("ADMIN", admin);
                mv = new ModelAndView("admin");
                   
                } else {
                mv = new ModelAndView("admin");
                }
                break;
            //default:
               // mv = new ModelAndView("index");            //default:
               // mv = new ModelAndView("index");            //default:
               // mv = new ModelAndView("index");            //default:
               // mv = new ModelAndView("index");
   
            
        }
 
        return mv;
    }
    
  @Override
    protected void doSubmitAction(Object admin) throws Exception
    {
       AdminDao ad = new AdminDao();
       Admin adminob = (Admin)admin;
       ad.addAdmin(adminob.getAdminName(), adminob.getPassword());
       ad.authenticateLogin(adminob.getAdminName(), adminob.getPassword());
       
    }
    
    
     public AdminController() {
        setCommandClass(Admin.class);
        setCommandName("Admin");
        setSuccessView("manage");
        setFormView("admin");
        //AdminValidator av = new AdminValidator();
        //setValidator(av);
    }
    
    
    
    
}
