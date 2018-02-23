import sum.kern.*;
/**
 * @author Niklas Weimann
 * @version 1.0.0
 */
public class Patient
{
    // Objekte
    private String Name;
    private String Nachname;
    private String Krankenkasse;
    private Patient Nachfolger;

    // Konstruktor
    public Patient(String pName, String pNachname, String pKrankenkasse)
    {
        Name = pName;
        Nachname = pNachname;
        Krankenkasse = pKrankenkasse;
        Nachfolger = null;
    }

    // Dienste
    public String getName()
    {
        return Name;
    }
    
    public String getNachname()
    {
        return Nachname;
    }
    
    public String getKrankenkasse()
    {
        return Krankenkasse;
    }
    
    public void setNachfolger(Patient pPatient)
    {
        
    }
    
    public Patient getNachfolger()
    {
        return Nachfolger;
    }
}