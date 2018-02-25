/**
 * Þorri Harðarson
 * thh170@hi.is
 * Mylla
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
 * @author Þorri Harðarson, thh170@hi.is
 */
public class MyllaAdalController implements Initializable {
    
    @FXML
    private Label skilabod;         // Skilaboð
    @FXML
    private MyllaPane myllaBord;    // Mylluborðið 
    @FXML
    private Canvas mittCanvas;      // Teiknisvæði 
    //@FXML
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
    @FXML
    public AnchorPane anchor;
    
    /**
     * Þetta fall upphafsstillir allann leikinn,
     * teiknar mylluborðið, keyrir upp dialoginn
     * og stillir nöfn leikmannana.
     * @param url
     * @param rb 
     */
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
    /**
     * Þetta fall stillir Label með nöfn leikmanna, og leyfir nýjan leik.
     * @param event 
     */
    @FXML
    private void nofnHandler(ActionEvent event) {
        dialogController.hvadHeitaLeikmenn();
        jLeikmadur1.setText(dialogController.Nofn()[0]);
        jLeikmadur2.setText(dialogController.Nofn()[1]);
        anchor.setDisable(false);
        myllaBord.NyrLeikur();    
    }
    /**
     * Þetta fall segir að leikmaður 1 var að gera leik.
     * @param event 
     */
    @FXML
    private void leikmadur1Handler(ActionEvent event) {
        myllaBord.leikmadurGerir(1);
        skilabod.setText("");
        myllaBord.mittBord.setNuverandiLeikmadur(1);
    }
    /**
     * Þetta fall segir að leikmaður 3 var að gera leik.
     * @param event 
     */
    @FXML
    private void leikmadur2Handler(ActionEvent event) {
        myllaBord.leikmadurGerir(2);
        skilabod.setText("");
        myllaBord.mittBord.setNuverandiLeikmadur(2);
    }
    /**
     * Þetta fall segir okkur að það vinna leikinn og setur label með 
     * vinningshafa, og lokar á að fleiri spili.
     * @param leikmadur 
     */
    public void Sigur(int leikmadur){
        jSigur.setText(dialogController.Nofn()[leikmadur-1] + " hefur unnið leikinn!");
        anchor.setDisable(true);
    }  
    /**
     * Þetta fall lokar forritinu.
     * @param event 
     */
    @FXML
    private void HaettaController(ActionEvent event) {
        System.out.println("Sjáumst Seinna!");
        System.exit(0);
    }
}
