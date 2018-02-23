import java.util.Arrays;
/**
 * @author 
 * @version 
 */
public class InsertationSort extends Sort
{
    // Bezugsobjekte

    // Attribute

    // Konstruktor
    public InsertationSort()
    {

    }

    // Dienste
    int z = 0;
    public void sort(int[] array, int elemente, SortAlgoJava f1)
    {
        int temp, j;
        int[] temparray = new int[array.length];

        for (int i = 1; i < array.length; i++)
        {
            System.arraycopy(array,0, temparray,0, array.length);

            temp = array[i];
            j = i - 1;

            f1.testedValue++;
            while (j >= 0 && array[j] > temp)
            {
                array[j + 1] = array[j];
                j--;
                f1.changedValues++;
            }
            array[j + 1] = temp;

            z = ColorNumbers(array, temparray, z, f1);
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
