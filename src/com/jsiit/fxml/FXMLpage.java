package com.jsiit.fxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;

/**
 *
 * @author JSIIT
 */
public enum FXMLpage {
    LOGIN("FXMLLogin.fxml"),
    MAIN("FXMLMain.fxml"),
    PATIENT("FXMLPatient.fxml"),
    STAFF("FXMLStaff.fxml"),
    ABOUT("FXMLabout.fxml"),
    CONSULTATION("FXMLconsultation.fxml"),
    DRUG("FXMLdrug.fxml"),
    USER("FXMLUser.fxml");
    
    private String fxmlPage;
    
    FXMLpage(String fxmlPage){
        this.fxmlPage = fxmlPage;
    }
    
    public URL getPage(){
        return getClass().getResource(fxmlPage);
    }
}
