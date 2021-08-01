/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jsiit.business.Drug;
import com.jsiit.database.DrugDB;
import com.jsiit.fxml.FXMLpage;
import com.jsiit.util.Validator;
import java.net.URL;
import java.time.LocalDate;
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
public class FXMLdrugController extends BaseController implements Initializable {

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
    private Tab tabNewDrug;

    @FXML
    private JFXTextField txtDrugNameNew;

    @FXML
    private JFXTextField txtCategoryNew;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtQuantityNew;

    @FXML
    private JFXTextArea txtDrugDescriptionNew;

    @FXML
    private JFXDatePicker jfxDatePickerArrivalDateNew;

    @FXML
    private JFXDatePicker jfxDatePickerExpiryDateNew;

    @FXML
    private Tab tabUpdateDrug;

    @FXML
    private JFXComboBox<Integer> comboDrugID;

    @FXML
    private JFXTextField txtDrugNameUpdate;

    @FXML
    private JFXTextField txtCategoryUpdate;

    @FXML
    private JFXTextField txtQuantityUpdate;

    @FXML
    private JFXTextArea txtDrugDescriptionUpdate;

    @FXML
    private JFXDatePicker jfxDatePickerArrivalDateUpdate;

    @FXML
    private JFXDatePicker jfxDatePickerExpiryDateUpdate;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Tab tabViewAllDrug;

    @FXML
    private TableView<Drug> tableViewAllDrug;

    @FXML
    private TableColumn<Drug, Integer> columnDrugId;

    @FXML
    private TableColumn<Drug, String> columnDrugName;

    @FXML
    private TableColumn<Drug, String> columnCategoryName;

    @FXML
    private TableColumn<Drug, String> columnDrugDescription;

    @FXML
    private TableColumn<Drug, LocalDate> columnArrivalDate;

    @FXML
    private TableColumn<Drug, LocalDate> columnExpiryDate;

    @FXML
    private TableColumn<Drug, Integer> columnQuantity;

    @FXML
    private JFXTextField txtSearch;
    
    ObservableList<Drug> drugs = FXCollections.observableArrayList();
    ObservableList<Integer> drugID = FXCollections.observableArrayList();
    

