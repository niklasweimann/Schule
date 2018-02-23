import java.util.Arrays;
/**
 * @author 
 * @version 
 */
public class Sort
{
    // Bezugsobjekte

    // Attribute

    // Konstruktor
    public Sort()
    {

    }

    // Dienste
    public int ColorNumbers(int[] neu, int[] alt, int z, SortAlgoJava f1)
    {
        f1.hatTextfeld2.haengeAn("Schritt " + z + ": ");
        z++;
        try{
            Thread.sleep(f1.delay);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }

        for (int x = 0; x < neu.length; x++)
        {
            f1.hatTextfeld2.haengeAn(alt[x]);
            f1.hatTextfeld2.haengeAn(" ");
        }
        f1.hatTextfeld2.haengeAn("\n");
        //Scrollen
        return z;
    }
}
