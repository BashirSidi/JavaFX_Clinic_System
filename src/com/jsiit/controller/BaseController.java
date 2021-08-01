package com.jsiit.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author JSIIT
 */
public class BaseController {

    Alert alert;

    public void navigate(Event event, URL fxmlPage) throws Exception {
        Parent node = FXMLLoader.load(fxmlPage);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        double width = ((Node) event.getSource()).getScene().getWindow().getWidth();
        double height = ((Node) event.getSource()).getScene().getWindow().getHeight();
        
        Scene scene = new Scene(node, width, height);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}
