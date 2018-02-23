import sum.kern.*;
/**
 * @author Niklas Weimann
 * @version 1.0.0
 */
public class Zug
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;
    Lokomotive meineLokomotive;
    Gueterwaggon meinGueterwaggon;
    Personenwaggon meinPersonenwaggon;
    Tastatur meineTastatur;
    Maus dieMaus;
    // Konstruktor
    public Zug()
    {
        derBildschirm = new Bildschirm(700,700);
        meinStift = new Stift();
        meineLokomotive = new Lokomotive(derBildschirm);
        meinGueterwaggon = new Gueterwaggon(derBildschirm);
        meinPersonenwaggon = new Personenwaggon(derBildschirm);
        meineTastatur = new Tastatur();
        dieMaus = new Maus();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        int gamemode = 1;
        while(gamemode == 1){
            if(dieMaus.istGedrueckt() == true){
                meineLokomotive.bewegeBis(dieMaus.hPosition(), dieMaus.vPosition());
                gamemode++;
            }
            else{
                meinStift.bewegeBis(dieMaus.hPosition(), dieMaus.vPosition());
                meinStift.runter();
                meinStift.normal();
                this.zeichneZielrohr();
                meinStift.radiere();
                this.zeichneZielrohr();
                meinStift.hoch();
            }
        }
        meineLokomotive.zeichne();
        meinGueterwaggon.bewegeBis(10,10);
        while(gamemode == 2){
            if(meineTastatur.wurdeGedrueckt() == true){
                switch(meineTastatur.zeichen())
                {
                    case '+':meineLokomotive.setGeschwindigkeit(1.1);break;
                    case '-':meineLokomotive.setGeschwindigkeit(0.9);break;
                    case 'd':meineLokomotive.bewege();break;
                    case 'p':meinGueterwaggon.zeichne();break;
                    //case 'g':meineLokomotive.kopple("gueterwaggon");break;
                    //case 'a':meineLokomotive.kopple("abhaengen");break;
                }
                meineTastatur.weiter();
            }
            meinStift.bewegeBis(400,10);
            meinStift.schreibeZahl(meineLokomotive.zeigeSpeed());
        }
        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
    }

    public void zeichneZielrohr(){
        meinStift.zeichneKreis(5);
        for(int i = 0; i <=4; i++){ 
            meinStift.bewegeUm(10);
            meinStift.bewegeUm(-10);
            meinStift.dreheUm(90);
        }
    }
}