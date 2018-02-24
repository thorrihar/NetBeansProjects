/**
 * Þorri Harðarson
 * thh170@hi.is
 * Reiknivél
 */
package is.hi.reiknivel.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import is.hi.reiknivel.vinnsla.Reiknivel;
/**
 * ReiknivelController er klasi sem færir takkaskipanir 
 * reiknivélarinnar yfir í reikninga og birtir inntökin
 * og útkomana á skjá reiknivélarinnar.
 */
public class ReiknivelController implements Initializable {
    
    @FXML
    private Button button1; //Tala 1 á reiknivél
    @FXML
    private Button button2; //Tala 2 á reiknivél
    @FXML
    private Button button3; //Tala 3 á reiknivél
    @FXML
    private Button button4; //Tala 4 á reiknivél
    @FXML
    private Button button5; //Tala 5 á reiknivél
    @FXML
    private Button button6; //Tala 6 á reiknivél
    @FXML
    private Button button7; //Tala 7 á reiknivél
    @FXML
    private Button button8; //Tala 8 á reiknivél
    @FXML
    private Button button9; //Tala 9 á reiknivél
    @FXML
    private Button button0; //Tala 0 á reiknivél
    @FXML
    private Label Utkoma; //Úttaksgluggi á reiknivél
    
    private Button[] Buttons; //Fylki sem inniheldur alla takka 
    private boolean virki; //Sannleiksgildi um hvort það sé búið að ýta á virkja
    private boolean samasem; //Sannleiksgildi um hvort sé búið að ýta á '='
    
    Reiknivel reiknivel = new Reiknivel(); //Reiknivélin sem við erum að vinna með
    /**
     * initialize skilgreinir innihald 
     * Button fylkisins. 
     */   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Buttons = new Button[] {button0, button1, button2, button3, 
        button4, button5, button6, button7, button8, button9};
    }    
    /**
    * innTakTalaActionPerformed og ritar töluna sem var
    * valin á úttakssvæðið.
    * Einnig þá núllstillist úttakssvæðið ef það er '='.
    */
    @FXML
    private void inntakTalaActionPerformed(ActionEvent event) {
        if (samasem == true){
            Utkoma.setText(" ");
            reiknivel.nullStilla();
            samasem = false;
        }
        int tempT = finnaTolu((Button)event.getSource());
        String tempU = Utkoma.getText();
        reiknivel.setTala(tempT);
        Utkoma.setText(tempU + "" + tempT);
        virki = false;
    }
    /**
    * finnaTolu finnur út hvaða tala 
    * var slegin inn á reiknivélina.
    */
    private int finnaTolu(Button b){
        for (int i=0; i< Buttons.length;i++) {
            if (Buttons[i] == b) {
                return i;
            }
        }
        return -1;
    }
    /**
     * plusHandler prentar út '+' og setur á 
     * virkjann plús. 
     */
    @FXML
    private void plusHandler(ActionEvent event) {
    if (virki == false) {
        reiknivel.setVirki('+');
        String tempU = Utkoma.getText();
        Utkoma.setText(tempU + " + ");
        virki = true;
        }            
    }
     /**
     * minusHandler prentar út '-' og setur á 
     * virkjann mínus. 
     */
    @FXML
    private void minusHandler(ActionEvent event) {
        if (virki == false) {
            reiknivel.setVirki('-');
            String tempU = Utkoma.getText();
            Utkoma.setText(tempU + " - ");
            virki = true;
        }   
    }
    /**
    * margfoldunHandler prentar út '*' og setur á 
    * virkjann sinnum. 
    */
    @FXML
    private void magfoldunHandler(ActionEvent event) {
        if (virki == false) {
            reiknivel.setVirki('*');
            String tempU = Utkoma.getText();
            Utkoma.setText(tempU + " * ");
            virki = true;
        } 
    }
     /**
     * hreinsaHandler hreinsar skjá reiknivélarinnar 
     * og núllstillir reiknivélina. 
     */
    @FXML
    private void hreinsaHandler(ActionEvent event) {
        Utkoma.setText(" ");
        reiknivel.nullStilla();
    }
    /**
     * jafntogHandler prentar út '=' og reiknar 
     * útkomu reikniaðgerðarinnar. 
     */
    @FXML
    private void jafntogHandler(ActionEvent event) {
        reiknivel.setVirki('=');
        String tempU = Utkoma.getText();
        Utkoma.setText(tempU + " = " + reiknivel.getUtkoma());
        samasem = true;
    }
    /**
     * deilingHandler prentar út '/' og setur á 
     * virkjann deiling. 
     */
    @FXML
    private void deilingHandler(ActionEvent event) {
        if (virki == false) {
            reiknivel.setVirki('/');
            String tempU = Utkoma.getText();
            Utkoma.setText(tempU + " / ");
            virki = true;
        } 
    }
}
