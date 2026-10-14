/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.lab08;

//Github repo: https://github.com/BoomEAE/PaintApp.git

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
/**
 * FXML Controller class
 *
 * @author Eric Andre Evsei
 */
public class PainterController implements Initializable {
    
    //enum for the different pen sizes
    private enum PenSize {
    SMALL(2),
    MEDIUM(4),
    LARGE(6);
    
    private final int radius;
    
    PenSize(int radius){this.radius = radius;}
    
    public int getRadius(){return radius;}
    
    };
    
    @FXML
    private RadioButton blackRadioBtn;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private RadioButton redRadioBtn;
    @FXML
    private RadioButton greenRadioBtn;
    @FXML
    private RadioButton blueRadioBtn;
    @FXML
    private RadioButton smallRadioBtn;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    private RadioButton mediumRadioBtn;
    @FXML
    private RadioButton largeRadioBtn;
    @FXML
    private Button undoBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Pane drawingAreaPane;
    
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //user data control
        blackRadioBtn.setUserData(Color.BLACK);
        redRadioBtn.setUserData(Color.RED);
        greenRadioBtn.setUserData(Color.GREEN);
        blueRadioBtn.setUserData(Color.BLUE);
        smallRadioBtn.setUserData(PenSize.SMALL);
        mediumRadioBtn.setUserData(PenSize.MEDIUM);
        largeRadioBtn.setUserData(PenSize.LARGE);
    }    
    
    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
        //We get the radioButton that as been toggled and we take its data and set the brush color
        Toggle toggle = colorToggleGroup.getSelectedToggle();
        brushColor = (Color)toggle.getUserData();
    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
        //We get the radioButton that as been toggled and we set the chosen pen size
        Toggle toggle = sizeToggleGroup.getSelectedToggle();
        radius = (PenSize)toggle.getUserData();
    }

    @FXML
    private void undoButtonPressed(ActionEvent event) {
        //remove the latest circle
        drawingAreaPane.getChildren().remove(drawingAreaPane.getChildren().size()-1);
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        //Clear the drawing area
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        //When mouse is dragged, we add circles that can display a drawing
        Circle circle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(circle);
    }

}
