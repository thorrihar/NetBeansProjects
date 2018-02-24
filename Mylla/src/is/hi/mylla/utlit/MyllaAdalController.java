/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.mylla.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

/**
 * Controller fyrir mylluna. Er núna mjög einfaldur 
 * 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class MyllaAdalController implements Initializable {
    
    @FXML
    private Label skilabod;         // Skilaboð
    @FXML
    private MyllaPane myllaBord;    // Mylluborðið 
  
    @FXML
    private Canvas mittCanvas;      // Teiknisvæði 
    
    @FXML
    private DialogPaneController dialogController;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myllaBord.setAdal(this);
        myllaBord.teiknaGrunnbord(mittCanvas.getGraphicsContext2D());
        myllaBord.leikmadurGerir(1);
        myllaBord.leikmadurGerir(2);
        myllaBord.Reitir(100, 100, 100, 100);
    }    

    

   /**
     * Birtir villuskilaboð í strengnum s
     *
     * @param s villuskilaboð
     */
    public void birtaVilluskilaboð(String s) {
          skilabod.setText(s);
    }
 
    @FXML
    private void nofnHandler(ActionEvent event) {
        dialogController.hvadHeitaLeikmenn();
    }
}
