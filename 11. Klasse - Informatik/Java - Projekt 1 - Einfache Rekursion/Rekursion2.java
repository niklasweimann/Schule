
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Rekursion2
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;

    // Konstruktor
    public Rekursion2()
    {
        derBildschirm = new Bildschirm(1000, 500);
        meinStift = new Stift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        int laenge = 100;
        meinStift.bewegeBis(200, 300);
        this.zeichneDreieck(laenge);
	    
        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
    }
    
    public void zeichneDreieck(int pLaenge)
    {
        if(pLaenge > 1)
        {
            meinStift.runter();
            meinStift.bewegeUm(pLaenge);
            meinStift.dreheUm(120);
            meinStift.hoch();
            this.zeichneDreieck(pLaenge *9 /10);
        }
    }
}