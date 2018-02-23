import java.awt.*;
import sum.kern.*;
/**
 * @author Herr Stierl
 * @version 3.14159
 */

//TODO Aktionsteile ausfuellen.
public class Ufo
{
    // Objekte
    Bildschirm kenntBildschirm;
    Buntstift hatStift;
    Buntstift hatStift2;
    Buntstift radierStift;
    int ufoGroesse;
    double geschwindigkeit;
    double startgeschwindigkeit;
    int muster=1;
    int farbe=1;
    

    // Konstruktor
    public Ufo(double xpos, double ypos,int ufoGroesse, double geschwindigkeit, Bildschirm kenntBildschirm)
    {
        this.kenntBildschirm = kenntBildschirm;
        this.hatStift = new Buntstift();
        this.hatStift2 = new Buntstift();
        this.radierStift = new Buntstift();
        hatStift.bewegeBis(xpos,ypos);
        hatStift2.bewegeBis(xpos,ypos);
        this.ufoGroesse=ufoGroesse;
        this.geschwindigkeit=geschwindigkeit;
        this.startgeschwindigkeit=geschwindigkeit;
        this.hatStift.setzeFarbe(Farbe.rgb(0,225,195));
        this.hatStift.setzeFuellmuster(muster);
    }

    // Dienste
    public void bewege()
    {
        // Aktionsteil
        this.loesche();
        hatStift.bewegeUm(geschwindigkeit);
        hatStift2.bewegeUm(geschwindigkeit);
        this.geschwindigkeit+=startgeschwindigkeit/10000;
        this.zeichne();
    }
    
    public boolean amRand()
    {
        // Aktionsteil
        if(this.amLinkenRand() || this.amRechtenRand() || this.amOberenRand() || this.amUnterenRand()){
            return true;
        }else return false;
    }
    
    public void zeichne()
    {
        // Aktionsteil
        hatStift.zeichneKreis(ufoGroesse);
        hatStift.zeichneKreis(ufoGroesse-1);
        hatStift2.runter();
        hatStift2.bewegeUm(ufoGroesse);
        hatStift2.dreheUm(90);
        hatStift2.bewegeUm(1);
        hatStift2.dreheUm(90);
        hatStift2.bewegeUm(ufoGroesse);
        hatStift2.dreheUm(90);
        hatStift2.bewegeUm(2);
        hatStift2.dreheUm(90);
        hatStift2.bewegeUm(ufoGroesse);
        hatStift2.dreheUm(90);
        hatStift2.bewegeUm(1);
        hatStift2.dreheUm(-90);
        hatStift2.hoch();
        hatStift2.bewegeUm(-ufoGroesse);
    }
    
    public void loesche()
    {
        // Aktionsteil
        radierStift.radiere();
        radierStift.bewegeBis(this.xPos()-ufoGroesse-2,this.yPos()-ufoGroesse-2);
        radierStift.setzeFuellmuster(Muster.GEFUELLT);
        radierStift.zeichneRechteck(ufoGroesse*2+4,ufoGroesse*2+4);
        radierStift.setzeFuellmuster(muster);
        radierStift.normal();
    }
    
    public void dreheLinks()
    {
        // Aktionsteil
        hatStift.dreheUm(5);
        hatStift2.dreheUm(5);
    }
    
    public void dreheRechts()
    {
        // Aktionsteil
        hatStift.dreheUm(-5);
        hatStift2.dreheUm(-5);
    }
    
    public void setzeMuster(int muster)
    {
        //Aktionsteil
        this.muster=muster;
        hatStift.setzeFuellMuster(muster);
    }
    
    public void setzeFarbe(Color farbe)
    {
        //Aktionsteil
        hatStift.setzeFarbe(farbe);
    }
    
    public void setzeFarbe(int farbe)
    {
        //Aktionsteil
        hatStift.setzeFarbe(farbe);
    }
    
    public void setzeGeschwindigkeit(double geschwindigket)
    {
        this.geschwindigkeit=geschwindigkeit;
    }
    
    public double xPos()
    {
        return hatStift.hPosition();
    }
    
    public double yPos()
    {
        return hatStift.vPosition();
    }
       
    private boolean amLinkenRand()
    {
        return this.xPos() < ufoGroesse;
    }

    private boolean amRechtenRand()
    {
        return this.xPos() >(kenntBildschirm.breite() - ufoGroesse);
    }

    private boolean amOberenRand()
    {
        return this.yPos() < ufoGroesse;
    }

    private boolean amUnterenRand()
    {
        return this.yPos() >(kenntBildschirm.hoehe() - ufoGroesse);
    }
}