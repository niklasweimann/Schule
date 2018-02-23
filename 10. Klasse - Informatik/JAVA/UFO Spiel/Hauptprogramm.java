import sum.kern.*;
/**
 * @author Niklas Weimann
 * @version 
 */
public class Hauptprogramm
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Ufo meinUfo;
    Tastatur meineTastatur;

    // Konstruktor
    public Hauptprogramm()
    {
        derBildschirm = new Bildschirm(700, 500);
        meinStift = new Buntstift();
        meinUfo = new Ufo(100, 100, 10, 1, derBildschirm);
        meineTastatur = new Tastatur();

    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        char key;
        int muster = 0;
        int i = 1;
        int score = 0;
        while(i == 1){
            meinStift.bewegeBis(derBildschirm.breite()/2, derBildschirm.hoehe()/2);
            meinStift.schreibeText("Drücke S um zu beginnen");
            if(meineTastatur.wurdeGedrueckt()){
                if(meineTastatur.zeichen() == 's'){
                    i++;
                    derBildschirm.loescheAlles();
                }
                meineTastatur.weiter();
            }
        }
        meinUfo.zeichne();
        while(i == 2)
        {
            if(meineTastatur.wurdeGedrueckt()){
                if (meineTastatur.zeichen() == 'a'){
                    meinUfo.dreheLinks();
                }
                else if(meineTastatur.zeichen() == 'd'){
                    meinUfo.dreheRechts();
                }
                else if(meineTastatur.zeichen() == 'm'){
                    if(muster == 1){
                        meinUfo.setzeMuster(0);
                        muster--;
                    }
                    else if(muster == 0){
                        meinUfo.setzeMuster(1);
                        muster++;
                    }
                }
                else if(meineTastatur.zeichen() == '1'){
                    meinUfo.setzeFarbe(1);
                }
                else if(meineTastatur.zeichen() == '2'){
                    meinUfo.setzeFarbe(2);
                }
                else if(meineTastatur.zeichen() == '3'){
                    meinUfo.setzeFarbe(3);
                }
                else if(meineTastatur.zeichen() == '4'){
                    meinUfo.setzeFarbe(4);
                }
                meineTastatur.weiter();
            }
            meinUfo.bewege();
            if(meinUfo.amLinkenRand() == true || meinUfo.amRechtenRand() == true || meinUfo.amOberenRand() == true || meinUfo.amUnterenRand() == true)
            {
                i++;
            }
            score++;
        }
        if(i == 3){
            
        }

        // Aufraeumen
        meinStift.gibFrei();
        meinUfo.gibFrei();
        derBildschirm.gibFrei();
        meineTastatur.gibFrei();
    }
}