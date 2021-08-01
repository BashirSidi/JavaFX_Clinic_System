/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.database;

import com.jsiit.business.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JSIIT
 */
public class UserDB implements DAO<User>{
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public User get(int t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       User user = new User();
       try{
           String sql = "SELECT * FROM user WHERE id = ?";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setInt(1, t);
           rs = ps.executeQuery();
           while(rs.next()){
               user.setId(rs.getInt(1));
               user.setFirstName(rs.getString(2));
               user.setLastName(rs.getString(3));
               user.setUserName(rs.getString(4));
               user.setPassword(rs.getString(5));
           }
           return user;
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
       return null;
    }

    @Override
    public List<User> gets() {
        // new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            List<User> users = new ArrayList<>();
        try{
            String sql = "SELECT * FROM user";
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String userName = rs.getString(4);
                String password = rs.getString(5);
                
                User user = new User(id, firstName, lastName, userName, password);
                users.add(user);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return users;
    }

    @Override
    public boolean add(User u) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            String add = "INSERT INTO user VALUES(?,?,?,?,?)";
            ps = ConnectionDB.getConnection().prepareStatement(add);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getFirstName());
            ps.setString(3, u.getLastName());
            ps.setString(4, u.getUserName());
            ps.setString(5, u.getPassword());
            
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
    public boolean update(User u) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           String sql = "UPDATE user SET"
                      + "firstName = ?,"
                      + "lastName = ?,"
                      + "userName = ?"
                      + "password = ?"
                      + "WHERE id = ?";
           ps = ConnectionDB.getConnection().prepareStatement(sql);
           ps.setString(1, u.getFirstName());
           ps.setString(2, u.getLastName());
           ps.setString(3, u.getUserName());
           ps.setString(4, u.getPassword());
           ps.setInt(5, u.getId());
           
           int i = ps.executeUpdate();
           if(i > 0){
               return true;
           }
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
       return false;
    }
    public boolean login(String userName, String password){
        try{
            String sql = "SELECT * FROM user WHERE userName = ? AND password = ?";
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        return false;
    }
}
