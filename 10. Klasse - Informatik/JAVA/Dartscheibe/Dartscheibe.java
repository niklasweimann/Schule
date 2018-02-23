
import sum.kern.*;
import sum.werkzeuge.Uhr;
/**
 * @author Niklas Weimann
 * @version 24.9.14
 */
public class Dartscheibe
{
    // Objekte
    Bildschirm derBildschirm;
    Stift mS;
    Stift mS2;
    Maus dieMaus;
    Uhr dieUhr;
    Buntstift mbS;
    Stift mS3;

    // Konstruktor
    public Dartscheibe()
    {
        derBildschirm = new Bildschirm(800, 500);
        mS            = new Stift();
        mS2           = new Stift();
        mS3           = new Stift();
        mbS           = new Buntstift();
        dieMaus       = new Maus();
        dieUhr        = new Uhr();
    }
    // Dienste
    public void fuehreAus() 
    {
        int player1 = 0;    //Variablen für den Score der Nutzer
        int player2 = 0;
        int nochmal = 0;
            for(int aktuellerspieler = 1; aktuellerspieler <=2; aktuellerspieler++) //for-Schleife damit 2 Spieler möglich sind
            {
            for(int versuch = 1; versuch <=3; versuch++) //for-Schleife damit jeder 3 mal schießen kann
            {
                int noch = 4-versuch;   //anzeigen der restlichen Versuche
                mS2.schreibeText(" Du hast noch "+noch+".");
                this.pfeilSteuerung();  //startet die "pfeilsteuerung" (drehen und fliegen des Pfeils)
                mS2.bewegeBis(10, 20);
                if (mS.hPosition() >=600 ) //Wenn erfüllt, wird mit der Berechnung des Scores gestartet
                {
                if (mS.vPosition() >= 80 && mS.vPosition() <= 120)//Mitte
                {
                    mS2.schreibeText("100");    //schreibt die Punktzahl
                    mS.bewegeUm(-100);
                    this.pfeilZeichnen();       //zeichnet den Pfeil, damit es so aussieht, als ob er in der Scheibe stecken geblieben ist
                    mS.hoch();
                    if(aktuellerspieler == 1)   //verteilt die Punkte an die Spieler
                    {
                        player1= player1+100;
                    }
                    else
                    {
                        player2= player2+100;
                    }
                }
                else if ((mS.vPosition()>=20 && mS.vPosition() <= 40) | (mS.vPosition() >=160 && mS.vPosition() <= 180))
                {
                    mS2.schreibeText("25");
                    mS.bewegeUm(-100);
                    this.pfeilZeichnen();
                    mS.hoch();
                    if(aktuellerspieler == 1)
                    {
                        player1=player1+25;
                    }
                    else
                    {
                        player2=player2+25;
                    }
                }
                else if ((mS.vPosition()>=40 && mS.vPosition() <= 60) | (mS.vPosition() >=140 && mS.vPosition() <= 160))
                {
                    mS2.schreibeText("50");
                    mS.bewegeUm(-100);
                    this.pfeilZeichnen();
                    mS.hoch();
                    if(aktuellerspieler == 1)
                    {
                        player1=player1+50;
                    }
                    else
                    {
                        player2=player2+50;
                    }
                }
                else if ((mS.vPosition() >=60  && mS.vPosition() <=80) | (mS.vPosition() >=120 && mS.vPosition() <= 140))
                {
                    mS2.schreibeText("75");
                    mS.bewegeUm(-100);
                    this.pfeilZeichnen();
                    mS.hoch();
                    if(aktuellerspieler == 1)
                    {
                        player1=player1+75;
                    }
                    else
                    {
                        player2=player2+75;
                    }
                }
                else 
                {
                    mS2.schreibeText("Daneben");
                    mS.bewegeUm(-100);
                    this.pfeilZeichnen();
                    mS.hoch();
                    if(aktuellerspieler == 1)
                    {
                        player1=player1+0;
                    }
                    else
                    {
                        player2=player2+0;
                    }
                }
                }
            }
            derBildschirm.loescheAlles();
        }
        mS3.bewegeBis(100, 100);    //Zeigt nach den 6 Schüssen den Endstand an
        mS3.schreibeText("Spieler 1 hat " +player1+" Punkte.");
        mS3.bewegeBis(100, 120);
        mS3.schreibeText("Spieler 2 hat " +player2+" Punkte.");
    
    
        //Aufräumen
        mS.gibFrei();
        derBildschirm.gibFrei();
        dieMaus.gibFrei();
        mS2.gibFrei();
        dieUhr.gibFrei();
    }
    public void pfeilSteuerung()
    {
        // Aktionsteil
        int abschuss = 0;   //damit man während des Pfluges nicht die Maustatste gedrückt halten muss
        mS2.bewegeBis(600, 100);
        for(int i = 0; i < 100; i= i + 20 ) //Zeichne Zielscheibe
        {
          mS2.zeichneKreis(i);
        }
        mS.bewegeBis(100, 400);  //Gehe zu Pfeilstartposition
        mS.runter();
        while(dieMaus.istGedrueckt() == false)  //lasse Pfeil drehen
        {
           mS.dreheUm(1);
           this.pfeilZeichnen();
           dieUhr.warte(5);
           this.pfeilRadieren();
           for(int i = 0; i < 100; i= i + 20 )     //zeichnet die Dartscheibe
           {
              mS2.zeichneKreis(i);
           }
            }
        if (dieMaus.istGedrueckt() == true)     //registriert den Tastendruck
        {
           abschuss++;
        }
        while (abschuss == 1 & mS.hPosition() <=600 & !(mS.hPosition() <=0))        //läst den Pfeil fliegen //+100, damit pfeilspitze stecken bleibt
        {
           mS.normal();
           mS.runter();
           mS.bewegeUm(-100);
           mS.bewegeUm(100);
           mS.dreheUm(120);
           mS.bewegeUm(25);
           mS.bewegeUm(-25);
           mS.dreheUm(120);
           mS.bewegeUm(25);
           mS.bewegeUm(-25);
           dieUhr.warte(2);
           mS.radiere();   //radiert den Pfeil
           mS.bewegeUm(25);
           mS.bewegeUm(-25);
           mS.dreheUm(-120);
           mS.bewegeUm(25);
           mS.bewegeUm(-25);
           mS.dreheUm(-120);
           mS.bewegeUm(-100);
           mS.bewegeUm(100);
           mS.bewegeUm(1);  //sorgt für die Drehung
           for(int i = 0; i < 100; i= i + 20 )     //zeichnet die Dartscheibe
           {
              mS2.zeichneKreis(i);
           }
        }
        mS2.bewegeBis(20, 100);
        
        mS2.hoch();
        mS2.bewegeBis(100, 100);
        mS2.bewegeBis(10, 10);
        mbS.bewegeBis(0, 0);
        mbS.setzeFarbe(11);
        mbS.setzeFuellmuster(1);
        mbS.zeichneRechteck(300, 40);
    }
    public void pfeilZeichnen() //Zeichnet den Pfeil
    {
        mS.normal();
        mS.runter();
        mS.bewegeUm(100);
        mS.dreheUm(120);
        mS.bewegeUm(25);
        mS.bewegeUm(-25);
        mS.dreheUm(120);
        mS.bewegeUm(25);
        mS.bewegeUm(-25);
    }
    public void pfeilRadieren() //radiert den Pfeil
    {
        mS.radiere();   
        mS.bewegeUm(25);
        mS.bewegeUm(-25);
        mS.dreheUm(-120);
        mS.bewegeUm(25);
        mS.bewegeUm(-25);
        mS.dreheUm(-120);
        mS.bewegeUm(-100);
    }
}