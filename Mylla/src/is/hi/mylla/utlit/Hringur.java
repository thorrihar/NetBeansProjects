
package is.hi.mylla.utlit;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Hringur sem erfir frá peði á mylluborði. Getur brugðist við drag
 * og release á músinni. Þegar músinni er sleppt er athugað hvort 
 * peðið sé innan mylluborðsins 
 * @author Ebba Þóra Hvannberg ebba@hi.is 
 * @date Febrúar 2018
 * Háskóli Íslands
 */
public class Hringur extends Ped {
     /**
     * Atburðarhandler fyrir þegar músin er dregin 
     * Peðið er fært 
     */
    private final EventHandler<MouseEvent> mouseDragged =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    faeraHlut( (Circle)ped, event);
                }
            };
    /***
     * Atburðarhandler fyrir þegar músinni er sleppt 
     * Peðið er sett á mylluborðið 
     */
    private final EventHandler<MouseEvent> mouseReleased =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println (" Mús sleppt ");
                    bord.setjaABord( (int)((Circle)ped).getCenterX(),
                               (int)((Circle)ped).getCenterY());
                }
            };
    
    /**
     * Smíðar hring á mylluborð b með lit l
     * @param b mylluborð
     * @param l litur
     */
    public Hringur (MyllaPane b, Color l) {
            super(b);
            ped = new Circle(250, 525, 25);
            ped.setStroke(l);
            ped.setFill(l);
            ped.setOnMouseDragged(mouseDragged);
            ped.setOnMouseReleased(mouseReleased);
    }

    
     /**
     * Færir  hring s í x,y hnit á event 
     * @param s
     * @param event upplýsingar um released atburðurinn - notum (x,y)
     */
    @Override
    protected void faeraHlut(Shape s, MouseEvent event) {                                  
        ((Circle)s).setCenterX(event.getX());
        ((Circle)s).setCenterY(event.getY());
    }  
    
}
