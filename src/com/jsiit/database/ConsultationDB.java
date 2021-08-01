/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.database;

import com.jsiit.business.Consultation;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author JSIIT
 */
public class ConsultationDB implements DAO<Consultation> {
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public Consultation get(int idConsultation) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Consultation c = new Consultation();
       try{
           String sql = "SELECT * FROM consultation WHERE idConsultation = ?";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setInt(1, idConsultation);
           rs = ps.executeQuery();
           while(rs.next()){
               c.setIdConsultatioin(rs.getInt(1));
               c.setStudentId(rs.getString(2));
               c.setStaffId(rs.getInt(3));
               c.setDiagnosis(rs.getString(4));
               c.setPrescription(rs.getString(5));
               c.setDate(rs.getDate(6).toLocalDate());
           }
           return c;
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
       return null;
    }

    @Override
    public ObservableList<Consultation> gets() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ObservableList<Consultation> consultations = FXCollections.observableArrayList();
       try{
           String sql = "SELECT * FROM consultation";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               int idConsultation = rs.getInt(1);
               String idStudent = rs.getString(2);
               int idStaff = rs.getInt(3);
               String diagnosis = rs.getString(4);
               String prescription = rs.getString(5);
               LocalDate date = rs.getDate(6).toLocalDate();
               
               Consultation c = new Consultation(idConsultation, idStudent, idStaff, diagnosis, prescription, date);
               consultations.add(c);
           }
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
       return consultations;
    }

    @Override
    public boolean add(Consultation c) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           String sql = "INSERT INTO consultation VALUES(?,?,?,?,?,?)";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           
           ps.setInt(1, c.getIdConsultation());
           ps.setString(2, c.getStudentId());
           ps.setInt(3, c.getStaffId());
           ps.setString(4, c.getDiagnosis());
           ps.setString(5, c.getPrescription());
           ps.setDate(6, Date.valueOf(c.getDate()));
           
           int i = ps.executeUpdate();
           if(i > 0){
             return true;  
           }
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
           return false;
       }
       return false;
    }

    @Override
    public boolean update(Consultation c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            String sql = "UPDATE consultation SET"
                       + "Student_idStudent = ?, "
                       + "Staff_idStaff = ?, "
                       + "diagnosis = ?, "
                       + "prescription = ?, "
                       + "date = ? "
                       + "WHERE idConsultation = ? ";
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            
            ps.setString(1, c.getStudentId());
            ps.setInt(2, c.getStaffId());
            ps.setString(3, c.getDiagnosis());
            ps.setString(4, c.getPrescription());
            ps.setDate(5, Date.valueOf(c.getDate()));
            ps.setInt(6, c.getIdConsultation());
            
            int i = ps.executeUpdate();
            if(i > 0){
                return true;
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return false;
    }
    
}
