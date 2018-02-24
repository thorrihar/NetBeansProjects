/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package is.hi.spil.vinnsla;



/**
 *
 * @author Expression Þorri is undefined on line 12, column 14 in Templates/Classes/Class.java.
 * @date
 * Háskóli Íslands
 */
public class YatzeeImp implements Yatzee {
    
private String nafnLeikmanns;
private final int [] stigin = new int [7];
private int summa=0;

    public YatzeeImp(String s) {
    this.nafnLeikmanns = s;    
    }
    @Override
    public String getNafnLeikmanns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSumma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reiknaEinfalda(int i, Teningar teningar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reiknaSensinn(Teningar teningar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reiknaSumma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNafnLeikmanns(String nafnLeikmanns) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
