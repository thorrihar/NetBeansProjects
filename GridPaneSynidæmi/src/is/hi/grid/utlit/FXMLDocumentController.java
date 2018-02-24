/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.grid.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * Controller sem sýnir fylki af hnöppum í GridPane
 * @author Ebba Þóra Hvannberg
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    
    private Button [] REITIR;   // fylki af hnöppum 
    
    /**
     * Frumstillir fylki af hnöppum 
     * @param url ónotað
     * @param rb  ónotað 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         REITIR = new Button[]{ button1,button2,
        button3,button4};
    }    

    /**
     * Atburðahandler sem bregst við hnappi og birtir töluna í hnappnum.
     * @param event 
     */
    @FXML
    private void reitirOnAction(ActionEvent event) {
        // Finnum hvaða hnapp var ýtt á
        Button nyrReitur = (Button)event.getSource();

        // Birtum töluna á hnappnum 
        birtaTextaHnappsins (nyrReitur.getText());
    }
    
    /**
     * Birtir texta hnapps 
     * @param name 
     */
    private void birtaTextaHnappsins(String texti) {
        System.out.println (" texti hnappsins er "+texti);
    }
    
    /**
     * Finnur hnapp í fylki og skilar index hans í fylkinu  
     * @param b hnappurinn sem leitað er að 
     * @return index hnapps ef hann finnst en annars -1
     */
    private int hvadaHnappur (Button b) {
        
        for (int i=0; i< REITIR.length;i++) {
            if (REITIR[i] == b) {
                return i;
            }
        }
        return -1;
    }
     
    
}
