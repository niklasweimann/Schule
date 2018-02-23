/**
 * Die Klasse SuMAnwendung wurde NICHT automatisch erstellt: 
 * 
 * @author Niklas Weimann
 * @version 0118 999 881 999 119 725 3
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;
import sum.multimedia.*;

public class SuMAnwendung extends EBAnwendung
{
    // Objekte
    private Etikett hatEtikett1;
    private Etikett hatEtikett2;
    private Etikett hatEtikett3;
    private Etikett hatEtikett4;
    private Etikett hatEtikett5;
    private Etikett hatEtikett6;
    private Etikett hatEtikett7;
    private Knopf hatKnopfGewinnen;
    private Rechner calc;
    private Buntstift meinBuntstift;
    private Bild backgroundImage;
    private Bild buttonImage;
    
    private double hatEtikettY = 150;
    private double hatEtikettX = 100;

    // Attribute

    /**
     * Konstruktor
     */
    public SuMAnwendung()
    {
        //Initialisierung der Oberklasse

        super(500, 300);

        calc = new Rechner();
        meinBuntstift = new Buntstift();

        hatEtikett1 = new Etikett(hatEtikettX, hatEtikettY, 100, 25, "-");
        hatEtikettX+=50;
        // Ausrichtung
        hatEtikett1.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikett2 = new Etikett(hatEtikettX, hatEtikettY, 100, 25, "-");
        hatEtikettX+=50;
        // Ausrichtung
        hatEtikett2.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikett3 = new Etikett(hatEtikettX, hatEtikettY, 100, 25, "-");
        hatEtikettX+=50;
        // Ausrichtung
        hatEtikett3.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikett4 = new Etikett(hatEtikettX, hatEtikettY, 100, 25, "-");
        hatEtikettX+=50;
        // Ausrichtung
        hatEtikett4.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikett5 = new Etikett(hatEtikettX, hatEtikettY, 100, 25, "-");
        hatEtikettX+=50;
        // Ausrichtung
        hatEtikett5.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikett6 = new Etikett(hatEtikettX, hatEtikettY, 100, 25, "-");
        hatEtikettX+=50;
        // Ausrichtung
        hatEtikett6.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikett7 = new Etikett(100, 125, 150, 25, "Ihre Zahlen zum Reichtum");
        //Ausrichtung
        hatEtikett7.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfGewinnen = new Knopf(100, 200, 150, 25, "Zahlen generieren");
        hatKnopfGewinnen.setzeBearbeiterGeklickt("hatKnopfGewinnenGeklickt");
        
        hatEtikettX=100;
    }
    
    /**
     * Vorher: Ereignis GeklicktvonhatKnopfGewinnen fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfGewinnenGeklickt()
    {
        int[] zahlen = new int[6];
        for(int i = 0; i < zahlen.length; i++)
        {
            for (int x = 1; x < zahlen.length; x++)
            {
                zahlen[i] = calc.ganzeZufallszahl(1, 49);
                if(this.testeDopplung(zahlen[i], zahlen[x]) == true)
                {
                    zahlen[i] = calc.ganzeZufallszahl(1,49);
                }
                System.out.println(zahlen[i]);
            }
        } 

        hatEtikett1.setzeInhalt(zahlen[0]);
        meinBuntstift.bewegeBis(hatEtikettX, hatEtikettY);
        hatEtikett2.setzeInhalt(zahlen[1]);
        hatEtikett3.setzeInhalt(zahlen[2]);
        hatEtikett4.setzeInhalt(zahlen[3]);
        hatEtikett5.setzeInhalt(zahlen[4]);
        hatEtikett6.setzeInhalt(zahlen[5]);

    }

    public boolean testeDopplung(int number1, int number2)
    {
        if(number1 == number2)
        {
            return(true);
        }
        else
        {
            return(false);
        }
    }
}
