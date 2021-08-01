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
import com.jsiit.business.Staff;
import com.jsiit.database.StaffDB;
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
public class FXMLStaffController extends BaseController implements Initializable {

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
    private Tab tabNewStaff;

    @FXML
    private JFXTextField txtFirstNameNew;

    @FXML
    private JFXTextField txtLastNameNew;

    @FXML
    private JFXTextField txtPhoneNumberNew;

    @FXML
    private JFXTextField txtRoleNew;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXRadioButton radioMaleNew;

    @FXML
    private JFXRadioButton radioFemaleNew;

    @FXML
    private Tab tabUpdateStaff;

    @FXML
    private JFXTextField txtFirstNameUpdate;

    @FXML
    private JFXTextField txtLastNameUpdate;

    @FXML
    private JFXTextField txtPhoneNumberUpdate;

    @FXML
    private JFXTextField txtRoleUpdate;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXRadioButton radioMaleUpdate;

    @FXML
    private JFXRadioButton radioFemaleUpdate;

    @FXML
    private JFXComboBox<Integer> comboStaffIdUpdate;

    @FXML
    private Tab tabViewAllStaff;
    
    @FXML
    private TableView<Staff> tableViewAll;

    @FXML
    private TableColumn<Staff, Integer> columnStaffId;

    @FXML
    private TableColumn<Staff, String> columnFirstName;

    @FXML
    private TableColumn<Staff, String> columnLastName;

    @FXML
    private TableColumn<Staff, String> columnGender;
    
    @FXML
    private TableColumn<Staff, String> columnPhoneNumber;


    @FXML
    private TableColumn<Staff, String> columnRole;

    @FXML
    private JFXTextField txtSearch;
    
    ObservableList<Integer> staffID = FXCollections.observableArrayList();
    ObservableList<Staff> staffs = FXCollections.observableArrayList();
    

    @FXML
    void handleAboutButton(ActionEvent event)throws Exception {
         navigate(event, FXMLpage.ABOUT.getPage());

    }
    public boolean isV(){
        Validator v = new Validator();
        return 
               v.isPresent(txtFirstNameNew, "First name ")&&
               v.isPresent(txtLastNameNew, "Last name ")&&
               v.isPresent(txtPhoneNumberNew, "Phone number ")&&
               v.isPresent(txtRoleNew, "Role ");
    }
public boolean isVU(){
        Validator v = new Validator();
        return 
               v.isPresent(txtFirstNameUpdate, "First name ")&&
               v.isPresent(txtLastNameUpdate, "Last name ")&&
               v.isPresent(txtPhoneNumberUpdate, "Phone number ")&&
               v.isPresent(txtRoleUpdate, "Role ");
    }
    

