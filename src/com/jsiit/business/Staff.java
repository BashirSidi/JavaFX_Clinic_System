/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.business;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author JSIIT
 */
public class Staff extends Person {
    private IntegerProperty idStaff = new SimpleIntegerProperty();
    private StringProperty role = new SimpleStringProperty();

    public Staff() {
    }
    
    public Staff(int idStaff, String role){
        this.idStaff.set(idStaff);
        this.role.set(role);
    }

    public Staff(String fName, String lName, String gender, String phoneNumber, int idStaff, String role) {
        super(fName, lName, gender, phoneNumber);
        this.idStaff.set(idStaff);
        this.role.set(role);
    }
    
    public int getIdStaff(){
        return this.idStaff.get();
    }
    
    public void setIdStaff(int idStaff){
        this.idStaff.set(idStaff);
    }
    
    public IntegerProperty idStaffPropety(){
        return this.idStaff;
    }
    
    public String getRole(){
        return this.role.get();
    }
    
    public void setRole(String role){
        this.role.set(role);
    }
    
    
    public StringProperty roleProperty(){
        return this.role;
    }

    @Override
    public String toString() {
        return "Staff{" + "idStaff=" + idStaff + ", role=" + role + '}';
    }
}
