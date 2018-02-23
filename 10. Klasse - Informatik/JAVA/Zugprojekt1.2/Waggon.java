import sum.kern.*;
/**
 * @author  Niklas Weimann
 * @version 1.0.0
 */
public abstract class Waggon
{
    // Bezugsobjekte
    // hatObjekt
    protected Stift hatStift;
    //kenntObjekt
    private Bildschirm kenntBildschirm;
    // Attribute
    private double geschwindigkeit;
    // Konstruktor
    public Waggon(Bildschirm pBildschirm)
    {
        kenntBildschirm = pBildschirm;
        hatStift = new Stift();
    }
    
    //abrstrackte Dienste
    public abstract void zeichne();
    // Dienste
    public double hPosition(){
        return hatStift.hPosition();
    }
    public double vPosition(){
        return hatStift.vPosition();
    }
    

    public void bewegeBis(double XPos, double YPos)
    {
        hatStift.bewegeBis(XPos, YPos);
    }
    
    public void setzeGeschwindigkeit(double newSpeed){
        this.geschwindigkeit = geschwindigkeit * newSpeed;
    }
    public double zeigeSpeed(){
        return this.geschwindigkeit;
    }
    public void bewege(){
        hatStift.radiere();
        this.zeichne();
        hatStift.dreheBis(0);
        hatStift.bewegeUm(this.geschwindigkeit);
        hatStift.normal();
        this.zeichne();
        hatStift.dreheBis(0);
    }

    public void setGeschwindigkeit(double speed)
    {
        this.geschwindigkeit = speed;
    }

}
