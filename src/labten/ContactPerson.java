/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labten;

import java.sql.Date;

/**
 *
 * @author lapshop
 */

public class ContactPerson {
private int id;
private String name;
private String adress;
private String email;
private String home_phone;

    public ContactPerson(int id, String name, String adress, String home_phone, String email) {
        this.id = id;
        this.name = name;
        this.home_phone = home_phone;
        this.adress =  adress;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getaddress() {
        return adress;
    }
    public String getemail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setemail(String email) {
        this.email = email;
    }

    public void setaddress(String address) {
        this.adress = address;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }
}
