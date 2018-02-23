
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Rekursion1
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;

    // Konstruktor
    public Rekursion1()
    {
        derBildschirm = new Bildschirm(1000,500);
        meinStift = new Stift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        int laenge = 100;
        meinStift.bewegeBis(100, 100);
        this.zeichneForm(laenge);
	    
        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
    }
    
    public void zeichneForm(int pLaenge)
    {
        if(pLaenge >1)
        {
            meinStift.runter();
            meinStift.bewegeUm(pLaenge);
            meinStift.dreheUm(90);
            meinStift.hoch();
            this.zeichneForm(pLaenge *9 /10);
        }
    }
}