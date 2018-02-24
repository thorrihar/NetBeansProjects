/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.nested.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

/**
 * Megin controller klasi fyrir dæmi um Hreiðraða controllers
 * Dæmi Vika 5
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class AdalController implements Initializable {

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
    
    // Gæta þess að setja inn @FXML alltaf inn þegar búið er að gera 
    // Make Controller 
    @FXML
    private ValmyndController valmyndController; 

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ollStig = new Label []{asar, tvistar};
        allirHnappar = new ToggleButton [] {asarHnappur, tvistarHnappur};
        
        daemiUmStig();
        valmyndController.initAdal(this);
    }    

   
    /***
     * Frumstillum töfluna með dummy gögnum 
     */
    private void daemiUmStig() {
        // Setjum einhver gildi í töfluna
        int r=2;
        int summaStiga=0;
        for (Label l: ollStig) {
            l.setText(String.valueOf(r));
            summaStiga = summaStiga+r;
            r = r*r;
        }
        samtals.setText(String.valueOf(summaStiga));
    }    

    /***
     * Stigin í notendaviðmótinu eru núllstillt og líka samtals 
     */
    public void nullstillaStigin () {
        for (Label l: ollStig) {
            l.setText("0");
        }
        samtals.setText("0");
    }
}
