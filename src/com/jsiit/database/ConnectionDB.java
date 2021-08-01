/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JSIIT
 */
public class ConnectionDB {
    private static Connection conn;
    
    public static synchronized Connection getConnection(){
        if(conn != null){
            return conn;
    }else{
            try{
                String url = "jdbc:mysql://localhost:3306/clinic";
                String user = "root";
                String psw = "";
                conn = DriverManager.getConnection(url, user, psw);
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }return conn;
   }
    
    public static synchronized void closeConnectioin(){
        if(conn != null){
            conn = null;
        }else
            try{
                conn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage()); 
            }finally{
                conn = null;
            }
    }
}
