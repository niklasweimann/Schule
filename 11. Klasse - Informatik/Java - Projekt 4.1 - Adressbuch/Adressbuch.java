/**
 * Die Klasse Adressbuch wurde automatisch erstellt: 
 * 
 * @author Niklas Weimann
 * @version 3.9.2015
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class Adressbuch extends EBAnwendung
{
    // Objekte
    private Knopf hatKnopf1;
    private Knopf hatKnopf2;
    private Textfeld hatTextfeldVorname;
    private Textfeld hatTextfeldNachname;
    private Textfeld hatTextfeldGeburtsdatum;
    private Etikett hatEtikettDaten;
    private Etikett hatEtikettVorname;
    private Etikett hatEtikettNachname;
    private Etikett hatEtikettGeburtsdatum;
    private Knopf hatKnopfLoeschen;
    private Knopf hatKnopfSpeichern;
    private Fortschrittsbalken hatFortschrittsbalken1;
    private Etikett hatEtikettFortschritt;

    private Personen myPerson;
    private int ArrayPos = 0;
    // Attribute

    /**
     * Konstruktor
     */
    public Adressbuch()
    {
        //Initialisierung der Oberklasse
        super(500, 300);

        myPerson = new Personen();

        hatKnopf1 = new Knopf(144, 109, 46, 26, "<");
        hatKnopf1.setzeBearbeiterGeklickt("hatKnopf1Geklickt");
        hatKnopf2 = new Knopf(196, 108, 47, 27, ">");
        hatKnopf2.setzeBearbeiterGeklickt("hatKnopf2Geklickt");
        hatEtikettVorname = new Etikett(38, 60, 100, 25, "Vorname:");
        // Ausrichtung
        hatEtikettVorname.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettNachname = new Etikett(144, 60, 100, 25, "Nachname:");
        // Ausrichtung
        hatEtikettNachname.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettGeburtsdatum = new Etikett(250, 60, 100, 25, "Geburtsdatum:");
        // Ausrichtung
        hatEtikettGeburtsdatum.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldVorname = new Textfeld(38, 80, 100, 25, "");
        // Ausrichtung
        hatTextfeldVorname.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldNachname = new Textfeld(144, 80, 100, 25, "");
        // Ausrichtung
        hatTextfeldNachname.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldGeburtsdatum = new Textfeld(250, 80, 100, 25, "");
        // Ausrichtung
        hatTextfeldGeburtsdatum.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettDaten = new Etikett(144, 37, 100, 25, "Daten:");
        // Ausrichtung
        hatEtikettDaten.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfLoeschen = new Knopf(38, 109, 100, 25, "Loeschen");
        hatKnopfLoeschen.setzeBearbeiterGeklickt("hatKnopfLoeschenGeklickt");
        hatKnopfSpeichern = new Knopf(250, 112, 100, 25, "Speichern");
        hatKnopfSpeichern.setzeBearbeiterGeklickt("hatKnopfSpeichernGeklickt");
        hatFortschrittsbalken1 = new Fortschrittsbalken(38, 177, 314, 17, 0, myPerson.getArrayLength()-1);
        hatEtikettFortschritt = new Etikett(38, 145, 100, 25, "Fortschritt:");
        // Ausrichtung
        hatEtikettFortschritt.setzeAusrichtung(Ausrichtung.LINKS);

    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopf1 fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopf1Geklickt()
    {
        if(ArrayPos >0)
        {
            ArrayPos--;
            hatFortschrittsbalken1.setzeWert(hatFortschrittsbalken1.wert()-1);
        }
        hatTextfeldNachname.setzeInhalt(myPerson.read(ArrayPos,0));
        hatTextfeldVorname.setzeInhalt(myPerson.read(ArrayPos,1));
        hatTextfeldGeburtsdatum.setzeInhalt(myPerson.read(ArrayPos,2));
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopf2 fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopf2Geklickt()
    {
        if(ArrayPos < myPerson.getArrayLength()-1)
        {
            ArrayPos++;
            hatFortschrittsbalken1.setzeWert(hatFortschrittsbalken1.wert()+1);
        }
        hatTextfeldNachname.setzeInhalt(myPerson.read(ArrayPos,0));
        hatTextfeldVorname.setzeInhalt(myPerson.read(ArrayPos,1));
        hatTextfeldGeburtsdatum.setzeInhalt(myPerson.read(ArrayPos,2));
    }

    /**
     * Vorher: Ereigniis GeklicktvonhatKnopfLoeschen fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfLoeschenGeklickt()
    {
        myPerson.delete(ArrayPos);
        hatTextfeldNachname.setzeInhalt(myPerson.read(ArrayPos,0));
        hatTextfeldVorname.setzeInhalt(myPerson.read(ArrayPos,1));
        hatTextfeldGeburtsdatum.setzeInhalt(myPerson.read(ArrayPos,2));
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfSpeichern fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfSpeichernGeklickt()
    {
        myPerson.add(hatTextfeldNachname.inhaltAlsText(),hatTextfeldVorname.inhaltAlsText(),hatTextfeldGeburtsdatum.inhaltAlsText());
    }

}
