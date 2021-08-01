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
public class Consultation {
    private IntegerProperty idConsultation = new SimpleIntegerProperty();
    private StringProperty studentId = new SimpleStringProperty();
    private IntegerProperty staffId = new SimpleIntegerProperty();
    private StringProperty diagnosis = new SimpleStringProperty();
    private StringProperty prescription = new SimpleStringProperty();
    private LocalDate date;
    
    public Consultation(){
        
    }
    
    public Consultation(int idConsultation, String studentId, int staffId, String diagnosis, String prescription, LocalDate date){
        this.idConsultation.set(idConsultation);
        this.studentId.set(studentId);
        this.staffId.set(staffId);
        this.diagnosis.set(diagnosis);
        this.prescription.set(prescription);
        this.date = date;
    }
    
    public int getIdConsultation(){
        return this.idConsultation.get();
    }
    
    public void setIdConsultatioin(int idConsultatioin){
        this.idConsultation.set(idConsultatioin);
    }
    
    public IntegerProperty idConsultation(){
        return this.idConsultation;
    }
    
    public String getStudentId(){
        return this.studentId.get();
    }
    
    public void setStudentId(String studentId){
        this.studentId.set(studentId);
    }
    
    public StringProperty studentIdProperty(){
        return this.studentId;
    }
    
    public int getStaffId(){
        return this.staffId.get();
    }
    
    public void setStaffId(int staffId){
        this.staffId.set(staffId);
    }
    
    public IntegerProperty staffIdProperty(){
        return this.staffId;
    }
    
    public String getDiagnosis(){
       return  this.diagnosis.get();
    }
    
    public void setDiagnosis(String diagosis){
        this.diagnosis.set(diagosis);
    }
    
    public StringProperty diagnosisProperty(){
        return this.diagnosis;
    }
    
    public String getPrescription(){
        return this.prescription.get();
    }
    
    public void setPrescription(String prescription){
        this.prescription.set(prescription);
    }
    
    public StringProperty prescriptionProperty(){
        return this.prescription;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public void setDate(LocalDate date){
        this.date = date;
    }

    @Override
    public String toString() {
        return "Consultation{" + "idConsultation=" + idConsultation + ", studentId=" + studentId + ", staffId=" + staffId + ", diagnosis=" + diagnosis + ", prescriptioin=" + prescription + ", date=" + date + '}';
    }
}
