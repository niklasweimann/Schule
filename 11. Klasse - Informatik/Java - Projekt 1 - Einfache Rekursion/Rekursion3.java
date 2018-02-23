
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Rekursion3
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;

    // Konstruktor
    public Rekursion3()
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
        this.zeichnePentagon(laenge);
	    
        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
    }
    
    public void zeichnePentagon(int pLaenge)
    {
        if(pLaenge > 1)
        {
            meinStift.runter();
            meinStift.bewegeUm(pLaenge);
            meinStift.dreheUm(45);
            meinStift.hoch();
            this.zeichnePentagon(pLaenge *9 /10);
        }
    }
}