/**
 * Die Klasse SuMAnwendung wurde automatisch erstellt: 
 * 
 * @author 
 * @version 20.10.2015
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class SuMAnwendung extends EBAnwendung
{
    // Objekte
    private Etikett hatEtikettNeuerPatient;
    private Etikett hatEtikettName;
    private Etikett hatEtikettNachname;
    private Etikett hatEtikettKrankenkasse;
    private Textfeld hatTextfeldName;
    private Textfeld hatTextfeldNachname;
    private Textfeld hatTextfeldKrankenkasse;
    private Knopf hatKnopfEintragen;
    private Etikett Aktueller;
    private Etikett hatEtikettAktuellerpatient;
    private Knopf hatKnopfPatientFertig;
    
    private Warteraum mWarteraum;
    // Attribute

    /**
     * Konstruktor
     */
    public SuMAnwendung()
    {
        //Initialisierung der Oberklasse
        super(1000, 500);

        hatEtikettNeuerPatient = new Etikett(85, 92, 100, 25, "Neuer Patient:");
        // Ausrichtung
        hatEtikettNeuerPatient.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettName = new Etikett(189, 119, 100, 25, "Name:");
        // Ausrichtung
        hatEtikettName.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettNachname = new Etikett(188, 151, 100, 25, "Nachname:");
        // Ausrichtung
        hatEtikettNachname.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettKrankenkasse = new Etikett(188, 181, 100, 25, "Krankenkasse:");
        // Ausrichtung
        hatEtikettKrankenkasse.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldName = new Textfeld(297, 119, 100, 25, "");
        // Ausrichtung
        hatTextfeldName.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldNachname = new Textfeld(298, 154, 100, 25, "");
        // Ausrichtung
        hatTextfeldNachname.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldKrankenkasse = new Textfeld(297, 187, 100, 25, "");
        // Ausrichtung
        hatTextfeldKrankenkasse.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfEintragen = new Knopf(185, 223, 212, 32, "Eintragen");
        hatKnopfEintragen.setzeBearbeiterGeklickt("hatKnopfEintragenGeklickt");
        Aktueller = new Etikett(459, 103, 100, 25, "Aktueller Patient");
        // Ausrichtung
        Aktueller.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettAktuellerpatient = new Etikett(567, 136, 334, 27, "Aktueller Patient");
        // Ausrichtung
        hatEtikettAktuellerpatient.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfPatientFertig = new Knopf(565, 170, 337, 34, "Patient Fertig");
        hatKnopfPatientFertig.setzeBearbeiterGeklickt("hatKnopfPatientFertigGeklickt");

        mWarteraum = new Warteraum();
    }

    public void hatKnopfEintragenGeklickt()
    {
        String lName = hatTextfeldName.inhaltAlsText();
        String lNachname = hatTextfeldNachname.inhaltAlsText();
        String lKrankenkasse = hatTextfeldKrankenkasse.inhaltAlsText();
        Patient lPatient = new Patient(lName, lNachname, lKrankenkasse);
        mWarteraum.neuerPatient(lPatient);
        this.zeigeWarteraum();
    }

    public void hatKnopfPatientFertigGeklickt()
    {
        mWarteraum.entferneErstenPatient();
        this.zeigeWarteraum();
    }
    
    public void zeigeWarteraum()
    {
        Patient lPatient;
        lPatient = mWarteraum.kenntErsterPatient();
        if(lPatient == null)
        {
            hatEtikettAktuellerpatient.setzeInhalt("Warteraum ist leer");
        }
        else
        {
            hatEtikettAktuellerpatient.setzeInhalt("Warteraum: " + 
            lPatient.getName() + " " +
            lPatient.getNachname() + " " +
            lPatient.getKrankenkasse());
        }
    }

}
