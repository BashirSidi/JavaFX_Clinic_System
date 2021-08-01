/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jsiit.business.Student;
import com.jsiit.database.StudentDB;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author JSIIT
 */
public class FXMLPatientController extends BaseController implements Initializable {
    
    ObservableList<String> olProgramType = FXCollections.observableArrayList();
    ObservableList<String> olPatientID = FXCollections.observableArrayList();
    ObservableList<Student> students = FXCollections.observableArrayList();
    
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
    private Tab tabNewPatient;

    @FXML
    private JFXTextField txtFirstNameNew;

    @FXML
    private JFXTextField txtStudentIdNew;

    @FXML
    private JFXTextField txtLastNameNew;

    @FXML
    private JFXTextField txtOtherNameNew;

    @FXML
    private JFXTextField txtPhoneNumberNew;

    @FXML
    private JFXButton btnAddNew;

    @FXML
    private JFXRadioButton radioMaleNew;

    @FXML
    private JFXRadioButton radioFemaleNew;

    @FXML
    private JFXRadioButton radioNDNew;

    @FXML
    private JFXRadioButton radioInternationalNew;

    @FXML
    private Tab tabUpdatePatient;

    @FXML
    private JFXTextField txtFirstNameUpdate;

    @FXML
    private JFXTextField txtStudentIDUpdate;

    @FXML
    private JFXTextField txtLastNameUpdate;

    @FXML
    private JFXTextField txtOtherNameUpdate;

    @FXML
    private JFXTextField txtPhoneNumberUpdate;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXRadioButton radioMaleUpdate;

    @FXML
    private JFXRadioButton radioFemaleUpdate;

    @FXML
    private JFXRadioButton radioNDUpdate;

    @FXML
    private JFXRadioButton radioInternationalUpdate;

    @FXML
    private JFXComboBox<String> comboProgarmType;

    @FXML
    private JFXComboBox<String> comboPatientID;

    @FXML
    private Tab tabViewAllPatient;

    @FXML
    private TableView<Student> tablePatient;

    @FXML
    private TableColumn<Student, String> columnPatientID;

    @FXML
    private TableColumn<Student, String> columnFirstName;

    @FXML
    private TableColumn<Student, String> columnLastName;

    @FXML
    private TableColumn<Student, String> columnOtherName;

    @FXML
    private TableColumn<Student, String> columnGender;

    @FXML
    private TableColumn<Student, String> columnPhoneNumber;

    @FXML
    private TableColumn<Student, String> columnProgramType;

    @FXML
    private JFXTextField txtSearch;
     Validator v = new Validator();
     public boolean isV(){
       
        return 
               v.isPresent(txtStudentIdNew, "Studetn ID ")&&
               v.isPresent(txtFirstNameNew, "First name ")&&
               v.isPresent(txtLastNameNew, "Last name ")&&
               v.isPresent(txtPhoneNumberNew, "Phone number ");
    }
     
    public boolean isVU(){
        return 
                v.isPresent(txtStudentIDUpdate, "Student ID ")&&
                v.isPresent(txtFirstNameUpdate, "First Name ")&&
                v.isPresent(txtLastNameUpdate, "Last name ")&&
                v.isPresent(txtPhoneNumberUpdate, "Phone number ");
    }

