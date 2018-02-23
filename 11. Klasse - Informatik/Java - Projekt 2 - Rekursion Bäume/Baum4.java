import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Baum4
{
    // Objekte
    Bildschirm derBildschirm;
    Stift hatStift;

    // Konstruktor
    public Baum4()
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
        hatStift.bewegeBis(500, 500);
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
            hatStift.dreheUm(30);
            this.zeichneBaum(pLaenge * 2 / 3);
            hatStift.dreheUm(-30);
            this.zeichneBaum(pLaenge * 2 / 3);
            hatStift.dreheUm(-30);
            this.zeichneBaum(pLaenge * 2 / 3);
            hatStift.dreheUm(-30);
            this.zeichneBaum(pLaenge * 2 / 3);
            hatStift.dreheUm(60);
            hatStift.bewegeUm(-pLaenge);
        }
    }
}