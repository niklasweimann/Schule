import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Lokomotive extends Waggon
{
    // Objekte
    Bildschirm hatBildschirm;
    // Konstruktor
    public Lokomotive(Bildschirm pBildschirm)
    {
        super(pBildschirm);
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil

        // Aufraeumen

    }

    /**
     * Gibt alle verwendeten Objekte frei.
     * 
     */
    public void zeichne()
    { 
        hatStift.runter();
        //Vordere Kupplung
        hatStift.dreheBis(90);
        hatStift.bewegeUm(10);
        hatStift.bewegeUm(-5);
        hatStift.dreheBis(0);
        hatStift.bewegeUm(5);
        //vorderer Bereich
        hatStift.dreheBis(-90);
        hatStift.bewegeUm(5);
        hatStift.bewegeUm(-45);
        hatStift.dreheBis(0);
        hatStift.bewegeUm(20);
        hatStift.dreheBis(90);
        hatStift.bewegeUm(20);
        hatStift.zeichneRechteck(5,20);
        hatStift.dreheBis(-90);
        hatStift.bewegeUm(20);
        hatStift.dreheBis(0);
        hatStift.bewegeUm(30);
        hatStift.dreheBis(-90);
        hatStift.bewegeUm(50);
        hatStift.dreheBis(180);
        hatStift.bewegeUm(55);
        hatStift.bewegeUm(-10);
        hatStift.dreheBis(-90);
        hatStift.hoch();
        hatStift.bewegeUm(6);
        hatStift.zeichneKreis(5);
        hatStift.bewegeUm(-6);
        hatStift.runter();
        hatStift.dreheBis(0);
        hatStift.bewegeUm(45+30);
        hatStift.dreheBis(90);
        hatStift.bewegeUm(70);
        hatStift.dreheBis(180);
        hatStift.bewegeUm(30);
        hatStift.dreheBis(-90);
        hatStift.bewegeUm(10);
        hatStift.hoch();
        hatStift.dreheBis(90);
        hatStift.bewegeUm(5);
        hatStift.zeichneRechteck(20,20);
        hatStift.bewegeUm(-5);
        hatStift.dreheBis(-90);
        hatStift.bewegeUm(20);
    }
    

}