/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.database;

import com.jsiit.business.Drug;
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
public class DrugDB implements DAO<Drug> {
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public Drug get(int idDrug) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Drug d = new Drug();
       try{
           String sql = "SELECT * FROM drug WHERE idDrug = ?";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setInt(1, idDrug);
           rs = ps.executeQuery();
           while(rs.next()){
               d.setIdDrug(rs.getInt(1));
               d.setDrugName(rs.getString(2));
               d.setCategory(rs.getString(3));
               d.setDrugDesc(rs.getString(4));
               d.setArrivalDate(rs.getDate(5).toLocalDate());
               d.setExpiryDate(rs.getDate(6).toLocalDate());
               d.setQuantity(rs.getInt(7));
           }
           return d;
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return null;
    }

    @Override
    public ObservableList<Drug> gets() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ObservableList<Drug> drugs = FXCollections.observableArrayList();
       try{
           String sql = "SELECT * FROM drug";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               int idDrug = rs.getInt(1);
               String drugName = rs.getString(2);
               String category = rs.getString(3);
               String drugDesc = rs.getString(4);
               LocalDate arrivalDate = rs.getDate(5).toLocalDate();
               LocalDate expiryDate = rs.getDate(6).toLocalDate();
               int quantity = rs.getInt(7);
               
               Drug d = new Drug(idDrug, drugName, category, drugDesc, arrivalDate, expiryDate, quantity);
               
               drugs.add(d);
           }
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return drugs;
    }

    @Override
    public boolean add(Drug d) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           String sql = "INSERT INTO drug VALUES(?,?,?,?,?,?,?)";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           
           ps.setInt(1, d.getIdDrug());
           ps.setString(2, d.getDrugName());
           ps.setString(3, d.getCategory());
           ps.setString(4, d.getDrugDesc());
           ps.setDate(5, Date.valueOf(d.getArrivalDate()));
           ps.setDate(6, Date.valueOf(d.getExpiryDate()));
           ps.setInt(7, d.getQuantity());
           
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
    public boolean update(Drug d) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
       try{
           String sql = "UPDATE drug SET "
                      + "drugName = ?, "
                      + "category = ?, "
                      + "drugDesc = ?, "
                      + "arivalDate = ?, "
                      + "expiryDate = ?, "
                      + "quantity = ? "
                      + "WHERE idDrug = ?";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setString(1, d.getDrugName());
           ps.setString(2, d.getCategory());
           ps.setString(3, d.getDrugDesc());
           ps.setDate(4, Date.valueOf(d.getArrivalDate()));
           ps.setDate(5, Date.valueOf(d.getExpiryDate()));
           ps.setInt(6, d.getQuantity());
           ps.setInt(7, d.getIdDrug());
           
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
