/**
 * Þorri Harðarson
 * thh170@hi.is
 * Yahtzee
 */
package is.hi.yahtzee.vinnsla;

/**
 * YahtzeeImp implementar Yahtzee
 * @author Þorri Harðarson, Háskóli Íslands.
 */
public class YahtzeeImp implements Yatzee{
    
    private String nafnLeikmanns;
    private final int[] stig = new int[7];
    private int summa = 0;
    
    public YahtzeeImp(String nafn){
        nafnLeikmanns = nafn;
    }
    

    @Override
    public String getNafnLeikmanns() {
        return nafnLeikmanns;
    }
    

    @Override
    public void setNafnLeikmanns(String nafnLeikmanns){
        this.nafnLeikmanns = nafnLeikmanns;
    }
    

    @Override
    public int getSumma() {
        return summa;
    }
    

    public int reiknaSensinn(Teningar teningar) {
            int temp = 0;
            int teningurT[] = teningar.getTeningar();
            for(int i=0; i<5; i++) {
                temp += teningurT[i];
            }
            stig[0] = temp;
            return temp; 
    }
    

    @Override
    public int reiknaEinfalda(int k, Teningar teningar) {
        int temp = 0;
        int teningurT[] = teningar.getTeningar();
        for(int i = 0; i < 5; i++) {
            if(teningurT[i] == k) {
                temp += teningurT[i];
            }
        }
        stig[k] = temp;
        return temp;
    }
    

    @Override
    public int reiknaSumma() {
        int temp = 0;
        for(int i=0; i<7; i++){
            temp += stig[i];
        }
        this.summa = temp;
        return temp;
    }   
}
