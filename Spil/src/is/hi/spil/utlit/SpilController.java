/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.spil.utlit;


import is.hi.spil.vinnsla.Teningar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import is.hi.spil.vinnsla.YatzeeImp;

/**
 * FXML Controller class
 *
 * @author Þorri
 */
public class SpilController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;
    private YatzeeImp leikur;
    final Teningar teningar = new Teningar(5);
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    leikur = new YatzeeImp("nafn");   
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void umForritidHandler(ActionEvent event) {
    Alert umForritid = new Alert(AlertType.INFORMATION);
    umForritid.setTitle("Um forritið");
    umForritid.setHeaderText("Útgáfa");
    umForritid.setContentText("Útgáfa v0.1");
    umForritid.showAndWait();

    }

    @FXML
    private void nyrLeikurHandler(ActionEvent event) {
        leikur = new YatzeeImp("nafn");
        System.out.println("Nýr leikur er hafinn");
    }

    
}
