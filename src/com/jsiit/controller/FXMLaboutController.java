/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.controller;

import com.jfoenix.controls.JFXButton;
import com.jsiit.fxml.FXMLpage;
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
public class FXMLaboutController extends BaseController implements Initializable {

     @FXML
    private JFXButton btnPatient;

    @FXML
    private JFXButton btnStaff;

    @FXML
    private JFXButton btnDrug;

    @FXML
    private JFXButton btnConsultation;

    @FXML
    private JFXButton btnAbout;

    @FXML
    void handleAboutButton(ActionEvent event) throws Exception {
        navigate(event, FXMLpage.ABOUT.getPage());
    }

    @FXML
    void handleConsultationButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.CONSULTATION.getPage());
    }

    @FXML
    void handleDrugButton(ActionEvent event) throws Exception{
        navigate(event, FXMLpage.DRUG.getPage());
    }

    @FXML
    void handlePatientButton(ActionEvent event) throws Exception{
        navigate(event, FXMLpage.PATIENT.getPage());
    }

    @FXML
    void handleStaffButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.STAFF.getPage());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