    @FXML
    void handleAboutButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.ABOUT.getPage());
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        Student s = new Student();
        if(this.isV()){
        s.setIdStudent(txtStudentIdNew.getText());
        s.setFName(txtFirstNameNew.getText());
        s.setLName(txtLastNameNew.getText());
        s.setOtherName(txtOtherNameNew.getText());
        s.setPhoneNumber(txtPhoneNumberNew.getText());
        String pType;
        if (radioNDNew.isSelected()){
            pType = "National";
        }else{
            pType = "International";
        }
        s.setProgramType(pType);
        String gender;
        if(radioMaleNew.isSelected()){
            gender = "male";
        }else{
            gender = "female";
        }
        s.setGender(gender);
        
        StudentDB sDB = new StudentDB();
        if(sDB.add(s)){
            txtStudentIdNew.setText("");
            txtFirstNameNew.setText("");
            txtLastNameNew.setText("");
            txtOtherNameNew.setText("");
            txtPhoneNumberNew.setText("");
            radioNDNew.setSelected(false);
            radioInternationalNew.setSelected(false);
            radioFemaleNew.setSelected(false);
            radioMaleNew.setSelected(false);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Successfully Added");
            a.showAndWait();
        }else{
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Patient has not been added to database!!!");
            a.showAndWait();
        }
        }
    }
    

    @FXML
    void handleConsultationButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.CONSULTATION.getPage());
    }

    @FXML
    void handleDrugButton(ActionEvent event) throws Exception {
         navigate(event, FXMLpage.DRUG.getPage());
    }

    @FXML
    void handleFemaleRadioButtonNew(ActionEvent event) {

    }

    @FXML
    void handleFemaleRadioButtonUpdate(ActionEvent event) {

    }

    @FXML
    void handleInternationalNewRadio(ActionEvent event) {

    }

    @FXML
    void handleInternationalUpdateRadio(ActionEvent event) {

    }

    @FXML
    void handleMaleRadioButtonNew(ActionEvent event) {

    }

    @FXML
    void handleMaleRadioButtonUpdate(ActionEvent event) {

    }

    @FXML
    void handleNDNewRadio(ActionEvent event) {

    }

    @FXML
    void handleNDupdateRadio(ActionEvent event) {

    }

    @FXML
    void handleNewPatientTab(ActionEvent event) {

    }

    @FXML
    void handlePatientButton(ActionEvent event)throws Exception {
         navigate(event, FXMLpage.PATIENT.getPage());
    }

    @FXML
    void handlePatientIdCombo(ActionEvent event) {
        Student student = students.get(comboPatientID.getSelectionModel().getSelectedIndex());
        
        System.out.println(student.toString());
        txtStudentIDUpdate.setText(student.getIdStudent());
        txtFirstNameUpdate.setText(student.getFName());
        txtLastNameUpdate.setText(student.getLName());
        txtOtherNameUpdate.setText(student.getOtherName());
        String gender = student.getGender();
        if(gender.equals("male")){
            radioMaleUpdate.setSelected(true);
        }else{
            radioFemaleUpdate.setSelected(true);
        }
        txtPhoneNumberUpdate.setText(student.getPhoneNumber());
        String pType = student.getProgramType();
        if(pType.equals("National")){
            radioNDUpdate.setSelected(true);
        }else{
            radioInternationalUpdate.setSelected(true);
        }
        System.out.println("Im here");
            System.out.println(student.getIdStudent()+" "+student.getFName()+" "+student.getLName()+" "+student.getGender()+" "+student.getPhoneNumber()
            +" "+student.getProgramType());
    }

    @FXML
    void handleProgramTypeCombo(ActionEvent event) {
        StudentDB sDB = new StudentDB();
        
        
        if(comboProgarmType.getSelectionModel().getSelectedItem().equalsIgnoreCase("National")){
            
          students =  sDB.getNational();
          for(int i = 0; i < students.size(); i++){
              olPatientID.add(students.get(i).getIdStudent());
               comboPatientID.setItems(olPatientID);
          }
         
        }else{
            students =  sDB.getInternational();
          for(int i = 0; i < students.size() ; i++){
              olPatientID.add(students.get(i).getIdStudent());
              comboPatientID.setItems(olPatientID);
          }
          
        }
    }

    @FXML
    void handleSearchTextField(ActionEvent event) {

    }

    @FXML
    void handleStaffButton(ActionEvent event)throws Exception {
         navigate(event, FXMLpage.STAFF.getPage());
    }

    @FXML
    void handleUpdateButton(ActionEvent event)throws Exception {
         Student s = new Student();
        if(this.isVU()){
        s.setIdStudent(txtStudentIDUpdate.getText());
        s.setFName(txtFirstNameUpdate.getText());
        s.setLName(txtLastNameUpdate.getText());
        s.setOtherName(txtOtherNameUpdate.getText());
        s.setPhoneNumber(txtPhoneNumberUpdate.getText());
        String pType;
        if (radioNDUpdate.isSelected()){
            pType = "National";
        }else{
            pType = "International";
        }
        s.setProgramType(pType);
        String gender;
        if(radioMaleUpdate.isSelected()){
            gender = "male";
        }else{
            gender = "female";
        }
        s.setGender(gender);
            
        StudentDB sDB = new StudentDB();
        if(sDB.update(s)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Sucessfully Updated");
            a.showAndWait();
            txtStudentIDUpdate.setText("");
            txtFirstNameUpdate.setText("");
            txtLastNameUpdate.setText("");
            txtOtherNameUpdate.setText("");
            txtPhoneNumberUpdate.setText("");
            radioNDUpdate.setSelected(false);
            radioInternationalUpdate.setSelected(false);
            radioFemaleUpdate.setSelected(false);
            radioMaleUpdate.setSelected(false);
        }else{
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Patient has not been updated to database!!!");
            a.showAndWait();
        }
        }
    }

    @FXML
    void handleUpdatePatientTab(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup tgGender = new ToggleGroup();
        radioFemaleNew.setToggleGroup(tgGender);
        radioMaleNew.setToggleGroup(tgGender);
        ToggleGroup tgGenderU = new ToggleGroup();
        radioFemaleUpdate.setToggleGroup(tgGenderU);
        radioMaleUpdate.setToggleGroup(tgGenderU);
        ToggleGroup tgPtypeU = new ToggleGroup();
        radioNDUpdate.setToggleGroup(tgPtypeU);
        radioInternationalUpdate.setToggleGroup(tgPtypeU);
        ToggleGroup tgPtype = new ToggleGroup();
        radioNDNew.setToggleGroup(tgPtype);
        radioInternationalNew.setToggleGroup(tgPtype);
        olProgramType.add("International");
        olProgramType.add("National");
        comboProgarmType.setItems(olProgramType);
        
        columnPatientID.setCellValueFactory(new PropertyValueFactory<>("idStudent"));
        columnFirstName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<>("lName"));
        columnOtherName.setCellValueFactory(new PropertyValueFactory<>("otherName"));
        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnProgramType.setCellValueFactory(new PropertyValueFactory<>("programType"));
        
        StudentDB sDB = new StudentDB();
        students = sDB.gets();
        tablePatient.setItems(students);
        
        FilteredList<Student> filteredPatients = new FilteredList<>(students, i-> true);
        txtSearch.setOnKeyReleased(e -> {
           filteredPatients.setPredicate(new Predicate<Student>() {
               @Override
               public boolean test(Student s) {
                   //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   if(columnFirstName.getText() == null || columnFirstName.getText().isEmpty() ||
                      columnProgramType.getText() == null || columnProgramType.getText().isEmpty() ||
                      columnGender.getText() == null || columnGender.getText().isEmpty() ||
                      columnPatientID.getText() == null || columnFirstName.getText().isEmpty()){
                   return true;
               }
                   return 
                      s.getFName().contains(txtSearch.getText())||
                      s.getProgramType().contains(txtSearch.getText())||
                      s.getProgramType().contains(txtSearch.getText())||
                      s.getIdStudent().contains(txtSearch.getText());
               }
           });
          
           
        });
        tablePatient.setItems(filteredPatients);
    } 
    
}

