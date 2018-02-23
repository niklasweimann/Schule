import java.util.Arrays;
/**
 * @author 
 * @version 
 */
public class SelectionSort extends Sort
{
    // Bezugsobjekte

    // Attribute

    // Konstruktor
    public SelectionSort()
    {

    }

    // Dienste
    int z = 0;
    public void sort(int[] array, int elemente, SortAlgoJava f1)
    {
        int index, index_klein,
        wert, wert_klein;

        int[] temparray = new int[array.length];

        for (index = 0; index < elemente; index++)
        {
            System.arraycopy(array, 0, temparray, 0, array.length);

            wert = index;
            for (index_klein = index + 1; index_klein <= elemente; index_klein++)
            {
                if (array[index_klein] < array[wert])
                {
                    wert = index_klein;
                }
            }

            if (wert != index)
            {
                wert_klein = array[wert];
                array[wert] = array[index];
                array[index] = wert_klein;
                f1.changedValues++;
            }
            f1.testedValue++;
            z = ColorNumbers(array, temparray, z,  f1);
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
