
package is.hi.spil.vinnsla;

/**
 * Interface fyrir stigablað fyrir einfaldan yatzee leik.
 * 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 * @date
 * Háskóli Íslands
 */
public interface Yatzee {

    String getNafnLeikmanns();

    /**
     * Nær í summuna af stigunum á blaðinu
     * @return summan af stigunum
     */
    int getSumma();

    /**
     * Reiknar út útkomuna úr reit i (ásar, tvistar, ...
     * sexur) á Yatzeeblaði miðað
     * við stöðu teninganna í breytu teningar
     * @param teningar  teningarnir á borðinu
     * @param i lína á yatzee blaðinu
     * @return
     */
    int reiknaEinfalda(int i, Teningar teningar);

    /***
     * Reiknar út stigin fyrir taka sénsinn út frá teningunum
     * @param teningar
     * @return stigin
     */
    int reiknaSensinn(Teningar teningar);

    /**
     * Reiknar summu stigana á Yatzee blaði
     * @return
     */
    int reiknaSumma();

    void setNafnLeikmanns(String nafnLeikmanns);
    
}
