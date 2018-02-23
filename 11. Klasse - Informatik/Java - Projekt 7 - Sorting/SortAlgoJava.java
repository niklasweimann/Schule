/**
 * Die Klasse SortAlgoJava wurde automatisch erstellt: 
 * 
 * @author 
 * @version 3.3.2016
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;
import java.text.*;
import java.util.*;
import javax.swing.JOptionPane;

public class SortAlgoJava extends EBAnwendung
{
    // Objekte
    private Knopf hatKnopfSortieren;
    private Etikett hatEtikettInput;
    private Textfeld inputTextfeld;
    private Auswahl hatAuswahl1;
    private Etikett hatEtikettAlgorithmus;
    private Etikett hatEtikettSchritte;
    public Zeichenbereich hatTextfeld2;
    private Etikett hatEtikettAuswertung;
    private Etikett hatEtikettAnzahlDerElemente;
    private Etikett hatEtikettVertauschungen;
    private Etikett hatEtikettPruefungen;
    private Knopf hatKnopfRandom;
    private Rechner mRechner;

    //Algorithmen
    SelectionSort mSelectionSort = new SelectionSort();
    InsertationSort mInsertationSort = new InsertationSort();
    BubbleSort mBubbleSort = new BubbleSort();
    MergeSort mMergeSort = new MergeSort();
    QuickSort mQuickSort = new QuickSort();

    // Attribute
    int testedValue = 0;
    int changedValues = 0;
    int delay = 0;
    /**
     * Konstruktor
     */
    public SortAlgoJava()
    {
        //Initialisierung der Oberklasse
        super(1039, 591);

        hatKnopfSortieren = new Knopf(42, 179, 100, 25, "Sortieren");
        hatKnopfSortieren.setzeBearbeiterGeklickt("hatKnopfSortierenGeklickt");
        hatEtikettInput = new Etikett(41, 45, 100, 25, "Input:");
        // Ausrichtung
        hatEtikettInput.setzeAusrichtung(Ausrichtung.LINKS);
        inputTextfeld = new Textfeld(41, 81, 100, 25, "");
        // Ausrichtung
        inputTextfeld.setzeAusrichtung(Ausrichtung.LINKS);
        hatAuswahl1 = new Auswahl(41, 142, 100, 25);
        hatAuswahl1.setzeBearbeiterGeaendert("hatAuswahl1Geaendert");
        hatEtikettAlgorithmus = new Etikett(42, 111, 100, 25, "Algorithmus");
        // Ausrichtung
        hatEtikettAlgorithmus.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettSchritte = new Etikett(221, 44, 100, 25, "Schritte");
        // Ausrichtung
        hatEtikettSchritte.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeld2 = new Zeichenbereich(223, 81, 624, 396, "");
        // Ausrichtung
        //hatTextfeld2.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettAuswertung = new Etikett(42, 263, 137, 26, "Auswertung:");
        // Ausrichtung
        hatEtikettAuswertung.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettAnzahlDerElemente = new Etikett(42, 296, 139, 25, "Anzahl der Elemente");
        // Ausrichtung
        hatEtikettAnzahlDerElemente.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettVertauschungen = new Etikett(42, 326, 139, 25, "Vertauschungen");
        // Ausrichtung
        hatEtikettVertauschungen.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettPruefungen = new Etikett(42, 357, 139, 25, "Pruefungen");
        // Ausrichtung
        hatEtikettPruefungen.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfRandom = new Knopf(145, 80, 74, 27, "Random");
        hatKnopfRandom.setzeBearbeiterGeklickt("hatKnopfRandomGeklickt");

        mRechner = new Rechner();

        hatAuswahl1.haengeAn("Selection - Sort.");
        hatAuswahl1.haengeAn("Insertation - Sort.");
        hatAuswahl1.haengeAn("Bubble - Sort.");
        hatAuswahl1.haengeAn("Merge - Sort.");
        hatAuswahl1.haengeAn("Quick - Sort.");

    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfSortieren fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfSortierenGeklickt()
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        int arrayLaenge = 0;

        //Richtextbox leeren
        hatTextfeld2.loescheAlles();

        String text = inputTextfeld.inhaltAlsText(); //Text aus der Textbox
        String[] words;
        if(text.contains(" "))
        {
            words = text.split(" ");
        }
        else if(text.contains(";"))
        {
            words = text.split(";");
        }
        else
        {
            throw new IllegalArgumentException("Input " + text + " enthält kein Space oder ; Zeichen");
        }

        //Array mit gesplitteten Strings wird erstellt
        int[] input = new int[words.length];
        for(int i = 0; i < words.length; i++)
        {
            input[i] = Integer.parseInt(words[i]);
        }

        arrayLaenge = input.length;
        hatEtikettAnzahlDerElemente.setzeInhalt("Anzahl der Elemente: " + arrayLaenge);

        //Algorithmus auswählen
        if (hatAuswahl1.index()== 1)
        {
            mSelectionSort.sort(input, arrayLaenge -1, this);
        }
        else if (hatAuswahl1.index()== 2)
        {
            mInsertationSort.sort(input, arrayLaenge -1, this);
        }
        else if (hatAuswahl1.index()== 3)
        {
            mBubbleSort.sort(input, arrayLaenge - 1, this);
        }
        else if (hatAuswahl1.index()== 4)
        {
            mMergeSort.sort(input,0, arrayLaenge-1, this);
        }
        else if(hatAuswahl1.index()== 5)
        {
            mQuickSort.sort(input, 0, arrayLaenge - 1, this);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Bitte wählen Sie einen gültigen Algorithmus!",
                "Algorithmus nicht gefunden", JOptionPane.INFORMATION_MESSAGE);
        }

        hatEtikettVertauschungen.setzeInhalt("Vertauschungen: " + changedValues);
        hatEtikettPruefungen.setzeInhalt("Prüfungen: " + testedValue);

        changedValues = 0;    
        testedValue = 0;
    }

    /**
     * Vorher: Ereignis GeaendertvonhatAuswahl1 fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatAuswahl1Geaendert()
    {
        //    Schreiben Sie hier den Text ihres Dienstes
    }

    /**
     * Vorher: Ereignis GeklicktvonhatKnopfRandom fand statt.
     * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
     */
    public void hatKnopfRandomGeklickt()
    {
        inputTextfeld.haengeAn(mRechner.ganzeZufallsZahl(1, 100));
        inputTextfeld.haengeAn(" ");
    }

}
