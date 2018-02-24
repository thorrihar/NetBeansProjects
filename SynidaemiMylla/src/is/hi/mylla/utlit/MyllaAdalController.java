
package is.hi.mylla.utlit;

import java.net.URL;
import java.util.ResourceBundle;
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myllaBord.setAdal(this);
        myllaBord.teiknaGrunnbord(mittCanvas.getGraphicsContext2D());
        myllaBord.leikmadurGerir(1);
        myllaBord.leikmadurGerir(2);
    }    

    

   /**
     * Birtir villuskilaboð í strengnum s
     *
     * @param s villuskilaboð
     */
    public void birtaVilluskilaboð(String s) {
          skilabod.setText(s);
    }
    
}
