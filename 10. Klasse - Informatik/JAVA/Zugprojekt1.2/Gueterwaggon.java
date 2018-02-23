
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Gueterwaggon extends Waggon
{
    // Objekte
    Bildschirm hatBildschirm;
    // Konstruktor
    public Gueterwaggon(Bildschirm pBildschirm)
    {
        super(pBildschirm);
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil

        // Aufraeumen
        hatStift.gibFrei();
        hatBildschirm.gibFrei();
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    (Beschreibung des Parameters)
     * @return      (Beschreibung des Rückgabewertes)
     */
    public void zeichne()
    {
        hatStift.hoch();
        hatStift.bewegeBis(this.hPosition(),this.vPosition());
        hatStift.runter();
        
        //Puffer links
        hatStift.dreheBis(90); //oben
        hatStift.bewegeUm(3);
        hatStift.dreheUm(180); //unten
        hatStift.bewegeUm(6);
        hatStift.dreheUm(180); //oben
        hatStift.bewegeUm(3);
        hatStift.dreheUm(270); //rechts
        hatStift.bewegeUm(5);
        
        //Boden
        hatStift.hoch();
        hatStift.dreheUm(90); //oben
        hatStift.bewegeUm(10);
        hatStift.zeichneRechteck(100,15);
        
        //Wand links
        hatStift.bewegeUm(30);
        hatStift.dreheUm(-90); //rechts
        hatStift.bewegeUm(1);
        hatStift.zeichneRechteck(5,30);
        
        //Wand rechts
        hatStift.bewegeUm(93);
        hatStift.zeichneRechteck(5,30);
        
        //Raeder
        hatStift.bewegeUm(-4);
        hatStift.dreheUm(270); //unten
        hatStift.bewegeUm(50);
        hatStift.zeichneKreis(5);
        hatStift.dreheUm(90);  //rechts
        hatStift.bewegeUm(-80);
        hatStift.zeichneKreis(5);
        hatStift.bewegeUm(90);
        hatStift.dreheUm(90); //oben
        hatStift.bewegeUm(10);
        
        //Puffer rechts
        hatStift.runter();
        hatStift.dreheUm(270); //rechts
        hatStift.bewegeUm(5);
        hatStift.dreheUm(90);  //oben
        hatStift.bewegeUm(3);
        hatStift.dreheUm(180); //unten
        hatStift.bewegeUm(6);
        hatStift.dreheUm(180); //oben
        hatStift.bewegeUm(3);
    }
}