/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.nested.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

/**
 * Megin controller klasi fyrir dæmi um Hreiðraða controllers
 * Vika 5
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class AdalController implements Initializable {
    
    @FXML
    private ValmyndController valmyndController; 
    @FXML
    private ToggleButton asarHnappur;
    @FXML
    private ToggleButton tvistarHnappur;
    @FXML
    private Label tvistar;
    @FXML
    private Label asar;

    private Label [] ollStig; 
    private ToggleButton [] allirHnappar; 
    @FXML
    private Label samtals;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ollStig = new Label []{asar, tvistar};
        allirHnappar = new ToggleButton [] {asarHnappur, tvistarHnappur};
        valmyndController.initAdal(this); 
        daemiUmStig();
    }    
    
    public void nullstillaStigin(){
        for(int i=0; i<ollStig.length; i++){
            ollStig[i].setText("0");
        }
        samtals.setText("0");
        }
    
   
    /***
     * Frumstillum töfluna með dummy gögnum 
     */
    private void daemiUmStig() {
   
    }    

    
}
