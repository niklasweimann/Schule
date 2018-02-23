import sum.kern.*;
import sum.werkzeuge.Uhr;
/**
 * @author Niklas Weimann
 * @version 1.0.0
 */
public class Hauptprogramm
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Kugel meineKugel;
    Kugel meineKugel2;
    Uhr meineUhr;

    // Konstruktor
    public Hauptprogramm()
    {
        derBildschirm = new Bildschirm(500,500);
        meinStift = new Buntstift();
        meineKugel = new Kugel(100, 100,10, 1, 0, 3, derBildschirm);
        meineKugel2 = new Kugel(50, 100,10, 1, 0, 5, derBildschirm);
        meineUhr = new Uhr();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        meineKugel.zeichne();
        meineKugel2.zeichne();
        for (int i = 0; i <= 100000; i++)
        {
            if(meineKugel2.kollisionKugel(meineKugel.hPosition(), meineKugel2.hPosition(), meineKugel.vPosition(), meineKugel2.vPosition()))
            {
                meineKugel2.setzeRichtung(180-meineKugel2.richtung());
                meineKugel2.bewege(1);
            }
            else if(meineKugel2.kollisionMitRand() == true){
                meineKugel2.setzeRichtung(180-meineKugel2.richtung());
            }
            else{
                meineKugel2.bewege(1);
            }
            
        }
        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
        meineKugel.gibFrei();
    }
}