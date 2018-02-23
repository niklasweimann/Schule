import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author Herr Stierl
 * @version R2D2
 */

//TODO Aktionsteile ausfuellen.
public class Ufo
{
    // Objekte
    Bildschirm kenntBildschirm;
    Buntstift hatStift;
    Uhr meineUhr;
    double ufoGroesse;
    double geschwindigkeit;

    // Konstruktor
    public Ufo(double xpos, double ypos,double ufoGroesse, double pGeschwindigkeit, Bildschirm kenntBildschirm)
    {
        hatStift = new Buntstift();
        meineUhr = new Uhr();
        this.kenntBildschirm = kenntBildschirm;
        hatStift.bewegeBis(xpos, ypos);
        this.geschwindigkeit = pGeschwindigkeit;
        this.ufoGroesse = ufoGroesse;
    }

    // Dienste
    public void bewege()
    {
        this.loesche();
        hatStift.bewegeUm(geschwindigkeit);
        this.zeichne();
        meineUhr.warte(5);
        geschwindigkeit += geschwindigkeit/1000;
    }
    
    public void zeichne()
    {
        // Aktionsteil
        hatStift.zeichneKreis(ufoGroesse);
    }
    public void setzeFarbe(int farbe){
        hatStift.setzeFarbe(farbe);
    }
    public void gibFrei()
    {
        hatStift.gibFrei();
        kenntBildschirm.gibFrei();
        meineUhr.gibFrei();
    }
    public void loesche()
    {
        // Aktionsteil
        hatStift.radiere();
        hatStift.zeichneKreis(ufoGroesse);
        hatStift.normal();
    }
    
    public double richtung()
    {
        return hatStift.winkel();
    }
    
    public void dreheLinks()
    {
        hatStift.dreheUm(5);        
    }
    
    public void dreheRechts()
    {
        hatStift.dreheUm(-5);        
    }
    
    public void setzeMuster(int muster)
    {
        hatStift.setzeFuellmuster(muster);
    }
    
    public double xPos()
    {
        return hatStift.hPosition();
    }
    
    public double yPos()
    {
        return hatStift.vPosition();
    }
       
    public boolean amLinkenRand()
    {
        if(this.xPos() < ufoGroesse)
        {
            return true;
        }
        return false;
    }

    public boolean amRechtenRand()
    {
        if(this.xPos() > this.kenntBildschirm.breite()-this.ufoGroesse)
        {
            return true;
        }
        return false;
    }

    public boolean amOberenRand()
    {
        if(this.yPos() < ufoGroesse)
        {
            return true;
        }
        return false;
    }

    public boolean amUnterenRand()
    {
        // Aktionsteil
        if(this.yPos() > (kenntBildschirm.breite() - ufoGroesse))
        {
            return true;
        }
        return false;
    }
}