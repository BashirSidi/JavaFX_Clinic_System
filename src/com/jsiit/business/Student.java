/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.business;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author JSIIT
 */
public class Student extends Person{
    private StringProperty idStudent = new SimpleStringProperty();
    private StringProperty otherName = new SimpleStringProperty();
    private StringProperty programType = new SimpleStringProperty();

    public Student() {
    }
    
    public Student(String idStudent, String otherName, String programType){
        this.idStudent.set(idStudent);
        this.otherName.set(otherName);
        this.programType.set(programType);
    }

    public Student(String fName, String lName, String gender, String phoneNumber, String idStudent, String otherName, String programType) {
        super(fName, lName, gender, phoneNumber);
        this.idStudent.set(idStudent);
        this.otherName.set(otherName);
        this.programType.set(programType);
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
    
    public String getOtherName(){
        return this.otherName.get();
    }
    
    public void setOtherName(String otherName){
        this.otherName.set(otherName);
    }
    
    public StringProperty otherNameProperty(){
        return this.otherName;
    }
    
    public String getProgramType(){
        return this.programType.get();
    }
    
    public void setProgramType(String programType){
        this.programType.set(programType);
    }
    
    public StringProperty programTypeProperty(){
        return this.programType;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", otherName=" + otherName + ", programType=" + programType + '}' + super.toString();
    }
}
