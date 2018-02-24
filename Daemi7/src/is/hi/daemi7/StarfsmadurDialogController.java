/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.daemi7;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Þorri
 */
public class StarfsmadurDialogController implements Initializable {

    @FXML
    private TextField jNafn;
    @FXML
    private TextField jHeimilisfang;
    @FXML
    private Pane dialog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Starfsmadur skraStarfsmann() {
        // Innihald dialogs búið til 
        DialogPane p = new DialogPane();
        dialog.setVisible(true);
        
        // Innihald sett sem Pane sem fengið er úr Scene builder 
        p.setContent(dialog);
        
        // Umgjörðin búin til 
        Dialog d = new Dialog();
        
        // og innihaldið sett í umgjörðina 
        d.setDialogPane(p);
        // Haus, titill og mynd ef vill 
        d.setHeaderText("Litli ÓLI?");
        
        // Hnapparnir Í lagi og hætta við búnir til og bætt við 
        ButtonType iLagi = new ButtonType("Í lagi", 
                ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(iLagi);
        
        // Regla búin til um hvenær Í lagi hnappurinn á að vera óvirkur/virkur
        final Node stadfestingHnappur = p.lookupButton(iLagi);
        stadfestingHnappur.disableProperty()
                .bind(jNafn.textProperty().isEmpty()
                        .or(jHeimilisfang.textProperty().isEmpty()));

        
        ButtonType haettaVid = new ButtonType("Hætta við", 
                ButtonBar.ButtonData.CANCEL_CLOSE);
        d.getDialogPane().getButtonTypes().add(haettaVid);


        // Dialog birtur og svarið fengið 
        Optional<ButtonType> utkoma = d.showAndWait();
        if (utkoma.isPresent() && (utkoma.get()
                .getButtonData() == ButtonBar.ButtonData.OK_DONE)) {
            System.out.println("Leikmaður 1 heitir ");
        } else {
            System.out.println("Leikmenn nafnlausir");
        }
       return new Starfsmadur(jNafn.getText(),jHeimilisfang.getText());
    }
}
