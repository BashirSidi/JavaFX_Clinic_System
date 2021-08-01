/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.database;

import com.jsiit.business.Prescription;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JSIIT
 */
public class PrescriptionDB implements DAO<Prescription> {
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public Prescription get(int t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Prescription p = new Prescription();
       try{
           String sql = "SELECT * FROM prescription WHERE Consultation_idConsultation = ?";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setInt(1, t);
           rs = ps.executeQuery();
           while(rs.next()){
             p.setIdConsultation(rs.getInt(1));
             p.setIdStudent(rs.getString(2));
             p.setIdStaff(rs.getInt(3));
             p.setIdDrug(rs.getInt(4));
           }
           return p;
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
       return null;
    }

    @Override
    public List<Prescription> gets() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       List<Prescription> prescriptions = new ArrayList<>();
       try{
           String sql = "SELECT * FROM prescription";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               int idConsultation = rs.getInt(1);
               String idStudent = rs.getString(2);
               int idStaff = rs.getInt(3);
               int idDrug = rs.getInt(4);
               
               Prescription p = new Prescription(idConsultation, idStudent, idStaff, idDrug);
               prescriptions.add(p);
           }
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
       return prescriptions;
    }

    @Override
    public boolean add(Prescription p) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           String sql = "INSERT INTO prescription VALUES(?,?,?,?)";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setInt(1, p.getIdConsultation());
           ps.setString(2, p.getIdStudent());
           ps.setInt(3, p.getIdStaff());
           ps.setInt(4, p.getIdDrug());
           
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
    public boolean update(Prescription p) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           String sql = "UPDATE prescription SET"
                      + "Consultation_Student_idStudent = ?, "
                      + "Consultation_Staff_idStaff = ?, "
                      + "Drug_idDrug = ? "
                      + "WHERE Consultation_idConsultation = ? ";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setString(1, p.getIdStudent());
           ps.setInt(2, p.getIdStaff());
           ps.setInt(3, p.getIdDrug());
           ps.setInt(4, p.getIdConsultation());
           
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
