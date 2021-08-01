/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.business;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author JSIIT
 */
public abstract class Person {
    private StringProperty fName = new SimpleStringProperty();
    private StringProperty lName = new SimpleStringProperty();
    private StringProperty gender = new SimpleStringProperty();
    private StringProperty phoneNumber = new SimpleStringProperty();
    
    public Person(){
        
    }
    
    public Person(String fName, String lName, String gender, String phoneNumber){
        this.fName.set(fName);
        this.lName.set(lName);
        this.gender.set(gender);
        this.phoneNumber.set(phoneNumber);
    }
    
    public String getFName(){
        return this.fName.get();
    }
    
    public void setFName(String fName){
        this.fName.set(fName);
    }
    
    public StringProperty fNameProperty(){
        return fName;
    }
    
    public String getLName(){
        return this.lName.get();
    }
    
    public void setLName(String lName){
        this.lName.set(lName);
    }
    
    public StringProperty lNameProperty(){
        return lName;
    }
    
    public String getGender(){
        return this.gender.get();
    }
    
    public void setGender(String gender){
        this.gender.set(gender);
    }
    
    public StringProperty genderProperty(){
        return gender;
    }
    
    public void setPhoneNumber(String pNumber){
        this.phoneNumber.set(pNumber);
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber.get();
    }
    
    public StringProperty phoneNumberProperty(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", phoneNumber=" + phoneNumber + '}';
    }
}
