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
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

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
    
    //@FXML
    //private DialogPaneController dialogController;
    @FXML
    private DialogPaneController dialogController;
    @FXML
    private ToggleGroup Leikmenn;
    @FXML
    public RadioButton jLeikmadur1;
    @FXML
    public RadioButton jLeikmadur2;
    @FXML
    public Label jSigur;
    @FXML
    private MenuItem jHaetta;
    //@FXML
    //public AnchorPane anchor;
    @FXML
    public AnchorPane anchor;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myllaBord.setAdal(this);
        myllaBord.teiknaGrunnbord(mittCanvas.getGraphicsContext2D());
        myllaBord.Reitir(100, 100, 100, 100);
        dialogController.hvadHeitaLeikmenn();
        jLeikmadur2.setText(dialogController.Nofn()[1]);
        jLeikmadur1.setText(dialogController.Nofn()[0]);
        skilabod.setText("");
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
        jLeikmadur1.setText(dialogController.Nofn()[0]);
        jLeikmadur2.setText(dialogController.Nofn()[1]);
        anchor.setDisable(false);
        myllaBord.NyrLeikur(); 
        
    }

    @FXML
    private void leikmadur1Handler(ActionEvent event) {
        myllaBord.leikmadurGerir(1);
        skilabod.setText("");
        myllaBord.mittBord.setNuverandiLeikmadur(1);
    }

    @FXML
    private void leikmadur2Handler(ActionEvent event) {
        myllaBord.leikmadurGerir(2);
        skilabod.setText("");
        myllaBord.mittBord.setNuverandiLeikmadur(2);
    }
    
    public void Sigur(int leikmadur){
        jSigur.setText(dialogController.Nofn()[leikmadur-1] + " hefur unnið leikinn!");
        anchor.setDisable(true);
    }  

    @FXML
    private void HaettaController(ActionEvent event) {
        System.out.println("Sjáumst Seinna!");
        System.exit(0);
    }
}
