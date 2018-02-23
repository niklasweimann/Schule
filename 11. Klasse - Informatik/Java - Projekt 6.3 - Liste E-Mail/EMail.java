/**
 * @author Niklas Weimann
 * @version 
 */
public class EMail
{
    // Bezugsobjekte

    // Attribute
    private String Absender;
    private String Empfaenger;
    private String Betreff;
    private String Datum;
    private String Inhalt;

    // Konstruktor
    public EMail(String pAbsender, String pEmpfaenger, String pBetreff, String pDatum, String pInhalt)
    {
        Absender = pAbsender;
        Empfaenger = pEmpfaenger;
        Betreff = pBetreff;
        Datum = pDatum;
        Inhalt = pInhalt;
    }

    // Dienste
    public String getAbsender(){
        return Absender;
    }
    
    private void setAbsender(String pAbsender){
        Absender = pAbsender;
    }
    
    public String getEmpfaenger(){
        return Empfaenger;
    }
    
    private void setEmpfaenger(String pEmpfaenger){
        Empfaenger = pEmpfaenger;
    }
    
    public String getBetreff(){
        return Betreff;
    }
    
    private void setBetreff(String pBetreff){
        Betreff = pBetreff;
    }
    
    public String getDatum(){
        return Datum;
    }
    
    private void setDatum(String pDatum){
        Datum = pDatum;
    }
    
    public String getInhalt(){
        return Inhalt;
    }
    
    private void setInhalt(String pInhalt){
        Inhalt = pInhalt;
    }
}
