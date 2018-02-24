/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.summa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Þorri
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField jTalaInntak;
    @FXML
    private Button jSamasem;
    
    private double vinstri;
    private double haegri;
    private double samtals;
    @FXML
    private Label jRandomTala;
    @FXML
    private Label jUtkoma;
    @FXML
    private Label jPlus;
   
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     private double naestaRandomTala(){
         return (int)(Math.random()*9)+1;
     }

    @FXML
    private void jTalaInntakActionPerformed(ActionEvent event) {
        String s = jTalaInntak.getText();
        System.out.println("prent");
        vinstri = Double.valueOf(s);
        haegri = naestaRandomTala();
        String r = String.valueOf(haegri);
        jRandomTala.setText(r);      
    }
    private double reiknaSamtals(){
        return vinstri + haegri; 
    }

    @FXML
    private void jJafntOgActionPerformed(ActionEvent event) {
        samtals = reiknaSamtals();
        String h = String.valueOf(samtals);
        jUtkoma.setText(h);       

    }
}
    
    

