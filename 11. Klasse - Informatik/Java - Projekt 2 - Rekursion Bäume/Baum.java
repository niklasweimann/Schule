
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Baum
{
    // Objekte
    Bildschirm derBildschirm;
    Stift hatStift;

    // Konstruktor
    public Baum()
    {
        derBildschirm = new Bildschirm(1000, 500);
        hatStift = new Stift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        double Laenge = 200;
        hatStift.dreheUm(90);
        hatStift.bewegeBis(700, 300);
        hatStift.runter();
        this.zeichneBaum(Laenge);

        // Aufraeumen
        hatStift.gibFrei();
        derBildschirm.gibFrei();
    }

    public void zeichneBaum(double pLaenge)
    {
        if (pLaenge > 10)
        {
            hatStift.bewegeUm(pLaenge);
            hatStift.dreheUm(60);
            this.zeichneBaum(pLaenge * 2 / 3);
            hatStift.dreheUm(-120);
            this.zeichneBaum(pLaenge * 2 / 3);
            hatStift.dreheUm(60);
            hatStift.bewegeUm(-pLaenge);
        }
        
    }
}