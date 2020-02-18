/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author fengt
 */

import java.sql.Date;

/**
 *
 * @author fengt
 */
public class Admin {
    private long id;
    private String adminName;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    

    

     public Admin() {

     }
     
     public Admin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    
    
    

    

    

    
}
