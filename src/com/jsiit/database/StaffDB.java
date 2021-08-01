/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.database;

import com.jsiit.business.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author JSIIT
 */
public class StaffDB implements DAO<Staff>{
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public Staff get(int t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.//
       Staff s = new Staff();
       try{
           String sql = "SELECT * staff WHERE idStaff = ?";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setInt(1, t);
           rs = ps.executeQuery();
           while(rs.next()){
               s.setIdStaff(rs.getInt(1));
               s.setFName(rs.getString(2));
               s.setLName(rs.getString(3));
               s.setGender(rs.getString(4));
               s.setPhoneNumber(rs.getString(5));
               s.setRole(rs.getString(6));
           }
           return s;
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
       return null;
    }

    @Override
    public ObservableList<Staff> gets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ObservableList<Staff> staffs = FXCollections.observableArrayList();
        try{
            String sql = "SELECT * FROM staff";
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int idStaff = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String gender = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String role = rs.getString(6);
                
                Staff staff = new Staff(fName, lName, gender, phoneNumber, idStaff, role);
                staffs.add(staff);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return staffs;
    }

    @Override
    public boolean add(Staff s) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           String sql = "INSERT INTO staff VALUES(?,?,?,?,?,?)";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setInt(1, s.getIdStaff());
           ps.setString(2, s.getFName());
           ps.setString(3, s.getLName());
           ps.setString(4, s.getGender());
           ps.setString(5, s.getPhoneNumber());
           ps.setString(6, s.getRole());
           
           int i = ps.executeUpdate();
           if(i > 0){
               return true;
           }
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
       return false;
    }

    @Override
    public boolean update(Staff s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           String sql = "UPDATE staff SET "
                      + "firstName = ?, "
                      + "lastName = ?, "
                      + "gender = ?, "
                      + "phoneNumber = ?, "
                      + "role = ? "
                      + "WHERE idStaff = ?";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setString(1, s.getFName());
           ps.setString(2, s.getLName());
           ps.setString(3, s.getGender());
           ps.setString(4, s.getPhoneNumber());
           ps.setString(5, s.getRole());
           ps.setInt(6, s.getIdStaff());
           
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
