/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.database;

import com.jsiit.business.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author JSIIT
 */
public class StudentDB {
    PreparedStatement ps;
    ResultSet rs;
    Student s = new Student();
  
    public Student get(String t) {
        try{
            String sql = "SELECT * FROM student WHERE idStudent = ?";
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            ps.setString(1, t);
            rs = ps.executeQuery();
            while(rs.next()){
                s.setIdStudent(rs.getString(1));
                s.setFName(rs.getString(2));
                s.setLName(rs.getString(3));
                s.setOtherName(rs.getString(4));
                s.setGender(rs.getString(5));
                s.setPhoneNumber(rs.getString(6));
                s.setProgramType(rs.getString(7));
            }
            return s;
        }catch(SQLException ex){
            System.err.println(ex.getMessage()); 
        }
        return null;
    }
    
    public ObservableList<Student> getNational(){
       ObservableList<Student> studentsND = FXCollections.observableArrayList();
        try{
            String sql = "SELECT * FROM student WHERE programType = 'National'";
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String studID = rs.getString(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String oName = rs.getString(4);
                String gender = rs.getString(5);
                String pNumber = rs.getString(6);
                String pType = rs.getString(7);
                
                Student student = new Student(fName, lName, gender, pNumber, studID, oName, pType);
                studentsND.add(student);
            }
        }catch(SQLException e){
            System.err.println("Error national " +e.getMessage());
        }
        return studentsND;
    }
    
    public ObservableList<Student> getInternational(){
        ObservableList<Student> studentsInternational =FXCollections.observableArrayList();
        try{
            String sql = "SELECT * FROM student WHERE programType = 'International'";
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String studID = rs.getString(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String oName = rs.getString(4);
                String gender = rs.getString(5);
                String pNumber = rs.getString(6);
                String pType = rs.getString(7);
                
                Student student = new Student(fName, lName, gender, pNumber, studID, oName, pType);
                studentsInternational.add(student);
            }
        }catch(SQLException e){
            System.err.println("error internationa      "+e.getMessage());
        }
        return studentsInternational;
    }

    public ObservableList<Student> gets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ObservableList<Student> students = FXCollections.observableArrayList();
        try{
            String sql = "SELECT * FROM student";
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String idStudent = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String otherName = rs.getString(4);
                String gender = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String progType = rs.getString(7);
                
                Student student = new Student(firstName, lastName, gender, phoneNumber, idStudent, otherName, progType);
                System.out.println("Im here");
            
                students.add(student);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return students;
    }

    public boolean add(Student s) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           String sql = "INSERT INTO student VALUES(?,?,?,?,?,?,?)";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setString(1, s.getIdStudent());
           ps.setString(2, s.getFName());
           ps.setString(3, s.getLName());
           ps.setString(4, s.getOtherName());
           ps.setString(5, s.getGender());
           ps.setString(6, s.getPhoneNumber());
           ps.setString(7, s.getProgramType());
           
           int i = ps.executeUpdate();
           if (i > 0){
               return true;
           }
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
           return false;
       }
       return false;
    }

    public boolean update(Student s) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      try{
          String sql = "UPDATE student SET "
                     + "firstName = ?, "
                     + "lastName = ?, "
                     + "otherName = ?, "
                     + "gender = ?, "
                     + "phoneNumber = ?, "
                     + "programType = ? "
                     + "WHERE idStudent = ?";
          ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setString(7, s.getIdStudent());
           ps.setString(1, s.getFName());
           ps.setString(2, s.getLName());
           ps.setString(3, s.getOtherName());
           ps.setString(4, s.getGender());
           ps.setString(5, s.getPhoneNumber());
           ps.setString(6, s.getProgramType());
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