    @FXML
    void hadleConsultationButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.CONSULTATION.getPage());
    }

    @FXML
    void handleAboutButton(ActionEvent event)throws Exception {
        navigate(event, FXMLpage.ABOUT.getPage());
    }
    public boolean isV(){
        Validator v = new Validator();
        return
                v.isPresent(txtDrugNameNew, "Drug name ")&&
                v.isPresent(txtCategoryNew, "Category ")&&
                v.isPresentTextArea(txtDrugDescriptionNew, "Drug description ")&&
                v.isPresentDate(jfxDatePickerArrivalDateNew, "Arrival date ")&&
                v.isDate(jfxDatePickerArrivalDateNew, "Arrival date ")&&
                v.isPresentDate(jfxDatePickerExpiryDateNew, "Expiry date ")&&
                v.isDate(jfxDatePickerExpiryDateNew, "Expiry date ")&&
                v.isPresent(txtQuantityNew, "Quantity ")&&
                v.isInteger(txtQuantityNew, "Quantity ");
    }
    
    public boolean isVU(){
        Validator v = new Validator();
        return
                v.isPresent(txtDrugNameUpdate, "Drug name ")&&
                v.isPresent(txtCategoryUpdate, "Category ")&&
                v.isPresentTextArea(txtDrugDescriptionUpdate, "Drug description ")&&
                v.isPresentDate(jfxDatePickerArrivalDateUpdate, "Arrival date ")&&
                v.isDate(jfxDatePickerArrivalDateUpdate, "Arrival date ")&&
                v.isPresentDate(jfxDatePickerExpiryDateUpdate, "Expiry date ")&&
                v.isDate(jfxDatePickerExpiryDateUpdate, "Expiry date ")&&
                v.isPresent(txtQuantityUpdate, "Quantity ")&&
                v.isInteger(txtQuantityUpdate, "Quantity ");
    }
    

    @FXML
    void handleAddButton(ActionEvent event) {
        DrugDB dDB = new DrugDB();
        Drug d = new Drug();
        if(isV()){
           d.setDrugName(txtDrugNameNew.getText());
           d.setCategory(txtCategoryNew.getText());
           d.setDrugDesc(txtDrugDescriptionNew.getText());
           d.setArrivalDate(jfxDatePickerArrivalDateNew.getValue());
           d.setExpiryDate(jfxDatePickerExpiryDateNew.getValue());
           d.setQuantity(Integer.parseInt(txtQuantityNew.getText()));
           
           if(dDB.add(d)){
               Alert al = new Alert(Alert.AlertType.INFORMATION);
               al.setContentText("Drug have been added successfully.");
               al.showAndWait();
               txtDrugNameNew.setText("");
               txtCategoryNew.setText("");
               txtDrugDescriptionNew.setText("");
               jfxDatePickerArrivalDateNew.setValue(null);
               jfxDatePickerExpiryDateNew.setValue(null);
               txtQuantityNew.setText("");
           }else{
               Alert al = new Alert(Alert.AlertType.INFORMATION);
               al.setContentText("Drug did not added!!!");
               al.showAndWait();
           }
               
        }
        
        
    }

    @FXML
    void handleDrugButton(ActionEvent event) throws Exception{
        navigate(event, FXMLpage.DRUG.getPage());
    }

    @FXML
    void handleDrugIDCombo(ActionEvent event) {
        Drug drug = drugs.get(comboDrugID.getSelectionModel().getSelectedIndex());
        txtDrugNameUpdate.setText(drug.getDrugName());
        txtCategoryUpdate.setText(drug.getCategory());
        txtDrugDescriptionUpdate.setText(drug.getDrugDesc());
        jfxDatePickerArrivalDateUpdate.setValue(drug.getArrivalDate());
        jfxDatePickerExpiryDateUpdate.setValue(drug.getExpiryDate());
        txtQuantityUpdate.setText(drug.getQuantity() + "");
    }

    @FXML
    void handlePatientButton(ActionEvent event)  throws Exception{
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
    void handleUpdateButton(ActionEvent event) {
        DrugDB dDB = new DrugDB();
        Drug d = new Drug();
        if(isVU()){
           d.setDrugName(txtDrugNameUpdate.getText());
           d.setCategory(txtCategoryUpdate.getText());
           d.setDrugDesc(txtDrugDescriptionUpdate.getText());
           d.setArrivalDate(jfxDatePickerArrivalDateUpdate.getValue());
           d.setExpiryDate(jfxDatePickerExpiryDateUpdate.getValue());
           d.setQuantity(Integer.parseInt(txtQuantityUpdate.getText()));
           d.setIdDrug(comboDrugID.getSelectionModel().getSelectedItem());
           
           if(dDB.update(d)){
               Alert al = new Alert(Alert.AlertType.INFORMATION);
               al.setContentText("Drug have been updated successfully.");
               al.showAndWait();
               txtDrugNameUpdate.setText("");
               txtCategoryUpdate.setText("");
               txtDrugDescriptionUpdate.setText("");
               jfxDatePickerArrivalDateUpdate.setValue(null);
               jfxDatePickerExpiryDateUpdate.setValue(null);
               txtQuantityUpdate.setText("");
           }else{
               Alert al = new Alert(Alert.AlertType.INFORMATION);
               al.setContentText("Drug did not updated!!!");
               al.showAndWait();
           }
        }
    }
    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DrugDB dDB = new DrugDB();
        drugs = dDB.gets();
        for(int i = 0; i < drugs.size(); i++){
            drugID.add(drugs.get(i).getIdDrug());
            comboDrugID.setItems(drugID); 
        }
        
        columnDrugName.setCellValueFactory(new PropertyValueFactory<>("drugName"));
        columnDrugId.setCellValueFactory(new PropertyValueFactory<>("idDrug"));
        columnCategoryName.setCellValueFactory(new PropertyValueFactory<>("category"));
        columnDrugDescription.setCellValueFactory(new PropertyValueFactory<>("drugDesc"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnArrivalDate.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        columnExpiryDate.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        
        tableViewAllDrug.setItems(drugs);
        Drug d = new Drug();
        FilteredList<Drug> filteredDrugs = new FilteredList<>(drugs, i-> true);
        txtSearch.setOnKeyReleased(e -> {
            filteredDrugs.setPredicate(new Predicate<Drug>(){
                @Override
                public boolean test(Drug t) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   if(columnCategoryName.getText() == null || columnCategoryName.getText().isEmpty()||
                      columnDrugName.getText() == null || columnDrugName.getText().isEmpty()){
                        return true;
                   }
                   return 
                       t.getCategory().contains(txtSearch.getText()) ||
                       t.getDrugName().contains(txtSearch.getText());
                }
                
        });
            
                    
        });
        
        tableViewAllDrug.setItems(filteredDrugs);
    }    
    
}
