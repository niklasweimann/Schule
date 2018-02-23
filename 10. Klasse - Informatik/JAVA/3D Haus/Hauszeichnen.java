import sum.kern.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Niklas Weimann
 * @version 1.0
 */
public class Hauszeichnen
{
    // Objekte
    Bildschirm derBildschirm;
    Stift mS;

    // Konstruktor
    public Hauszeichnen()
    {
        derBildschirm = new Bildschirm();
        mS = new Stift();
        mS.bewegeBis(200, 200);
        mS.runter();
        for(int wh = 0; wh < 4; wh++){
            mS.dreheUm(90);
            mS.bewegeUm(-100);
        }
        mS.hoch();
        mS.bewegeBis(200, 200);
        mS.runter();
        mS.dreheUm(45);
        mS.bewegeUm(70); 
        mS.dreheUm(-90);
        mS.bewegeUm(70);
        mS.bewegeUm(-70);
        mS.dreheUm(60); 
        mS.bewegeUm(200);
        mS.dreheUm(120); 
        mS.bewegeUm(-60);
        mS.dreheUm(62.5); 
        mS.bewegeUm(200);
        mS.bewegeUm(-200);
        mS.dreheUm(73);
        mS.bewegeUm(75);
        mS.dreheUm(-66);
        mS.bewegeUm(200);
        mS.hoch();
        mS.gibFrei();
    }
}