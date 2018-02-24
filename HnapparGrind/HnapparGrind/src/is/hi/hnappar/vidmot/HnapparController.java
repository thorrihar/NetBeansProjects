/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.hnappar.vidmot;

import is.hi.reiknivel.vinnsla.Reiknivel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Ebba Þóra Hvannberg
 */
public class HnapparController implements Initializable {
    
    @FXML
    private TextField jReikniGluggi;
    
    private Reiknivel minreiknivel = new Reiknivel();
    @FXML
    private Button jB1;
    @FXML
    private Button jB2;
    @FXML
    private Button jB3;
    @FXML
    private Button jB4;
     
    private Button[] Buttons; 
    private String[] MYNDIR;
    private final Image [] ikonar = new Image[6];
    @FXML
    private TextField jTala;
    @FXML
    private Label jRassi;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Buttons = new Button[] {jB1, jB2, jB3, jB4};
         MYNDIR  = new String[] {"one", "two", "three", "four", "five", "six"};
         for (int i=0; i<6; i++){
         ikonar[i] = new
         Image(getClass().getResourceAsStream("myndir/"+MYNDIR[i]+".png"));
         }
    }    

    @FXML
    private void jTeningurTalaHandler(ActionEvent event) {
    int tala = Integer.parseInt(jTala.getText());
    if(tala>=1 && tala<=6){
        jRassi.setGraphic(new ImageView(ikonar[Integer.valueOf(jTala.getText())-1]));
        }
    }

    @FXML
    private void jTolurActionPerformed(ActionEvent event) {
    int tempT = finnaTolu((Button)event.getSource());
    baetaVid(String.valueOf(tempT));
    
    
    }
    private int finnaTolu (Button b){
    for (int i=0; i< Buttons.length;i++) {
        if (Buttons[i] == b) {
            return i+1;
        }
      }
    return 0;
    }
     private void baetaVid(String s) {
        String tempU = jReikniGluggi.getText();
        jReikniGluggi.setText(tempU + "" + s);
     } 
     
     
}
