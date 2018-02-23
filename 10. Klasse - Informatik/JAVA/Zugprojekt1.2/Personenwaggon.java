
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Personenwaggon extends Waggon
{
    // Objekte
    Bildschirm hatBildschirm;
    // Konstruktor
    public Personenwaggon(Bildschirm pBildschirm)
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
       hatStift.hoch();
        hatStift.bewegeBis(this.hPosition(),this.vPosition());
        hatStift.runter();
        hatStift.dreheBis(90);
        hatStift.bewegeUm(3);
        hatStift.dreheUm(180);
        hatStift.bewegeUm(6);
        hatStift.dreheUm(180);
        hatStift.bewegeUm(3);
        hatStift.dreheUm(270);
        hatStift.bewegeUm(5);
        hatStift.dreheUm(90);
        hatStift.bewegeUm(45);
        hatStift.zeichneRechteck(80,50);
        hatStift.hoch();
        hatStift.dreheUm(270);
        hatStift.bewegeUm(4);
        hatStift.dreheUm(270);
        hatStift.bewegeUm(10);
        hatStift.runter();
        hatStift.zeichneRechteck(15,35);
        hatStift.hoch();
        hatStift.dreheUm(90);
        hatStift.bewegeUm(19);
        hatStift.runter();
        hatStift.zeichneRechteck(15,10);
        hatStift.hoch();
        hatStift.bewegeUm(19);
        hatStift.runter();
        hatStift.zeichneRechteck(15,10);
        hatStift.hoch();
        hatStift.bewegeUm(19);
        hatStift.runter();
        hatStift.zeichneRechteck(15,10);
        hatStift.hoch();
        hatStift.dreheUm(270);
        hatStift.bewegeUm(10);
        hatStift.runter();
        hatStift.zeichneRechteck(15,10);
        hatStift.hoch();
        hatStift.dreheUm(270);
        hatStift.bewegeUm(19);
        hatStift.runter();
        hatStift.zeichneRechteck(15,10);
        hatStift.hoch();
        hatStift.bewegeUm(19);
        hatStift.runter();
        hatStift.zeichneRechteck(15,10);
        hatStift.hoch();
        hatStift.bewegeUm(19);
        hatStift.runter();
        hatStift.dreheUm(90);
        hatStift.hoch();
        hatStift.bewegeUm(35);
        hatStift.dreheUm(90);
        hatStift.bewegeUm(11);
        hatStift.runter();
        hatStift.zeichneKreis(5);
        hatStift.hoch();
        hatStift.bewegeUm(50);
        hatStift.runter();
        hatStift.zeichneKreis(5);
        hatStift.hoch();
        hatStift.bewegeUm(15);
        hatStift.dreheUm(90);
        hatStift.bewegeUm(10);
        hatStift.runter();
        hatStift.dreheUm(270);
        hatStift.bewegeUm(5);
        hatStift.dreheUm(90);
        hatStift.bewegeUm(3);
        hatStift.dreheUm(180);
        hatStift.bewegeUm(6);
        hatStift.dreheUm(180);
        hatStift.bewegeUm(3);
    }    

}