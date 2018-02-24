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

/**
 * Controller fyrir valmynd. Skilur að búa til nýjan leik 
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class ValmyndController implements Initializable {

    private AdalController adalController;
    
    public void initAdal (AdalController adal) {
        adalController = adal;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Atburðarhandler fyrir að hefja nýjan leik. Núllstillir stigin í stigatöflu
     * @param event ónotað
     */
    @FXML
    private void nyrLeikurHandler(ActionEvent event) {
        System.out.println ("nýr leikur valinn");
        adalController.nullstillaStigin();
    }
    
}
