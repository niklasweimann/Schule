/**
 * @author 
 * @version 
 */
public class Warteraum
{
    // Bezugsobjekte

    // Attribute
    private int zAnzahl;
    private Patient ersterPatient;
    // Konstruktor
    public Warteraum()
    {

    }

    // Dienste
    public void neuerPatient(Patient pPatient)
    {
        Patient lPatient = new Patient(pPatient.getName(), pPatient.getNachname(), pPatient.getKrankenkasse());
        if(ersterPatient == null)
        {
            ersterPatient = pPatient;
        }
        else
        {
            lPatient = ersterPatient;
            while(lPatient.getNachfolger() !=null)
            {
                lPatient = lPatient.getNachfolger();
            }
            lPatient.setNachfolger(pPatient);
        }
    }

    public void entferneErstenPatient()
    {
        ersterPatient = ersterPatient.getNachfolger();
    }

    public Patient kenntErsterPatient()
    {
        return ersterPatient;
    }
}
