
import sum.kern.*;
import sum.werkzeuge.*;

public class Spielfeld
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Maus dieMaus;
    Uhr dieUhr;
    boolean kreuz=true;
    int n;
    int m;
    Figur figur1;
    Figur figur2;
    Figur figur3;
    Figur figur4;
    Figur figur5;
    Figur figur6;
    Figur figur7;
    Figur figur8;
    Figur figur9;
    // Konstruktor
    public Spielfeld()
    {
        derBildschirm = new Bildschirm(800,600);
        meinStift = new Buntstift();
        dieMaus = new Maus();
        dieUhr = new Uhr();
        figur1 = new Figur(derBildschirm, meinStift);
        figur2 = new Figur(derBildschirm, meinStift);
        figur3 = new Figur(derBildschirm, meinStift);
        figur4 = new Figur(derBildschirm, meinStift);
        figur5 = new Figur(derBildschirm, meinStift);
        figur6 = new Figur(derBildschirm, meinStift);
        figur7 = new Figur(derBildschirm, meinStift);
        figur8 = new Figur(derBildschirm, meinStift);
        figur9 = new Figur(derBildschirm, meinStift);
        this.zeichne();
        
            while(kreuz){
                this.setzeKreuz(figur1);
            }
            dieUhr.warte(400);
            while(!kreuz){
                this.setzeKreis(figur2);
            }
            dieUhr.warte(400);
            while(kreuz){
                this.setzeKreuz(figur3);
            }
            dieUhr.warte(400);
            while(!kreuz){
                this.setzeKreis(figur4);
            }
            dieUhr.warte(400);
            while(kreuz){
                this.setzeKreuz(figur5);
            }
            this.hatNachfolger();
            dieUhr.warte(400);
            while(!kreuz){
                this.setzeKreis(figur6);
            }
            this.hatNachfolger();
            dieUhr.warte(400);
            while(kreuz){
                this.setzeKreuz(figur7);
            }
            this.hatNachfolger();
            dieUhr.warte(400);
            while(!kreuz){
                this.setzeKreis(figur8);
            }
            this.hatNachfolger();
            dieUhr.warte(400);
            while(kreuz){
                this.setzeKreuz(figur9);
            }
            this.hatNachfolger();
            dieUhr.warte(400);
        meinStift.bewegeBis(605,100);
        meinStift.schreibeText("Unentschieden!");
    }

    // Dienste
    public void nmPosition(double h, double v){
        if(h<200)n=1;
        else if(h<400)n=2;
        else n=3;
        
        if(v<200)m=1;
        else if(v<400)m=2;
        else m=3;
    }
    
    public void setzeKreis(Figur dieFigur){
        if (dieMaus.istGedrueckt()){
            this.nmPosition(dieMaus.hPosition(),dieMaus.vPosition());
            dieFigur.setzeKreis(n,m);
            kreuz=!kreuz;
        }
    }
    
    public void setzeKreuz(Figur dieFigur){
        if (dieMaus.istGedrueckt()){
            this.nmPosition(dieMaus.hPosition(),dieMaus.vPosition());
            dieFigur.setzeKreuz(n,m);
            kreuz=!kreuz;
        }
    }
    
    public void hatNachfolger(){
        figur1.hatNachfolger(figur3);
        figur1.hatNachfolger(figur5);
        figur1.hatNachfolger(figur7);
        figur1.hatNachfolger(figur9);
        figur1.hatNN(figur3);
        figur1.hatNN(figur5);
        figur1.hatNN(figur7);
        figur1.hatNN(figur9);
        
        figur2.hatNachfolger(figur4);
        figur2.hatNachfolger(figur6);
        figur2.hatNachfolger(figur8);
        figur2.hatNN(figur4);
        figur2.hatNN(figur6);
        figur2.hatNN(figur8);
        
        figur3.hatNachfolger(figur1);
        figur3.hatNachfolger(figur5);
        figur3.hatNachfolger(figur7);
        figur3.hatNachfolger(figur9);
        figur3.hatNN(figur1);
        figur3.hatNN(figur5);
        figur3.hatNN(figur7);
        figur3.hatNN(figur9);
        
        figur4.hatNachfolger(figur2);
        figur4.hatNachfolger(figur6);
        figur4.hatNachfolger(figur8);
        figur4.hatNN(figur2);
        figur4.hatNN(figur6);
        figur4.hatNN(figur8);
        
        figur5.hatNachfolger(figur1);
        figur5.hatNachfolger(figur3);
        figur5.hatNachfolger(figur7);
        figur5.hatNachfolger(figur9);
        figur5.hatNN(figur1);
        figur5.hatNN(figur3);
        figur5.hatNN(figur7);
        figur5.hatNN(figur9);
        
        figur6.hatNachfolger(figur2);
        figur6.hatNachfolger(figur4);
        figur6.hatNachfolger(figur8);
        figur6.hatNN(figur2);
        figur6.hatNN(figur4);
        figur6.hatNN(figur8);
        
        figur7.hatNachfolger(figur1);
        figur7.hatNachfolger(figur3);
        figur7.hatNachfolger(figur5);
        figur7.hatNachfolger(figur9);
        figur7.hatNN(figur1);
        figur7.hatNN(figur3);
        figur7.hatNN(figur5);
        figur7.hatNN(figur9);
        
        figur8.hatNachfolger(figur2);
        figur8.hatNachfolger(figur4);
        figur8.hatNachfolger(figur6);
        figur8.hatNN(figur2);
        figur8.hatNN(figur4);
        figur8.hatNN(figur6);
        
        figur9.hatNachfolger(figur1);
        figur9.hatNachfolger(figur3);
        figur9.hatNachfolger(figur5);
        figur9.hatNachfolger(figur7);
        figur9.hatNN(figur1);
        figur9.hatNN(figur3);
        figur9.hatNN(figur5);
        figur9.hatNN(figur7);
    }
    public void zeichne()
    {
        // Aktionsteil
        meinStift.bewegeBis(0,200);
        meinStift.runter();
        meinStift.bewegeBis(600,200);
        meinStift.hoch();
        meinStift.bewegeBis(0,400);
        meinStift.runter();
        meinStift.bewegeBis(600,400);
        meinStift.hoch();        
        meinStift.bewegeBis(200,0);
        meinStift.runter();
        meinStift.bewegeBis(200,600);
        meinStift.hoch();        
        meinStift.bewegeBis(400,0);
        meinStift.runter();
        meinStift.bewegeBis(400,600);
        meinStift.hoch();
    }
}