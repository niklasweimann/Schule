import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Personen
{
    // Objekte
    String[][] daten = new String[100][3];

    // Konstruktor
    public Personen()
    {

    }

    // Dienste
    public void add(String pName, String pVorname, String pGeburtstag)
    {
        int y=0;
        boolean saving = false;
        while(saving == false){
            if(daten[y][0]== null)
            {
                daten[y][0] = pName;
                daten[y][1] = pVorname;
                daten[y][2] = pGeburtstag;
                saving = true;                
            }
            else
            {
                y++;
            }

        }
        y=0;
        saving=false;
    }

    public String read(int x, int y)
    {
        return(daten[x][y]);
    }

    public void delete(int x)
    {
        daten[x][0] = null;
        daten[x][1] = null;
        daten[x][2] = null;
    }

    public int getArrayLength()
    {
        return daten.length;
    }
}