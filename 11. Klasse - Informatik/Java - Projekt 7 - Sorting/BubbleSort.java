import java.util.Arrays;
/**
 * @author 
 * @version 
 */
public class BubbleSort extends Sort
{
    // Bezugsobjekte

    // Attribute

    // Konstruktor
    public BubbleSort()
    {

    }

    // Dienste
    int z = 0;
    public void sort(int[] array, int elemente, SortAlgoJava f1)
    {
        int[] temparray = new int[array.length];
        int i, temp;

        while (elemente >= 0)
        {
            for (i = 1; i <= elemente; i++)
            {
                System.arraycopy( array, 0, temparray, 0, array.length );
                f1.testedValue++;
                if (array[i - 1] > array[i])
                {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    f1.changedValues++;
                }
                z = ColorNumbers(array, temparray, z, f1);
            }
            elemente--;
        }
        try{
            Thread.sleep(f1.delay);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
        f1.hatTextfeld2.haengeAn("Schritt " + z + ": " + Arrays.toString(array));
        z = 0;
    }
}
