import sum.kern.*;
/**
 * @author Niklas Weimann
 * @version 1.0.0
 */
public class ObstBaum
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift hatStift;

    // Konstruktor
    public ObstBaum()
    {
        derBildschirm = new Bildschirm(1000, 1000);
        hatStift = new Buntstift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        double Laenge = 200;
        hatStift.dreheUm(90);
        hatStift.bewegeBis(500, 800);
        hatStift.runter();
        this.zeichneBaum(Laenge, 0);
	    
        // Aufraeumen
        hatStift.gibFrei();
        derBildschirm.gibFrei();
    }
    
    public void zeichneBaum(double pLaenge, int pStufe)
    {
        if (pLaenge > 10)
        {
            hatStift.bewegeUm(pLaenge);
            hatStift.dreheUm(60);
            this.zeichneBaum(pLaenge * 2 / 3, pStufe+1);
            hatStift.dreheUm(-120);
            this.zeichneBaum(pLaenge * 2 / 3, pStufe+1);
            hatStift.dreheUm(60);
            hatStift.bewegeUm(-pLaenge);
        }
        if (pStufe == 8)
        {
            hatStift.setzeFarbe(10);
            hatStift.zeichneKreis(3);
            hatStift.setzeFarbe(0);
        }
    }
}