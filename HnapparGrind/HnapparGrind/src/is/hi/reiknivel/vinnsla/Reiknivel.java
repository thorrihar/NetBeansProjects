package is.hi.reiknivel.vinnsla;

/**
 * Klasinn Reiknivél sér um vinnslu reiknivélar 
 * Virkjarnir eru +,-,*,/ en röð virkja er frá vinstri til hægri 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class Reiknivel {
    private int utkoma; // útkoman á reiknivél
    private int tala;    // síðasta talan sem var sett inn
    boolean erTala;     //  satt ef komin er tala annars ósatt
    private  enum virkiTegund {PLUS,MINUS,DEILING,MARGFOLDUN,JAFNTOG, NULL}; // nýtt tag til að geyma virkja
    private virkiTegund virki; // síðasti virkinn 

       
    /**
     * 
     * Smiður 
     * 
     */
    public Reiknivel () {
        this.utkoma = 0;
        endurSetja();
    }
    
    /** 
     * Núllstillir allar tilviksbreytur nema útkomu 
     */
    private void endurSetja() {
        tala=0;
        erTala=false;
        virki = virkiTegund.NULL;
    }
    
    public int getUtkoma() {
        return utkoma;
    }
    
    /** 
     * Núllstillir allar tilviksbreytur 
     */
    public void nullStilla() {
        utkoma=0;
        endurSetja();
    }
    
    /**
     * Reiknar með núverandi virkja, uppfærir utkoma og núllstillir tala
     * Ef deilt er með 0 þá er skilað 0 
    */
    private void reikna() {
         switch (virki) {
            case PLUS:
                utkoma = utkoma+tala; break;
            case MINUS:
                utkoma = utkoma-tala; break;
            case DEILING:
                if (tala==0)           
                    utkoma = 0;
                else
                    utkoma = utkoma/tala; 
                break;
            case MARGFOLDUN:
                utkoma = utkoma*tala; break;
            case NULL:
                utkoma = tala;  break;
        }
        endurSetja();
    }
        
   /**
    * Setur tölu í reiknivélina og færir sætið um eitt 
    * @param tala er talan sem bætt er við
    */
    public void setTala(int tala) {
        erTala=true;    // komin tala 
        this.tala = this.tala*10+tala; 
    }   
    
    /**
     * Setur tilviksbreytuna virki út frá inntakinu v
     * @param v  virki á forminu char. Getur verið +,-,/ eða *
     * @return 2 ef þegar er kominn virki, 0 ef v er á réttu formi annars 1     
    */
    public int setVirki(char v) {
        int villa = 0;
 
        // athuga hvort það koma tveir virkjar í röð  
      
        if(!erTala) {
            return 2;
        }
        reikna();
  
    
         switch (v) {
            case '+':
                virki = virkiTegund.PLUS;
                break;
            case '-':
                virki = virkiTegund.MINUS;
                break;
            case '/':
                virki = virkiTegund.DEILING;
                break;
            case '*':
                virki = virkiTegund.MARGFOLDUN;
                break;
            case '=':
                break;
            default:
                // Virki óþekktur 
                villa=1;
                break;
        } 
        return villa;
      }
}
