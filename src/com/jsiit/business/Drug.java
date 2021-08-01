/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.business;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author JSIIT
 */
public class Drug {
    private IntegerProperty idDrug  = new SimpleIntegerProperty();
    private StringProperty drugName = new SimpleStringProperty();
    private StringProperty category = new SimpleStringProperty();
    private StringProperty drugDesc = new SimpleStringProperty();
    private LocalDate arrivalDate;
    private LocalDate expiryDate;
    private IntegerProperty quantity = new SimpleIntegerProperty();
    
    public Drug(){
        
    }
    
    public Drug(int idDrug, String drugName, String category, String drugDesc, LocalDate arrivalDate, LocalDate expiryDate, int quantity){
        this.idDrug.set(idDrug);
        this.drugName.set(drugName);
        this.category.set(category);
        this.drugDesc.set(drugDesc);
        this.arrivalDate = arrivalDate;
        this.expiryDate = expiryDate;
        this.quantity.set(quantity);
        
    }
    
    public int getIdDrug(){
        return this.idDrug.get();
    }
    
    public void setIdDrug(int idDrug){
        this.idDrug.set(idDrug);
    }
    
    public IntegerProperty idDrugProperty(){
        return this.idDrug;
    }
    
    public String getDrugName(){
        return this.drugName.get();
    }
    
    public void setDrugName(String drugName){
        this.drugName.set(drugName);
    }
    
    public StringProperty drugNameProperty(){
        return drugName;
    }
    
    public String getCategory(){
        return this.category.get();
    }
    
    public void setCategory(String category){
        this.category.set(category);
    }
    
    public StringProperty categoryProperty(){
        return this.category;
    }
    
    public String getDrugDesc(){
        return this.drugDesc.get();
    }
    
    public void setDrugDesc(String drugDesc){
        this.drugDesc.set(drugDesc);
    }
    
    public StringProperty drugDescProperty(){
        return this.drugDesc;
    }
    
    public LocalDate getArrivalDate(){
        return this.arrivalDate;
    }
    
    public void setArrivalDate(LocalDate arrivalDate){
        this.arrivalDate = arrivalDate;
    }
    
    public LocalDate getExpiryDate(){
        return this.expiryDate;
    }
    
    public void setExpiryDate(LocalDate expiryDate){
        this.expiryDate = expiryDate;
    }
    
    public int getQuantity(){
        return this.quantity.get();
    }
    
    public void setQuantity(int quantity){
        this.quantity.set(quantity);
    }
    
    public IntegerProperty quantityProperty(){
        return this.quantity;
    }

    @Override
    public String toString() {
        return "Drug{" + "idDrug=" + idDrug + ", drugName=" + drugName + ", category=" + category + ", drugDesc=" + drugDesc + ", arrivalDate=" + arrivalDate + ", expiryDate=" + expiryDate + ", quantity=" + quantity + '}';
    }         
}