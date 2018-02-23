
import sum.kern.*;
public class Figur
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Figur nachfolger1;
    Figur nachfolger2;
    Figur nachfolger3;
    Figur nachfolger4;
    boolean kreis;
    int n=-10;
    int m=-10;

    // Konstruktor
    public Figur(Bildschirm derBildschirm,Buntstift meinStift)
    {
        this.derBildschirm = derBildschirm;
        this.meinStift = meinStift;
    }

    // Dienste
    public void setzeKreuz(int n,int m)
    {
        meinStift.bewegeBis(n*200-195,m*200-195);
        meinStift.runter();
        meinStift.bewegeBis(n*200-5,m*200-5);
        meinStift.hoch();
        meinStift.bewegeBis(n*200-195,m*200-5);
        meinStift.runter();
        meinStift.bewegeBis(n*200-5,m*200-195);
        meinStift.hoch();
        kreis=false;
        this.n=n;
        this.m=m;
    }
    
    public void hatNachfolger(Figur meineFigur){
        if(nachfolger1==null&&meineFigur.getN()==this.n+1&&meineFigur.getM()==this.m&&this.kreis==meineFigur.getKreis()){
            nachfolger1=meineFigur;
        }
        
        if(meineFigur!=null&&nachfolger2==null&&meineFigur.getN()==this.n+1&&meineFigur.getM()==this.m+1&&this.kreis==meineFigur.getKreis()){
            nachfolger2=meineFigur;
        }
        
        if(meineFigur!=null&&nachfolger3==null&&meineFigur.getN()==this.n&&meineFigur.getM()==this.m+1&&this.kreis==meineFigur.getKreis()){
            nachfolger3=meineFigur;
        }
        
        if(meineFigur!=null&&nachfolger4==null&&meineFigur.getN()==this.n-1&&meineFigur.getM()==this.m+1&&this.kreis==meineFigur.getKreis()){
            nachfolger4=meineFigur;
        }
    }
    
    public void hatNN(Figur dieFigur){
        meinStift.bewegeBis(605,100);
        if(dieFigur!=null&&nachfolger1!=null&&nachfolger1.getN()+1==dieFigur.getN()&&nachfolger1.getM()==dieFigur.getM()&&dieFigur.getKreis()==nachfolger1.getKreis()){
            meinStift.schreibeText("You Win! Waagerecht, "+"Kreis="+kreis);
        }
        
        if(nachfolger2!=null&&nachfolger2.getN()+1==dieFigur.getN()&&nachfolger2.getM()+1==dieFigur.getM()&&dieFigur.getKreis()==nachfolger2.getKreis()){
            meinStift.schreibeText("You Win! Diagonal,"+"Kreis="+kreis);
        }
        
        if(nachfolger3!=null&&nachfolger3.getN()==dieFigur.getN()&&nachfolger3.getM()+1==dieFigur.getM()&&dieFigur.getKreis()==nachfolger3.getKreis()){
            meinStift.schreibeText("You Win! Senkrecht,"+"Kreis="+kreis);
        }
        
        if(nachfolger4!=null&&nachfolger4.getN()-1==dieFigur.getN()&&nachfolger4.getM()+1==dieFigur.getM()&&dieFigur.getKreis()==nachfolger4.getKreis()){
            meinStift.schreibeText("You Win! Diagonal,"+"Kreis="+kreis);
        }
        
    }
    
    public int getN(){ return n;}
    
    public int getM(){ return m;}
    
    public boolean getKreis(){ return kreis;}
    
    public void setzeKreis(int n,int m)
    {
        meinStift.bewegeBis(n*200-100,m*200-100);
        meinStift.zeichneKreis(90);
        kreis=true;
        this.n=n;
        this.m=m;
    }
    
    
}