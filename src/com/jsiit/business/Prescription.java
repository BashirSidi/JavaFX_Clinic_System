/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.business;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author JSIIT
 */
public class Prescription {
    private IntegerProperty idConsultation = new SimpleIntegerProperty();
    private StringProperty idStudent = new SimpleStringProperty();
    private IntegerProperty idStaff = new SimpleIntegerProperty();
    private IntegerProperty idDrug = new SimpleIntegerProperty();
    
    public Prescription(){
        
    }
    
    public Prescription(int idConsultation, String idStudent, int idStaff, int idDrug){
        this.idConsultation.set(idConsultation);
        this.idStudent.set(idStudent);
        this.idStaff.set(idDrug);
        this.idDrug.set(idDrug);
    }
    
    public int getIdConsultation(){
        return this.idConsultation.get();
    }
    
    public void setIdConsultation(int idConsultation){
        this.idConsultation.set(idConsultation);
    }
    
    public IntegerProperty idConsultationProperty(){
        return this.idConsultation;
    }
    
    public String getIdStudent(){
        return this.idStudent.get();
    }
    
    public void setIdStudent(String idStudent){
        this.idStudent.set(idStudent);
    }
    
    public StringProperty idStudentProperty(){
        return this.idStudent;
    }
    
    public int getIdStaff(){
        return this.idStaff.get();
    }
    
    public void setIdStaff(int idStaff){
        this.idStaff.set(idStaff);
    }
    
    public IntegerProperty idStaffProperty(){
        return this.idStaff;
    }
    
    public int getIdDrug(){
        return this.idDrug.get();
    }
    
    public void setIdDrug(int idDrug){
        this.idDrug.set(idDrug);
    }
    
    public IntegerProperty idDrugProperty(){
        return this.idDrug;
    }

    @Override
    public String toString() {
        return "Prescription{" + "idConsultation=" + idConsultation + ", idStudent=" + idStudent + ", idStaff=" + idStaff + ", idDrug=" + idDrug + '}';
    }
}
