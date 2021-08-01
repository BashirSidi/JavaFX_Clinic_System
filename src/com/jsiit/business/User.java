/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.business;

import impl.org.controlsfx.i18n.SimpleLocalizedStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author JSIIT
 */
public class User {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty userName = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    
    public User(){
        
    }
    
    public User(int id, String firstName, String lastName, String userName, String password){
        this.id.set(id);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.userName.set(userName);
        this.password.set(password);
    }
    
    public User(String userName, String password) {
        this.userName.set(userName);
        this.password.set(password);
    }
    
    public User(String firstName, String lastName, String userName, String password){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.userName.set(userName);
        this.password.set(password);
    }
    
    public int getId(){
        return this.id.get();
    }
    
    public void setId(int id){
        this.id.set(id);
    }
    
    public IntegerProperty idProperty(){
        return this.id;
    }
    
    public String getFirstName(){
        return this.firstName.get();
    }
    
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    
    public StringProperty firstNameProperty(){
        return this.firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }
    
    public String getLastName(){
        return this.lastName.get();
    }
    
    public StringProperty lastNameProperty(){
        return this.lastName;
    }
    
    public void setUserName(String userName){
        this.userName.set(userName);
    }
    
    public String getUserName(){
        return this.userName.get();
    }
    
    public StringProperty userNameProperty(){
        return this.userName;
    }
    
    public void setPassword(String password){
        this.setFirstName(password);
    }
    
    public String getPassword(){
        return this.password.get();
    }
    
    public StringProperty passwordProperty(){
        return this.password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + '}';
    }
    
    
}
