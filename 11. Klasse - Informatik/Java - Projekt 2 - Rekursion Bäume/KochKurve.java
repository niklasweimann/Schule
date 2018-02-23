import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class KochKurve
{
    // Objekte
    Bildschirm derBildschirm;
    Stift hatStift;

    // Konstruktor
    public KochKurve()
    {
        derBildschirm = new Bildschirm(1000,500);
        hatStift = new Stift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        hatStift.bewegeBis(500,100);
        hatStift.runter();
        hatStift.dreheUm(60);
        this.zeichneSchneeFlocke(4, 200);

        // Aufraeumen
        hatStift.gibFrei();
        derBildschirm.gibFrei();
    }

    public void zeichneSchneeFlocke(int stufe, double laenge)
    {
        for(int i = 1; i <=3; i++)
        {
            this.zeichneKochKurve(stufe, laenge);
            hatStift.dreheUm(-120);
        }
    }

    public void zeichneKochKurve(int stufe, double laenge)
    {
        double teillaenge = laenge/3;
        if (stufe > 1)
        {
            this.zeichneKochKurve(stufe-1, teillaenge);
            hatStift.dreheUm(60);
            this.zeichneKochKurve(stufe-1, teillaenge);
            hatStift.dreheUm(-120);
            this.zeichneKochKurve(stufe-1, teillaenge);
            hatStift.dreheUm(60);
            this.zeichneKochKurve(stufe-1, teillaenge);
        }
        else
        {
            hatStift.bewegeUm(laenge);
        }

    }
}