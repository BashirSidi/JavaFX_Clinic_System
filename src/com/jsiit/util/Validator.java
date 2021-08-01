/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.util;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.time.DateTimeException;
import java.time.LocalDate;
import javafx.scene.control.Alert;

/**
 *
 * @author JSIIT
 */
public class Validator {
    Alert alert;
    
    public boolean isPresentP(JFXPasswordField t, String title){
        if (t.getText().length() > 0){
            return true;
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(title+ " field is required.");
            alert.showAndWait();
            t.requestFocus();
            return false;
        }
    }
    
    public boolean isPresentTextArea(JFXTextArea t, String title){
        if(t.getText().length() > 0){
            return true;
        }else{
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText(title + "field is required.");
            al.showAndWait();
            t.requestFocus();
            return false;
        }
    }
    
    public boolean isPresentDate(JFXDatePicker d, String title){
        if(d.getValue() != null){
            return true;
        }else{
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText(title + "field is required.");
            al.showAndWait();
            d.requestFocus();
            return false;
        }
        
    }
    
    public boolean isPresent(JFXTextField t , String title){
        if(t.getText().length() > 0){
            return true;
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(title+ " field is required.");
            alert.showAndWait();
            t.requestFocus();
            return false;
        }
    }
    
     public boolean isInteger(JFXTextField t, String title){
        try{
            Integer.parseInt(t.getText());
            return true;
        }catch(NumberFormatException e){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(title +" field must be a valid integer.");
            alert.showAndWait();
            t.requestFocus();
            return false;
        }
    }
     
     public boolean isDate(JFXDatePicker d, String title){
         try{
             d.getValue();
             return true;
         }catch(DateTimeException ex){
             System.out.println(ex.getMessage());
             alert = new Alert(Alert.AlertType.ERROR);
             alert.setContentText(title + " field must be a valid date (mm/dd/yyyy).");
             alert.showAndWait();
             d.requestFocus();
             return false;
         }
     }
    
    public boolean isDouble(JFXTextField t, String title){
        try{
            Double.parseDouble(t.getText());
            return true;
        }catch(NumberFormatException e){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(title +" field must be a valid double.");
            alert.showAndWait();
            t.requestFocus();
            return false;
        }
    }
   
}
