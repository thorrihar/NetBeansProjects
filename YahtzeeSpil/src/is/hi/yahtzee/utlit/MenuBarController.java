/**
 * Þorri Harðarson
 * thh170@hi.is
 * Yahtzee
 */
package is.hi.yahtzee.utlit;

import is.hi.yahtzee.vinnsla.YahtzeeImp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * MenuBarController er klasi sem heldur utan um MenuBar forritsins,
 * efst í viðmótinu.
 * @author Þorri Harðarson, Háskóli Íslands.
 */
public class MenuBarController implements Initializable {

    private YahtzeeController yahtzeeController;
    /**
     * Náum í YahtzeeController hlutinn
     * @param yahtzee 
     */
    public void init(YahtzeeController yahtzee){
        yahtzeeController = yahtzee;
    }
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    /**
     * Þessi Handler byrjar nýjan leik, núllstillir "samtals" stigin, 
     * biður um nýtt nafn og tekur burt Opacity sem var búið að stilla.
     * @param event 
     */
    @FXML
    private void NyrLeikurHandler(ActionEvent event) {
    String nafn = yahtzeeController.saekjaNafnLeikmanns();    
    yahtzeeController.leikur = new YahtzeeImp(nafn);
     yahtzeeController.leikur = new YahtzeeImp(nafn);
        yahtzeeController.jNafnLeikmanns.setText("Nafn:\n"+nafn);
        yahtzeeController.jFjoldiEftir.setText("2");
        yahtzeeController.stigKomin = 0;
        yahtzeeController.fjoldiEftir = 2;
        yahtzeeController.nullstilla();
    }
    /**
     * Með þessum handler er hægt að hætta að spila í stað þess að 
     * þurfa að ýta á "x" hnappinn.
     * @param event 
     */
    @FXML
    private void HaettaHandler(ActionEvent event) {
        System.out.println("Sjáumst Seinna!");
        System.exit(0);
    }
    /**
     * Þessi handler sýnir nýjan glugga sem að gefur leikmann leikreglur
     * @param event 
     */
        @FXML
    private void leikreglurHandler(ActionEvent event) {
        Alert leikreglur = new Alert(Alert.AlertType.INFORMATION);
        leikreglur.setTitle("Leikreglur");
        leikreglur.setContentText("I) Í upphafi hverrar umferðar þá hefur leikmaður þrjú köst.\n"
                + "II) Eftir fyrsta kast þá velur leikmaður sér ákveðna tölu, smellir á teningana sem hann vill geyma og kastar aftur.\n"
                + "III) Eftir hvert kast getur leikmaður valið sér fleiri teninga af sömu tegund.\n"
                + "IV) Loks, þegar leikmaður er búinn að kasta þrisvar þá smellir hann á þá tölu sem hann vill geyma.\n"
                + "V)Þá hefst ný umferð og leikmaður endurtekur þetta þar til allar tölur eru búnar.\n"
                + "VI) Hnappurinn, Taka Sénsinn, leyfir leikmanni að velja hvaða tölur sem er saman.\n"
                + "VII) Markmið leiksins er að fá sem flest stig");
        leikreglur.showAndWait();
    }
    /**
     * Þessi handler gefur upplýsingar um forritið.
     * @param event 
     */
    @FXML
    private void umForritidHandler(ActionEvent event) {
        Alert umForritid = new Alert(Alert.AlertType.INFORMATION);
        umForritid.setHeaderText("");
        umForritid.setContentText("Höfundur: Þorri Harðarson\nÚtgáfa: v1.0.0");
        umForritid.showAndWait();
    }
    
    
}
    


    
    

