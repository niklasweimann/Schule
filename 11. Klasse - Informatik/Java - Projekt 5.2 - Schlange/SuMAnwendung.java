/**
 * Die Klasse SuMAnwendung wurde automatisch erstellt: 
 * 
 * @author Niklas Weimann
 * @version 17.11.2015
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class SuMAnwendung extends EBAnwendung
{
    // Objekte
    private Etikett hatEtikettEingabe;
    private Etikett hatEtikettausgabe;
    private Textfeld hatTextfeld1;
    private Knopf hatKnopfHinzufuegen;
    private Knopf hatKnopfAusgabe;
    
    private Schlange mSchlange;
    private Stapel mStapel;

    // Attribute

    /**
     * Konstruktor
     */
    public SuMAnwendung()
    {
        //Initialisierung der Oberklasse
        super(700, 500);

        hatEtikettEingabe = new Etikett(114, 107, 100, 25, "Eingabe:");
        // Ausrichtung
        hatEtikettEingabe.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettausgabe = new Etikett(426, 106, 100, 25, "(Ausgabe)");
        // Ausrichtung
        hatEtikettausgabe.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeld1 = new Textfeld(224, 106, 191, 25, "");
        // Ausrichtung
        hatTextfeld1.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfHinzufuegen = new Knopf(109, 150, 100, 25, "Hinzufügen");
        hatKnopfHinzufuegen.setzeBearbeiterGeklickt("hatKnopfHinzufuegenGeklickt");
        hatKnopfAusgabe = new Knopf(428, 147, 100, 25, "Ausgabe");
        hatKnopfAusgabe.setzeBearbeiterGeklickt("hatKnopfAusgabeGeklickt");
        
        mSchlange = new Schlange();
        mStapel = new Stapel();
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfHinzufuegen fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfHinzufuegenGeklickt()
    {
        mSchlange.enqueue(hatTextfeld1.inhaltAlsText());
        System.out.println("Hinzu: " + hatTextfeld1.inhaltAlsText());
        hatTextfeld1.setzeInhalt("");
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfEntfernen fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfEntfernenGeklickt()
    {
        //mSchlange.entferneKopf();
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfEntfernen fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfAusgabeGeklickt()
    {
        hatEtikettausgabe.setzeInhalt("");
        while(mSchlange.size() != 0)
        {
            //String a = mSchlange.entferneKopf();
            String a = mSchlange.dequeue();
            System.out.println("String aus Schlange: " + a);
            if(a !=null)
            {
                mStapel.push(new Stapelelement(a));
                System.out.println("Stapelelement mit dem Wert hinzugefügt: " + a);
            }
        }
        while (!mStapel.isEmpty()) 
        { 
            String a = mStapel.getTop().getContent();
            System.out.println("String aus Stapel: " + a);
            mStapel.pop();
            hatEtikettausgabe.haengeAn(a);
            hatEtikettausgabe.haengeAn(",");
        }
    }
}