    @FXML
    void handleAddButton(ActionEvent event) {
        Staff s = new Staff();
        if(this.isV()){
        s.setFName(txtFirstNameNew.getText());
        s.setLName(txtLastNameNew.getText());
        String gender;
        if(radioMaleNew.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        s.setGender(gender);
        s.setPhoneNumber(txtPhoneNumberNew.getText());
        s.setRole(txtRoleNew.getText());
        StaffDB sDB = new StaffDB();
        if(sDB.add(s)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Staff added successfully.");
            a.showAndWait();
            txtFirstNameNew.setText("");
            txtLastNameNew.setText("");
            radioMaleNew.setSelected(false);
            radioFemaleNew.setSelected(false);
            txtPhoneNumberNew.setText("");
            txtRoleNew.setText("");
            
        }else{
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setContentText("Staff did not added!!!");
            al.showAndWait();
        }
        }
    }

    @FXML
    void handleConsultationButton(ActionEvent event)throws Exception{
         navigate(event, FXMLpage.CONSULTATION.getPage());
    }

    @FXML
    void handleDrugButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.DRUG.getPage());
    }

    @FXML
    void handleNewStaffTab(ActionEvent event) {

    }

    @FXML
    void handlePatientButton(ActionEvent event)throws Exception {
         navigate(event, FXMLpage.PATIENT.getPage());
    }

    @FXML
    void handleSearchTextField(ActionEvent event) {

    }

    @FXML
    void handleStaffButton(ActionEvent event)throws Exception {
       navigate(event, FXMLpage.STAFF.getPage());
    }

    @FXML
    void handleStaffIdUpdateCombo(ActionEvent event) {
         Staff staff = staffs.get(comboStaffIdUpdate.getSelectionModel().getSelectedIndex());
         txtFirstNameUpdate.setText(staff.getFName());
            txtLastNameUpdate.setText(staff.getLName());
            String gender = staff.getGender();
            if(gender.equalsIgnoreCase("Male")){
                radioMaleUpdate.setSelected(true);
            }else{
                radioFemaleUpdate.setSelected(true);
            }
            txtPhoneNumberUpdate.setText(staff.getPhoneNumber());
            txtRoleUpdate.setText(staff.getRole());
    }


    @FXML
    void handleUpdateButton(ActionEvent event)throws Exception {
        Staff s = new Staff();
        StaffDB sDB = new StaffDB();
        if(isVU()){
        s.setFName(txtFirstNameUpdate.getText());
        s.setLName(txtLastNameUpdate.getText());
        String gender;
        if(radioMaleUpdate.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        s.setGender(gender);
        s.setPhoneNumber(txtPhoneNumberUpdate.getText());
        s.setRole(txtRoleUpdate.getText()); 
        s.setIdStaff(comboStaffIdUpdate.getSelectionModel().getSelectedItem());
        if(sDB.update(s)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Staff Updated successfully.");
            a.showAndWait();
            txtFirstNameUpdate.setText("");
            txtLastNameUpdate.setText("");
            radioMaleUpdate.setSelected(false);
            radioFemaleUpdate.setSelected(false);
            txtPhoneNumberUpdate.setText("");
            txtRoleUpdate.setText("");
            
        }else{
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setContentText("Staff did not updated!!!");
            al.showAndWait();
            }
        }
    }

    @FXML
    void handleUpdateStaffTab(ActionEvent event) {

    }

    @FXML
    void handleViewAllStaffTab(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        StaffDB sDB = new StaffDB();
       
        staffs = sDB.gets();
        for(int i = 0; i < staffs.size(); i++ ){
            staffID.add(staffs.get(i).getIdStaff());
            comboStaffIdUpdate.setItems(staffID);
        }
        
        ToggleGroup tg = new ToggleGroup();
        radioFemaleNew.setToggleGroup(tg);
        radioMaleNew.setToggleGroup(tg);
        ToggleGroup tgU = new ToggleGroup();
        radioMaleUpdate.setToggleGroup(tgU);
        radioFemaleUpdate.setToggleGroup(tgU);
        
        columnStaffId.setCellValueFactory(new PropertyValueFactory<>("idStaff"));
        columnFirstName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<>("lName"));
        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        
        tableViewAll.setItems(staffs);
        
        FilteredList<Staff> filteredStaffs = new FilteredList<>(staffs, i-> true);
        txtSearch.setOnKeyReleased(e -> {
            filteredStaffs.setPredicate(new Predicate<Staff>() {
                @Override
                public boolean test(Staff s) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   if(columnFirstName.getText() == null || columnFirstName.getText().isEmpty() ||
                      columnGender.getText() == null || columnGender.getText().isEmpty() ||
                      columnPhoneNumber.getText() == null || columnPhoneNumber.getText().isEmpty() ||
                      columnRole.getText() == null || columnRole.getText().isEmpty()){
                       return true;
                   }
                   return 
                           s.getFName().contains(txtSearch.getText()) ||
                           s.getGender().contains(txtSearch.getText()) ||
                           s.getPhoneNumber().contains(txtSearch.getText()) ||
                           s.getRole().contains(txtSearch.getText());
                }
                
            });
        });
        tableViewAll.setItems(filteredStaffs);
    }    
    
}
