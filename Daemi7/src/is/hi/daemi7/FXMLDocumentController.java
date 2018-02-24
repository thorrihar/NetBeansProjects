/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.daemi7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Þorri
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private StarfsmadurDialogController sDialogController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nyrStarfsmadur(ActionEvent event) {
    Starfsmadur s = sDialogController.skraStarfsmann();    
    }
    
}
