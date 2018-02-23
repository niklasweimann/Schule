/**
 * Die Klasse SuMAnwendung wurde automatisch erstellt: 
 * 
 * @author Niklas Weimann
 * @version 30.11.2015
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class SuMAnwendung extends EBAnwendung
{
    // Objekte GUI
    private Tabelle hatTabelleEmails;
    private Etikett hatEtikettAlleMails;
    private Etikett hatEtikettName;
    private Etikett hatEtikettAbsender;
    private Etikett hatEtikett5;
    private Etikett hatEtikett6;
    private Etikett hatEtikettInhalt;
    private Textfeld hatTextfeldAbsender;
    private Textfeld hatTextfeldEmpfaenger;
    private Textfeld hatTextfeldBetreff;
    private Textfeld hatTextfeldInhalt;
    private Knopf hatKnopfzur;
    private Knopf hatKnopfvor;
    private Knopf hatKnopfLoeschen;
    private Knopf hatKnopfSpeichern;
    private Knopf demo;
    // Objekte Programm
    private Uhr mUhr;
    private List mList;
    private Textwerkzeug mTextwerkzeug;

    // Attribute
    Listenelement textboxLelement;
    /**
     * Konstruktor
     */
    public SuMAnwendung()
    {
        //Initialisierung der Oberklasse
        super(1059, 700);

        hatTabelleEmails = new Tabelle(72, 127, 300, 150, 0, 3);
        hatEtikettAlleMails = new Etikett(72, 98, 100, 25, "Emails im Posteingang:");
        // Ausrichtung
        hatEtikettAlleMails.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettName = new Etikett(427, 92, 492, 25, "Aktuelle Email:");
        // Ausrichtung
        hatEtikettName.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettAbsender = new Etikett(427, 126, 100, 25, "Absender");
        // Ausrichtung
        hatEtikettAbsender.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikett5 = new Etikett(427, 160, 100, 25, "Empfänger");
        // Ausrichtung
        hatEtikett5.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikett6 = new Etikett(427, 195, 100, 25, "Betreff");
        // Ausrichtung
        hatEtikett6.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettInhalt = new Etikett(427, 230, 100, 25, "Inhalt");
        // Ausrichtung
        hatEtikettInhalt.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldAbsender = new Textfeld(555, 126, 364, 25, "");
        // Ausrichtung
        hatTextfeldAbsender.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldEmpfaenger = new Textfeld(555, 160, 363, 25, "");
        // Ausrichtung
        hatTextfeldEmpfaenger.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldBetreff = new Textfeld(555, 195, 361, 25, "");
        // Ausrichtung
        hatTextfeldBetreff.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldInhalt = new Textfeld(556, 231, 361, 25, "");
        // Ausrichtung
        hatTextfeldInhalt.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfzur = new Knopf(115, 284, 100, 25, "<");
        hatKnopfzur.setzeBearbeiterGeklickt("hatKnopfzurGeklickt");

        hatKnopfvor = new Knopf(252, 284, 100, 25, ">");
        hatKnopfvor.setzeBearbeiterGeklickt("hatKnopfvorGeklickt");

        hatKnopfLoeschen = new Knopf(555, 284, 100, 25, "Loeschen");
        hatKnopfLoeschen.setzeBearbeiterGeklickt("hatKnopfLoeschenGeklickt");

        hatKnopfSpeichern = new Knopf(651, 284, 100, 25, "Speichern");
        hatKnopfSpeichern.setzeBearbeiterGeklickt("hatKnopfSpeichernGeklickt");

        demo = new Knopf(555, 320, 100, 25, "Demo");
        demo.setzeBearbeiterGeklickt("hatKnopfdemoGeklickt");

        mUhr = new Uhr();
        mList = new List();
        mTextwerkzeug = new Textwerkzeug();

        //Tabelle anpassen
        hatTabelleEmails.setzeSpaltentitelAn("Absender",1);
        hatTabelleEmails.setzeSpaltentitelAn("Betreff",2);
        hatTabelleEmails.setzeSpaltentitelAn("Datum",3);
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfzur fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfzurGeklickt()
    {
        hatTabelleEmails.markiereNichts();
        mList.previous();
        if(mList.getPos() >= 1)
        {
            hatTabelleEmails.setzeMarkierteZelle(mList.getPos(), 1);
            hatTabelleEmails.setzeMarkierteZelle(mList.getPos(), 2);
            hatTabelleEmails.setzeMarkierteZelle(mList.getPos(), 3);
        }
        else
        {
            hatTabelleEmails.setzeMarkierteZelle(1, 1);
            hatTabelleEmails.setzeMarkierteZelle(1, 2);
            hatTabelleEmails.setzeMarkierteZelle(1, 3);
        }
        //Textboxen anpassen
        if(mList.getItem() != null)
        {
            textboxLelement = mList.getItem();
            hatTextfeldAbsender.setzeInhalt(textboxLelement.getInhalt().getAbsender());
            hatTextfeldEmpfaenger.setzeInhalt(textboxLelement.getInhalt().getEmpfaenger());
            hatTextfeldBetreff.setzeInhalt(textboxLelement.getInhalt().getBetreff());
            hatTextfeldInhalt.setzeInhalt(textboxLelement.getInhalt().getInhalt());
        }
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfvor fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfvorGeklickt()
    {
        hatTabelleEmails.markiereNichts();
        mList.next();
        if(mList.getPos() <= mList.getSize())
        {
            hatTabelleEmails.setzeMarkierteZelle(mList.getPos(), 1);
            hatTabelleEmails.setzeMarkierteZelle(mList.getPos(), 2);
            hatTabelleEmails.setzeMarkierteZelle(mList.getPos(), 3);
        }
        else
        {
            hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 1);
            hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 2);
            hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 3);
        }
        //Textboxen anpassen
        if(mList.getItem() != null)
        {
            textboxLelement = mList.getItem();
            hatTextfeldAbsender.setzeInhalt(textboxLelement.getInhalt().getAbsender());
            hatTextfeldEmpfaenger.setzeInhalt(textboxLelement.getInhalt().getEmpfaenger());
            hatTextfeldBetreff.setzeInhalt(textboxLelement.getInhalt().getBetreff());
            hatTextfeldInhalt.setzeInhalt(textboxLelement.getInhalt().getInhalt());
        }
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfvor fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfLoeschenGeklickt()
    {
        System.out.println("Vor dem loeschen: " + mList.getItem());
        mList.delete();
        if(hatTabelleEmails.zeilenanzahl() >= 1)
        {
            //Tabelle anpassen
            hatTabelleEmails.entferneZeileAn(hatTabelleEmails.zeilenanzahl()-1);
            if(hatTabelleEmails.zeilenanzahl() > 1)
            {
                hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 1);
                hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 2);
                hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 3);
            }
        }
        else
        {
            //Tabelle anpassen
            hatTabelleEmails.markiereNichts();
        }
        if(mList.getItem() != null || hatTabelleEmails.zeilenanzahl() > 1)
        {
            //Textboxen anpassen
            hatTextfeldAbsender.setzeInhalt(mList.getItem().getInhalt().getAbsender());
            hatTextfeldEmpfaenger.setzeInhalt(mList.getItem().getInhalt().getEmpfaenger());
            hatTextfeldBetreff.setzeInhalt(mList.getItem().getInhalt().getBetreff());
            hatTextfeldInhalt.setzeInhalt(mList.getItem().getInhalt().getInhalt());

        }
        else
        {
            //Textboxen anpassen
            hatTextfeldAbsender.setzeInhalt("");
            hatTextfeldEmpfaenger.setzeInhalt("");
            hatTextfeldBetreff.setzeInhalt("");
            hatTextfeldInhalt.setzeInhalt("");
        }
        System.out.println("Nach dem loeschen: "+ mList.getItem());
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfvor fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfSpeichernGeklickt()
    {
        mList.insertBehind(new EMail(
                hatTextfeldAbsender.inhaltAlsText(),
                hatTextfeldEmpfaenger.inhaltAlsText(),
                hatTextfeldBetreff.inhaltAlsText(),
                mUhr.datum(),
                hatTextfeldInhalt.inhaltAlsText()
            ));

        //Daten in die Tabelle eintragen
        hatTabelleEmails.haengeNeueZeileAn();
        hatTabelleEmails.setzeInhaltAn(mList.getItem().getInhalt().getAbsender(),hatTabelleEmails.zeilenanzahl(),1);
        hatTabelleEmails.setzeInhaltAn(mList.getItem().getInhalt().getBetreff(),hatTabelleEmails.zeilenanzahl(),2);
        hatTabelleEmails.setzeInhaltAn(mList.getItem().getInhalt().getDatum(),hatTabelleEmails.zeilenanzahl(),3);
        //Makierung in der Tabelle ändern
        hatTabelleEmails.markiereNichts();
        hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 1);
        hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 2);
        hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 3);

        //Debugging Infos
        System.out.println("### Neues Element ###");
        System.out.println("Listenelement: " + mList.getItem());
        System.out.println("Absender: " + mList.getItem().getInhalt().getAbsender());
        System.out.println("Empfaenger: " + mList.getItem().getInhalt().getEmpfaenger());
        System.out.println("Betreff: "  + mList.getItem().getInhalt().getBetreff());
        System.out.println("Datum: " + mList.getItem().getInhalt().getDatum());
        System.out.println("Inhalt: " + mList.getItem().getInhalt().getInhalt());
        System.out.println("### Ende neues Element ###");
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfvor fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfdemoGeklickt()
    {
        for(int i = 0; i <= 5; i++)
        {
            mList.insertBehind(new EMail(
                    mTextwerkzeug.alsText(i),
                    mTextwerkzeug.alsText(i),
                    mTextwerkzeug.alsText(i),
                    mUhr.datum(),
                    mTextwerkzeug.alsText(i)
                ));
            //Daten in die Tabelle eintragen
            hatTabelleEmails.haengeNeueZeileAn();
            hatTabelleEmails.setzeInhaltAn(mList.getItem().getInhalt().getAbsender(),hatTabelleEmails.zeilenanzahl(),1);
            hatTabelleEmails.setzeInhaltAn(mList.getItem().getInhalt().getBetreff(),hatTabelleEmails.zeilenanzahl(),2);
            hatTabelleEmails.setzeInhaltAn(mList.getItem().getInhalt().getDatum(),hatTabelleEmails.zeilenanzahl(),3);
            //Makierung in der Tabelle ändern
            hatTabelleEmails.markiereNichts();
            hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 1);
            hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 2);
            hatTabelleEmails.setzeMarkierteZelle(hatTabelleEmails.zeilenanzahl(), 3);
            //Debugging Infos
            System.out.println("### Neues Element ###");
            System.out.println("Listenelement: " + mList.getItem());
            System.out.println("Absender: " + mList.getItem().getInhalt().getAbsender());
            System.out.println("Empfaenger: " + mList.getItem().getInhalt().getEmpfaenger());
            System.out.println("Betreff: "  + mList.getItem().getInhalt().getBetreff());
            System.out.println("Datum: " + mList.getItem().getInhalt().getDatum());
            System.out.println("Inhalt: " + mList.getItem().getInhalt().getInhalt());
            System.out.println("### Ende neues Element ###");
        }
    }

}
