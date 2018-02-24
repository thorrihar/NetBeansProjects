/**
 * Þorri Harðarson
 * thh170@hi.is
 * Yahtzee
 */
package is.hi.yahtzee.utlit;

import is.hi.yahtzee.vinnsla.YahtzeeImp;
import is.hi.yahtzee.vinnsla.Teningar;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;


/**
 * Yahtzee forritið er leikur til að spila spilið
 * Yahtzee.
 *
 * @author Þorri, Háskóli Íslands.
 */
public class YahtzeeController implements Initializable {
    
    public YahtzeeImp leikur;
    @FXML
    private Button jButton0;
    @FXML
    private Button jButton1;
    @FXML
    private Button jButton2;
    @FXML
    private Button jButton3;
    @FXML
    private Button jButton4;
    @FXML
    private Button jButton5;
    @FXML
    private Button jButton6;
    @FXML
    private Button jButtonKasta;
    @FXML
    private Label j1;
    @FXML
    private Label j2;
    @FXML
    private Label j3;
    @FXML
    private Label j4;
    @FXML
    private Label j5;
    @FXML
    private Label j6;
    @FXML
    private Label j0;
    @FXML
    private Label jSamtals;
    @FXML
    Label jNafnLeikmanns;
    @FXML
    public Label jFjoldiEftir;
    @FXML
    private TeningarController teningarController;
    @FXML
    private MenuBarController menuBarController;
    
    public int stigKomin = 0;
    private Button[] takki;
    private Label[] slabel;
    public int fjoldiEftir = 2;
    @FXML
    private Label label;
    /**
     * Initialize handlerinn býr til Teningahluta og YatzeeImp hluta. 
     * Hann fær nafn leikmannsins og kastar teningunum og breytir fjölda
     * kasta sem er eftir.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teningarController.init(this);
        menuBarController.init(this);
        
        leikur = new YahtzeeImp("Leikmaður");
        teningarController.teningarGrid();
        
        
        takki = new Button[] {jButton0, jButton1, jButton2, jButton3, jButton4, jButton5, jButton6};
        slabel = new Label[] {j0, j1, j2, j3, j4, j5, j6};
        
        teningarController.kasta();
        teningarController.myndirnar();
        
        jNafnLeikmanns.setText("Nafn:\n" + saekjaNafnLeikmanns());
        jFjoldiEftir.setText("2");
        jSamtals.setText("0");
        
        jButtonKasta.disableProperty().bind(jFjoldiEftir.textProperty().isEqualTo("0"));
    }
    /**
     * Þessi handler sér um að reikna stigin út frá því hvaða 
     * tölu er ýtt á. Handlerinn sér einnig um að upphafstilla
     * þegar ný umferð hefst ásamt því að taka burt geymda takka.
     * @param event 
     */
    @FXML
    private void jTegundButton(ActionEvent event) {
        int tegund = finnaTolu((Button)event.getSource());
        int temp;
        takki[tegund].setDisable(true);
        if(tegund==0){
            temp = leikur.reiknaSensinn(teningarController.teningurinn);
        }
        else{
            temp = leikur.reiknaEinfalda(tegund, teningarController.teningurinn);
        }
        leikur.reiknaSumma();
        
        jFjoldiEftir.setText("2");
        fjoldiEftir = 2;
        teningarController.teningurinn.ekkiGeymdir();
        teningarController.kasta();
        
        teningarController.myndirnar();
        teningarController.Opacity();
        
        slabel[tegund].setText(Integer.toString(temp));
        jSamtals.setText(Integer.toString(leikur.getSumma()));
        stigKomin++;
        if(stigKomin == 7)
        jFjoldiEftir.setText("0");
    }
    /**
     * Þessi handler biður leikmann um að skrifa niður nafnið sitt.
     * @return 
     */
    String saekjaNafnLeikmanns() {
    TextInputDialog nafnDialog = new TextInputDialog("Nafn");
    nafnDialog.setTitle("Nafn leikmanns");
    nafnDialog.setHeaderText("Skrifaðu inn nafnið þitt");
    nafnDialog.setContentText("Leikmaður: ");
    Optional<String> nafn = nafnDialog.showAndWait();
    return nafn.get();   
    }
    /**
     * Þessi handler keyrir kasta fallið og breytir
     * fjölda kasta sem eru eftir og myndirnar af teningunum.
     * @param event 
     */
    @FXML
    private void jButtonKastaHandler(ActionEvent event) {    
        teningarController.kasta();
        fjoldiEftir--;
        teningarController.myndirnar();   
    }
    /**
     *Þessi handler núllstillir stigin.
     */
    public void nullstilla() {
    for(int i = 0; i <slabel.length; i++) {
    slabel[i].setText("");
    jSamtals.setText("");
    }   
    for(int j = 0; j <takki.length; j++) {
    takki[j].setDisable(false);
        }
    }
    /** 
     * Þessi handler fær inn takka og finnur númerið á takkanum í fylki.
     * @param b
     * @return 
     */
     private int finnaTolu (Button b){
        for (int i=0; i< takki.length;i++) {
            if (takki[i] == b) {
                return i;
            }
        }
        return -1;
    }

    
}
