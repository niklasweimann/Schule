
import sum.kern.*;
/**
 * @author Herr Stierl
 * @version 1.0
 */
public class Hauptprogramm
{
    // Objekte
    Bildschirm derBildschirm;
    Ufo ufo1;
    Maus dieMaus;
    Tastatur dieTastatur;
    Buntstift stift1;
    int zaehler=0;
    int zaehler_old=0;
    int zaehler_max=0;
    boolean ende;
    int cheatl;
    int cheatr;
    // Konstruktor
    public Hauptprogramm()
    {
        derBildschirm = new Bildschirm(900,500);
        dieMaus= new Maus();
        dieTastatur = new Tastatur();
        stift1= new Buntstift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        ende=false;
        cheatl=0; cheatr=0;
        stift1.bewegeBis(derBildschirm.breite()/2-63,derBildschirm.hoehe()/2-25);
        derBildschirm.loescheAlles();
        stift1.setzeFarbe(Farbe.rgb(0, 147, 42));
        stift1.setzeSchriftstil(1);
        stift1.setzeSchriftgroesse(18);
        stift1.schreibeText("Mach dich bereit!");
        stift1.setzeSchriftgroesse(15);
        stift1.setzeFarbe(3);
        stift1.setzeSchriftstil(0);
        stift1.bewegeBis(derBildschirm.breite()/2-75,derBildschirm.hoehe()/2-10);
        stift1.schreibeText("Mit beliebiger Taste starten.");
        while(!dieTastatur.wurdeGedrueckt());
        derBildschirm.loescheAlles();
        //Als Erinnerung: Ufo(xpos, ypos, ufoGroesse, geschwindigkeit, Bildschirm)
        ufo1 = new Ufo(50,derBildschirm.hoehe()/2,20,0.1,derBildschirm); 
        while(!ufo1.amRand() && (cheatl<300 && cheatr<300))
        {
            if(dieTastatur.wurdeGedrueckt()){
                zaehler+=100;
                switch(dieTastatur.zeichen()){

                    case 'a':
                    cheatr=0;
                    ufo1.dreheLinks();
                    cheatl++;
                    break;
                    case 'd':
                    cheatl=0;
                    ufo1.dreheRechts();
                    cheatr++;
                    break;
                    case '1':
                    ufo1.setzeMuster(Muster.DURCHSICHTIG);
                    break;
                    case '2':
                    ufo1.setzeMuster(Muster.GEFUELLT);
                    break;
                    case '3':
                    ufo1.setzeFarbe(Farbe.rgb(0, 156, 44));
                    break;
                    case '4':
                    ufo1.setzeFarbe(Farbe.rgb(12, 34, 98));
                    break;
                    case '5':
                    ufo1.setzeFarbe(Farbe.rgb(129, 0, 18));
                    break;
                    case '6':
                    ufo1.setzeFarbe(Farbe.rgb(255, 145, 0));
                    break;
                    default:
                    zaehler-=100;
                }
                dieTastatur.weiter();
            }
            zaehler++;
            ufo1.bewege();
        }//TODO durch eigenen Code ersetzen.ufo1.setzeGeschwindigkeit(0);
        stift1.bewegeBis(derBildschirm.breite()/2-59,derBildschirm.hoehe()/2-25);
        stift1.setzeFarbe(Farbe.rgb(147, 0, 15));
        stift1.setzeSchriftstil(1);
        stift1.setzeSchriftgroesse(18);
        stift1.schreibeText("Game Over");
        stift1.setzeSchriftstil(0);
        stift1.setzeSchriftgroesse(15);
        stift1.bewegeBis(derBildschirm.breite()/2-150,derBildschirm.hoehe()/2-10);
        if(cheatl==300 || cheatr==300) {
            stift1.schreibeText("Du hast dich zu lange in die gleiche Richtung bewegt.");
            zaehler=0;
        }
        stift1.setzeFarbe(Farbe.rgb(47, 0, 127));
        stift1.bewegeBis(derBildschirm.breite()/2-60,derBildschirm.hoehe()/2+15);
        stift1.schreibeText("Last Points:"+zaehler_old/10);
        stift1.setzeSchriftgroesse(16);
        stift1.bewegeBis(derBildschirm.breite()/2-60,derBildschirm.hoehe()/2+35);
        stift1.setzeFarbe(Farbe.rgb(0, 93, 17));
        stift1.schreibeText("Your Points:"+zaehler/10);
        zaehler_max=(zaehler_max<zaehler) ? zaehler : zaehler_max;
        zaehler_old=zaehler;
        zaehler=0;
        stift1.bewegeBis(derBildschirm.breite()/2-60,derBildschirm.hoehe()/2+60);
        stift1.setzeSchriftstil(1);
        stift1.setzeFarbe(Farbe.rgb(203, 210, 0));
        stift1.setzeSchriftgroesse(17);
        stift1.schreibeText("Highscore:"+zaehler_max/10);
        stift1.setzeSchriftstil(0);
        stift1.setzeFarbe(3);
        stift1.setzeSchriftgroesse(15);
        stift1.bewegeBis(derBildschirm.breite()/2-150,derBildschirm.hoehe()/2+90);
        stift1.schreibeText("Erneut spielen mit 'Leertaste' / Beenden mit 'ESC'");
        while(ende!=true){
            if(dieTastatur.wurdeGedrueckt()==true){
                switch(dieTastatur.zeichen()){

                    case Zeichen.ESCAPE:
                    ende=true;
                    break;
                    case 'a':
                    break;
                    case 'd':
                    break;
                    case '1':
                    break;
                    case '2':
                    break;
                    case '3':
                    break;
                    case '4':
                    break;
                    case '5':
                    break;
                    case '6':
                    break;
                    default:
                    dieTastatur.weiter();
                    this.fuehreAus();
                    break;                                                                                                                 //Copyright Stierl
                }
                dieTastatur.weiter();
            }
        }
        dieMaus.gibFrei();
        dieTastatur.gibFrei();
        stift1.gibFrei();
        derBildschirm.gibFrei();
    }
}