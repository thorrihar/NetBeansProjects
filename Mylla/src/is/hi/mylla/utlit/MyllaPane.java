/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package is.hi.mylla.utlit;



import is.hi.mylla.vinnsla.Mylla;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Viðmótshlutur sem teiknar mylluborð, býr til peð og meðhöndlar aðgerð þegar 
 * peð er sett á borð 
 * @author Ebba Þóra Hvannberg ebba@hi.is 
 * @date 
 * Háskóli Íslands
 */
public class MyllaPane extends Pane {

    private MyllaAdalController mAdal; 
    
    private MylluReitur[] reitir;
    
    public MyllaPane () { 
        
    }
    
    public void leikmadurGerir(int leikmadur) {
        nyttPed(leikmadur);
    }

    // Vinnsluklasinn sem heldur utan um mylluborðið og leikmenn
    public final Mylla mittBord = new Mylla();
    
   /**
    * Teiknar grunnborð myllunnar á graphics context g. 
    * Er ekki að fullu útfært 
    * @param g 
    */
    public void teiknaGrunnbord(GraphicsContext g) {
        g.setLineWidth(5);
        g.strokeLine(100,200,400,200);  //efri lína
        g.strokeLine(100,300,400,300);  //neðri lína
        g.strokeLine(200,100,200,400);   //vinstri lína 
        g.strokeLine(300,100,300,400);   //hægri lína
        
    }
    
    /**
     * Athugar á hvaða reit peð er, hvort peð er þegar á þeim reit setur peðið á
     * þann reit og athugar hvort það er vinningur.
     *
     * @param x x-gildi hnits
     * @param y y-gildi hnits
     */
    public void setjaABord(int x, int y) {
        int reitur = -1;
        for(int i=0; i<9; i++){
            if(reitir[i].erInnan(x,y)){
                reitur = i;  
                System.out.println("Reitur nr." + i);
            }
        }
      if (reitur != -1){
          if (!mittBord.erThegarABordi(reitur)){
              mittBord.setjaABord(reitur);
              mAdal.birtaVilluskilaboð("");
              if(mittBord.vinningur() != -1){
                  mAdal.Sigur(mittBord.getNuverandiLeikmadur());
                  //mAdal.jLeikmadur1.setDisable(true);
                  //mAdal.jLeikmadur2.setDisable(true);    
              }
          }
          else{
              mAdal.birtaVilluskilaboð("Veldu annan reit");       
                    }
      }
      else{
           mAdal.birtaVilluskilaboð("peð er utan reits"); 
      }    
    }
    /**
     * Setur út nýtt peð fyrir leikmann l ef fjöldi peða hefur ekki náð hámarki
     *
     * @param l LEIKMADUR1 eða LEIKMADUR2
     */
    
    private void nyttPed(int l) {
        Ped s;
        Color graenn = Color.web("#DC143C",1.0);
        Color raudur = Color.web("#3CB371",1.0);
        if (l == 1) {
            s = new Ferningur(this, graenn);
        } else {
            s = new Hringur(this, raudur);
        }

        this.getChildren().add(s.getPed());
    }

    void setAdal(MyllaAdalController aThis) {
        mAdal = aThis;
    }
    void Reitir(int upphx, int upphy, int breidd, int haed){
        reitir = new MylluReitur[9];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                reitir[i*3+j] = new MylluReitur(upphx+breidd*j, upphy+haed*i, breidd, haed);
            }
        }
    }
    void NyrLeikur(){
        mAdal.jSigur.setText("");
        mAdal.birtaVilluskilaboð("");
        while(this.getChildren().size()>1){
            this.getChildren().remove(2);
        }
       
       // mAdal.jLeikmadur1.setSelected(false);
      //  mAdal.jLeikmadur2.setSelected(false);
      //  mAdal.jLeikmadur1.setDisable(false);
       // mAdal.jLeikmadur2.setDisable(false); 
    }
}
