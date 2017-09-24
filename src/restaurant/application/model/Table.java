/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.application.model;

public class Table {
    
    private int tableId;
    private String name;
    private String email;
    private String phone;
    private String status;
    private int numPeople;
    
    public int getTableID() {
        return tableId;
    }
    
    public void setTableID(int i) {
        tableId = i;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String e) {
        email = e;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String p) {
        phone = p;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String s) {
        if (s.equals("empty") || s.equals("reserved") || s.equals("ordered")) {
            status = s;
        }
    }
    
    public int getNumPeople() {
        return numPeople;
    }
    
    public void setNumPeople(int n) {
        numPeople = n;
    }
}
