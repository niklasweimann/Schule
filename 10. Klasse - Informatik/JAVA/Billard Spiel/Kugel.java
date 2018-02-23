import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author Niklas Weimann
 * @version 1.0.1
 */
public class Kugel
{
    //Bezugsobjekte
    private Buntstift hatStift;
    private Bildschirm kenntBildschirm;
    // Objekte
    Uhr meineUhr;
    Rechner meinRechner;
    //Attribute
    private int radius = 10;
    private double geschwindigkeit;
    private double richtung;

    // Konstruktor
    public Kugel(double pH, double pV, int pGroesse, double pGeschwindigkeit, double pRichtung, int farbe,Bildschirm pBildschirm)
    {
        meineUhr = new Uhr();
        meinRechner =new Rechner();
        kenntBildschirm = pBildschirm;
        //Kugel
        hatStift = new Buntstift();
        hatStift.bewegeBis(pH, pV);
        hatStift.setzeFuellmuster(1);
        hatStift.setzeFarbe(farbe);
        this.setzeRichtung(pRichtung);
        geschwindigkeit = pGeschwindigkeit;
        radius = pGroesse;

    }
    //Dienste
    /**
     * Zeichnet die Kugel.
     * 
     */
    public void zeichne()
    {
        hatStift.zeichneKreis(radius);
    }

    /**
     * Löscht die Kugel.
     * 
     */
    public void loesche()
    {
        hatStift.radiere();
        hatStift.zeichneKreis(radius);
        hatStift.normal();
    }

    /**
     * Setzt die Richtung, in die sich die Kugel bewegen soll.
     * 
     * @param  pRichtung    Wert für die Richtung
     */
    public void setzeRichtung(double pRichtung)
    {
        richtung = pRichtung;
        hatStift.dreheBis(richtung);
    }

    /**
     * Gibt die Richtung zurück.
     * 
     * @return      (Beschreibung des Rückgabewertes)
     */
    public double richtung()
    {
        return richtung;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  size    beinhaltet den Radius der Kugel
     */
    public void setzeGroesse(int size)
    {
        int radius = size;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  speed    beinhaltet die Geschwindigkeit der Kugel
     */
    public void setzeGeschwindigkeit(int speed)
    {
        geschwindigkeit = speed;
    }

    /**
     * Gibt die die Größe der Kugel zurück(Radius).
     * 
     * @return      gibt die Größe der Kugel zurück
     */
    public double groesse()
    {
        return radius;
    }

    /**
     * Gibt die aktuelle vertikale Position zurück.
     * 
     * @param  a    ist die Anzahl an schritten, die die Kugel sich bewegen soll
     * @return      gibt nichts zurück
     */
    public void bewege(int a)
    {
        int b = 1;
        int schritte = 0;
        if (a <=0)
        {
            schritte  = -a;
            b = -1;
        }
        for (int i = 0; i <= schritte; i++){
            this.loesche();
            hatStift.bewegeUm(b);
            this.zeichne();
            meineUhr.warte(5);
        }
    }

    /**
     * Gibt die aktuelle horizontale Position zurück.
     * 
     * @return      gibt die aktuelle Position auf der X-Ache zurück
     */
    public double hPosition()
    {
        return hatStift.hPosition();
    }

    /**
     * Gibt die aktuelle vertikale Position zurück.
     * 
     * @return      gibt die aktuelle Position auf der Y-Ache zurück
     */
    public double vPosition()
    {
        return hatStift.vPosition();
    }

    /**
     * Gibt die Geschwindkeit zurück, mit der sich die Kugel aktuell bewegt
     * 
     * @return      gibt die Geschwindigkeit der Kugel zurück
     */
    public double geschwindigkeit()
    {
        return geschwindigkeit;
    }

    /**
     * Gibt die Klasse frei.
     * 
     */
    public void gibFrei()
    {
        hatStift.gibFrei();
        meineUhr.gibFrei();
    }

    /**
     * Überprüft, ob eine Kollision mit einer anderen Kugel statt findet.
     * 
     * @return      gibt true zurück, wenn eine Kollision vorliegt
     */
    public boolean kollisionKugel(double kugel1x, double kugel2x, double kugel1y, double kugel2y)
    {
        double abstand = meinRechner.wurzel(meinRechner.quadrat(kugel1x-kugel2x)+meinRechner.quadrat(kugel1y-kugel2y));
        if (abstand < radius + radius)
        {
            return(true);
        }
        return(false);
    }

    /**
     * Überprüft, ob eine Kollision mit dem linken Rand statt findet.
     * 
     * @return      gibt true zurück, wenn eine Kollision vorliegt
     */
    public boolean amLinkenRand()
    {
        if (this.hPosition() <= 0 + radius)
        {
            return(true);
        }
        return(false);
    }

    /**
     * Überprüft, ob eine Kollision mit dem rechten Rand statt findet.
     * 
     * @return      gibt true zurück, wenn eine Kollision vorliegt
     */
    public boolean amRechtenRand()
    {
        if (this.hPosition() >= kenntBildschirm.breite() + radius)
        {
            return(true);
        }
        return(false);
    }

    /**
     * Überprüft, ob eine Kollision mit dem oberen Rand statt findet.
     * 
     * @return      gibt true zurück, wenn eine Kollision vorliegt
     */
    public boolean amOberenRand()
    {
        if (this.vPosition() <= 0 + radius)
        {
            return(true);
        }
        return(false);
    }

    /**
     * Überprüft, ob eine Kollision mit dem unteren Rand statt findet.
     * 
     * @return      gibt true zurück, wenn eine Kollision vorliegt
     */
    public boolean amUnterenRand()
    {
        if (this.vPosition() >= kenntBildschirm.hoehe() +radius)
        {
            return(true);
        }
        return(false);
    }

    /**
     * Überprüft, ob eine Kollision mit dem Rand statt findet.
     * 
     * @return      gibt nichts zurück
     */
    public boolean kollisionMitRand()
    {
        if(this.amLinkenRand() == true || this.amRechtenRand()== true){
            return true;
        }
        else if (this.amOberenRand() || this.amUnterenRand()){
            return true;
        }
        else{
            return false;
        }
    }
}