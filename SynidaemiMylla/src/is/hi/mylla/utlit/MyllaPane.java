
package is.hi.mylla.utlit;



import is.hi.mylla.vinnsla.Mylla;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

/**
 * Viðmótshlutur sem teiknar mylluborð, býr til peð og meðhöndlar aðgerð þegar 
 * peð er sett á borð 
 * @author Ebba Þóra Hvannberg ebba@hi.is 
 * @date 
 * Háskóli Íslands
 */
public class MyllaPane extends Pane {

    private MyllaAdalController mAdal;
    
     public void teiknaGrunnbord(GraphicsContext g){
        g.strokeLine(100, 100, 190, 100);    
        g.setStroke(Color.RED);
        g.strokeLine(100, 90, 190, 90);
     }
     
    public void leikmadurGerir(int leikmaður){
        nyttPed(leikmaður);
    } 
    
    public MyllaPane () { 
        
    }
    

    // Vinnsluklasinn sem heldur utan um mylluborðið og leikmenn
    private final Mylla mittBord = new Mylla();
    
   
    
    /**
     * Athugar á hvaða reit peð er, hvort peð er þegar á þeim reit setur peðið á
     * þann reit og athugar hvort það er vinningur.
     *
     * @param x x-gildi hnits
     * @param y y-gildi hnits
     */
    public void setjaABord(int x, int y) {
        
        mAdal.birtaVilluskilaboð("peð lendir á borði");  
       
    }
    /**
     * Setur út nýtt peð fyrir leikmann l (ferning eða hring) 
     * ef fjöldi peða hefur ekki náð hámarki
     * @param l LEIKMADUR1 eða LEIKMADUR2
     */
    private void nyttPed(int leikmadur) {
        // Forritun þessarar aðferðar er ólokið 
        Ped s;

        if (leikmadur == 1){
        s = new Ferningur(this, Color.PINK);
        this.getChildren().add(s.getPed());
        }
        else if (leikmadur == 2){
        s = new Hringur(this, Color.TURQUOISE);
        this.getChildren().add(s.getPed());
        }
    }

    /***
     * Frumstillir teningu í aðalcontroller 
     * @param aThis 
     */
    void setAdal(MyllaAdalController aThis) {
        mAdal = aThis;
    }

    
    
}
