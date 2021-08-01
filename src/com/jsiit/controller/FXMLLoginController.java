package com.jsiit.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Alert;

/**
 *
 * @author JSIIT
 */
public class FXMLLoginController extends BaseController implements Initializable {
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;
    

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnNew;
    
  

    @FXML
    void handleClearButton(ActionEvent event) {

    }
    
      public boolean isV(){
        Validator v = new  Validator();
        return 
                v.isPresent(txtUserName, "Username ")&&
                v.isPresentP(txtPassword, "Password ");
    }

    @FXML
    void handleLoginButton(ActionEvent event) throws Exception {
       if(isV()){
       String username = txtUserName.getText();
       String password = txtPassword.getText();
       User user = new User(username, password);
       UserDB userdb = new UserDB();
       boolean isUser = userdb.login(user.getUserName(), user.getPassword());
       
       if(isUser) {
          navigate(event, FXMLpage.PATIENT.getPage());
       } else {
           Alert a;
           a = new Alert(Alert.AlertType.ERROR);
           a.setContentText("Invalid Username or Password!!!");
           a.showAndWait();
           txtUserName.requestFocus();
    
            }
       }
    }

    @FXML
    void handleNewButton(ActionEvent event) throws Exception{
        //navigate(event, FXMLpage.USER.getPage());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
