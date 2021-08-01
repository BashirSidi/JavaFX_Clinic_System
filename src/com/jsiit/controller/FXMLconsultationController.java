/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jsiit.business.Consultation;
import com.jsiit.database.ConsultationDB;
import com.jsiit.fxml.FXMLpage;
import com.jsiit.util.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author JSIIT
 */
public class FXMLconsultationController extends BaseController implements Initializable {

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
    private Tab tabNewConsultation;

    @FXML
    private JFXTextField txtStudentIdNew;

    @FXML
    private JFXTextField txtStaffIdNew;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextArea textAreaDiagnosisNew;

    @FXML
    private JFXDatePicker jfxDatePickerDateNew;

    @FXML
    private JFXTextArea textAreaPrescriptionNew;

    @FXML
    private Tab tabViewAllConsultation;

    @FXML
    private TableView<Consultation> tableViewAllConsultation;

    @FXML
    private TableColumn<Consultation, Integer> columnConsultationID;

    @FXML
    private TableColumn<Consultation, String> columnStudentID;

    @FXML
    private TableColumn<Consultation, Integer> columnStaffId;

    @FXML
    private TableColumn<Consultation, String> columnDiagnosis;

    @FXML
    private TableColumn<Consultation, String> columnPrescription;

    @FXML
    private TableColumn<Consultation, String> columnDate;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    void handleAboutButton(ActionEvent event) throws Exception {
        navigate(event, FXMLpage.ABOUT.getPage());
    }
    
    public boolean isV(){
        Validator v = new Validator();
        return 
                v.isPresent(txtStudentIdNew, "Student ID ")&&
                v.isPresent(txtStaffIdNew, "Staff ID ")&&
                v.isInteger(txtStaffIdNew, "Staff ID ")&&
                v.isPresentTextArea(textAreaDiagnosisNew, "Diagnosis ")&&
                v.isPresentTextArea(textAreaPrescriptionNew, "Prescription ")&&
                v.isPresentDate(jfxDatePickerDateNew, "Date ");
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        Consultation c = new Consultation();
        ConsultationDB conDB = new ConsultationDB();
        if(isV()){
            c.setStudentId(txtStudentIdNew.getText());
            c.setStaffId(Integer.parseInt(txtStaffIdNew.getText()));
            c.setDiagnosis(textAreaDiagnosisNew.getText());
            c.setPrescription(textAreaPrescriptionNew.getText());
            c.setDate(jfxDatePickerDateNew.getValue());
            if(conDB.add(c)){
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setContentText("Consultation has been added successfully.");
                al.showAndWait();
                txtStudentIdNew.setText("");
                txtStaffIdNew.setText("");
                textAreaDiagnosisNew.setText("");
                textAreaPrescriptionNew.setText("");
                jfxDatePickerDateNew.setValue(null);
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Consultation did not added!!!");
                a.showAndWait();
            }
        }
    }

    @FXML
    void handleConsultationButton(ActionEvent event) throws Exception{
        navigate(event, FXMLpage.CONSULTATION.getPage());
    }

    @FXML
    void handleDrugButton(ActionEvent event) throws Exception {
        navigate(event, FXMLpage.DRUG.getPage());
    }

    @FXML
    void handleNewConsultationTab(ActionEvent event) {

    }

    @FXML
    void handlePatientButton(ActionEvent event) throws Exception{
        navigate(event, FXMLpage.PATIENT.getPage());
    }

    @FXML
    void handleSearchTextField(ActionEvent event) {

    }

    @FXML
    void handleStaffButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.STAFF.getPage());
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Consultation> consultations = FXCollections.observableArrayList();
        
        ConsultationDB cDB = new ConsultationDB();
        consultations = cDB.gets();
        Consultation c = new Consultation();
        
        columnConsultationID.setCellValueFactory(new PropertyValueFactory<>("idConsultation"));
        columnStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        columnStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        columnDiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        columnPrescription.setCellValueFactory(new PropertyValueFactory<>("prescription"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        tableViewAllConsultation.setItems(consultations);
        
        FilteredList<Consultation> filteredConsultations = new FilteredList<>(consultations, i -> true);
        txtSearch.setOnKeyReleased(e -> {
            filteredConsultations.setPredicate(new Predicate<Consultation>() {
                @Override
                public boolean test(Consultation t) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    if(txtStudentIdNew.getText() == null || txtStudentIdNew.getText().isEmpty()){
                        return true;
                    }
                        return 
                             c.getStudentId().contains(txtSearch.getText());  
                }
            });
        });
        tableViewAllConsultation.setItems(filteredConsultations);
    }    
    
}
