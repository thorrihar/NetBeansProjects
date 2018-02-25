/**
 * Þorri Harðarson
 * thh170@hi.is
 * Mylla
 */
package is.hi.mylla.utlit;

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
 * Sérstakur controller fyrir dialog glugga
 *
 * @author Þorri Harðarson, thh170@hi.is
 */
public class DialogPaneController implements Initializable {

    @FXML
    private Pane dialog;
    @FXML
    private TextField leikmadur1Nafn;
    @FXML
    private TextField leikmadur2Nafn;
    
    private String[] nofn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nofn = new String[2];
        // TODO
    }    
    /**
     * Aðferð sem birtir dialog sem biður um nöfn tveggja leikmanna 
     * 
     */
    public void hvadHeitaLeikmenn() {
        // Innihald dialogs búið til 
        DialogPane p = new DialogPane();
        dialog.setVisible(true);
        
        // Innihald sett sem Pane sem fengið er úr Scene builder 
        p.setContent(dialog);
        
        // Umgjörðin búin til 
        Dialog d = new Dialog();
        
        // og innihaldið sett í umgjörðina 
        d.setDialogPane(p);
        // Haus, titill
        d.setHeaderText("Hvað heitið þið?");
        d.setTitle("Nöfn leikmanna");
        // Hnapparnir Í lagi og hætta við búnir til og bætt við 
        ButtonType iLagi = new ButtonType("Í lagi", 
                ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(iLagi);
        
        // Regla búin til um hvenær Í lagi hnappurinn á að vera óvirkur/virkur
        final Node stadfestingHnappur = p.lookupButton(iLagi);
        stadfestingHnappur.disableProperty()
                .bind(leikmadur1Nafn.textProperty().isEmpty()
                        .or(leikmadur2Nafn.textProperty().isEmpty()));

        
        ButtonType haettaVid = new ButtonType("Hætta við", 
                ButtonBar.ButtonData.CANCEL_CLOSE);
        d.getDialogPane().getButtonTypes().add(haettaVid);


        // Dialog birtur og svarið fengið 
        Optional<ButtonType> utkoma = d.showAndWait();
        if (utkoma.isPresent() && (utkoma.get()
                .getButtonData() == ButtonBar.ButtonData.OK_DONE)) {
            nofn[0] = leikmadur1Nafn.getText();
            nofn[1] = leikmadur2Nafn.getText();
        } else {
            System.out.println("Leikmenn nafnlausir");
        }
    }
    public String[] Nofn(){
        return nofn;
    }
}
