/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.hallo;

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
    private TextField jNafn;
    @FXML
    private Button button;
    @FXML
    private Label jHalloNafn;
    @FXML
    private Button jLitur;
    int count = 0;
    boolean graenn = true;
    @FXML
    private void hreinsaHandler(ActionEvent event) {
        count++;
        System.out.println(count);
        jHalloNafn.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        jHalloNafn.setText("Halló " + jNafn.getText());
    }

    @FXML
    private void SkiptaUmLitHandler(ActionEvent event) {
        String nyrLitur;
        
        if (graenn) {
            graenn = false;
            nyrLitur = "#ff0000";
        } else {
            graenn = true;
            nyrLitur = "008000";
        }
        jLitur.setStyle("-fx-backround-color: " + nyrLitur);
        }
    }

    


