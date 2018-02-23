
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Rekursion4
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;

    // Konstruktor
    public Rekursion4()
    {
        derBildschirm = new Bildschirm(1000, 500);
        meinStift = new Stift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        double laenge = 10;
        meinStift.bewegeBis(200, 300);
        this.zeichneKreis(laenge);
	    
        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
    }
    
    public void zeichneKreis(double pLaenge)
    {
        if(pLaenge > 1)
        {
            meinStift.runter();
            meinStift.bewegeUm(pLaenge);
            meinStift.dreheUm(5);
            meinStift.hoch();
            this.zeichneKreis(pLaenge -pLaenge/100);
        }
    }
}