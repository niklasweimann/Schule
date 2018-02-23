
import sum.kern.*;
/**
 * @author Niklas Weimann
 * @version 1.0.0
 */
public class Rekursion
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;

    // Konstruktor
    public Rekursion()
    {
        derBildschirm = new Bildschirm(1000, 500);
        meinStift = new Stift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        int laenge = 10;
        
        meinStift.bewegeBis(100, 100);
        this.zeichneLinie(laenge);
	    
        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
    }
    
    public void zeichneLinie(int pLaenge)
    {
        if (pLaenge > 1)
        {
            meinStift.bewegeUm(pLaenge);
            meinStift.hoch();
            meinStift.bewegeUm(5);
            meinStift.runter();
            this.zeichneLinie(pLaenge *9 / 10);
        }
    }
}