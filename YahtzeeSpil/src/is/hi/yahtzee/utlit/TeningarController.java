/**
 * Þorri Harðarson
 * thh170@hi.is
 * Yahtzee
 */
package is.hi.yahtzee.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import is.hi.yahtzee.vinnsla.Teningar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


/**
 * TeningarController klasinn sér um, myndirnar af teningunum, 
 * ásamt vinnslu þeirra í viðmótinu. Þessi FXML skrá er hægra megin 
 * í viðmótinu.
 *
 * @author Þorri Harðarson, Háskóli Íslands.
 */
public class TeningarController implements Initializable {

    @FXML
    private Label jTeningur0;
    @FXML
    private Label jTeningur1;
    @FXML
    private Label jTeningur2;
    @FXML
    private Label jTeningur3;
    @FXML
    private Label jTeningur4;
 
    final Teningar teningurinn = new Teningar(5);
    private Label[] label;
    private final String[] myndir = new String []{"one","two","three","four","five","six"};
    private final Image[] icon = new Image[6]; 
    private YahtzeeController yahtzeeController;
    /**
    * Náum í YahtzeeController hlutinn
    * @param yahtzee 
    */
    public void init(YahtzeeController yahtzee){
        yahtzeeController = yahtzee;
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label = new Label[] {jTeningur0, jTeningur1, jTeningur2, jTeningur3, jTeningur4};
    }    
    /**
     * Uppfærir myndirnar sem eru sýndar í nýrri umferð.
     */
    public void myndirnar(){
        int[] temp = teningurinn.getTeningar();
        boolean[] geyma = teningurinn.getGeymdur();
        for(int i=0; i<=4; i++){
            if(!geyma[i]){
                label[i].setGraphic(new ImageView(icon[temp[i]-1]));
            }
        }
        yahtzeeController.jFjoldiEftir.setText(Integer.toString(yahtzeeController.fjoldiEftir));
    }
    /**
     * Þessi handler setur myndirnar í array.
     */
    public void teningarGrid(){
        for(int i=0; i<6; i++){
            icon[i] = new Image(getClass().getResourceAsStream("myndir/"+myndir[i]+".jpg"));
        }
    }
    /**
     * Þessi handler finnur númer á label'i með for-lykkju.
     * @param l
     * @return 
     */
    private int finnaTolu(Label l){
        for (int i=0; i<label.length; i++){
            if (label[i]==l){
                return i;
            }
        }
        return 1337;
    }
    /**
     * Þessi handler geymir ákveðin gildi, 
     * og breytir Opacity til að sýna það.
     * @param event 
     */
    @FXML
    public void jTeningurGeyma(MouseEvent event) {
        int tala = finnaTolu((Label)event.getSource());
        label[tala].setOpacity(0.25);
        teningurinn.setGeymdur(tala, true);
    }
    /**
     * Þessi handler kastar teningunum.
     */
    public void kasta(){
        for(int i=0; i<5; i++){
            System.out.println();
            teningurinn.kasta(i);
        }
    }
    /**
     * Þessi handler tekur burt Opacity sem er sett þegar teningar eru 
     * geymdir.
     */
    public void Opacity(){
        for(int i=0; i<5; i++){
            label[i].setOpacity(1.0);
        }
    }
}
