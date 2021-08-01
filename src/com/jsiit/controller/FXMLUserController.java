/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jsiit.business.User;
import com.jsiit.database.UserDB;
import com.jsiit.fxml.FXMLpage;
import com.jsiit.util.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author JSIIT
 */
public class FXMLUserController extends BaseController implements Initializable {

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField txtFirstName;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtLastName;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtPassword;
    
     public boolean isV(){
        Validator v = new Validator();
        return 
               v.isPresent(txtFirstName, "First name ")&&
               v.isPresent(txtLastName, "Last name ")&&
               v.isPresent(txtUserName, "Username ")&&
               v.isPresent(txtPassword, "Password ");
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        if(isV()){
        String fName = txtFirstName.getText();
        String lName = txtLastName.getText();
        String uName = txtUserName.getText();
        String password = txtPassword.getText();
        User user = new User(fName, lName, uName, password);
        UserDB uDB = new UserDB();
        uDB.add(user);
        txtFirstName.setText("");
        txtLastName.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        }
    }

    @FXML
    void handleBackButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.LOGIN.getPage());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
