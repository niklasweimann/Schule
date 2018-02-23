import java.util.Arrays;
/**
 * @author 
 * @version 
 */
public class MergeSort extends Sort
{
    // Bezugsobjekte

    // Attribute

    // Konstruktor
    public MergeSort()
    {

    }

    // Dienste
    int z = 0;
    public void sort(int[] input, int left, int right, SortAlgoJava f1)
    {
        int[] temparray = new int[input.length];

        if (left < right)
        {
            int middle = (left + right) / 2;

            System.arraycopy(input,0, temparray,0, input.length);

            sort(input, left, middle, f1);
            sort(input, middle + 1, right, f1);

            //Merge
            int[] leftArray = new int[middle - left + 1];
            int[] rightArray = new int[right - middle];

            System.arraycopy(input, left, leftArray, 0, middle - left + 1);
            System.arraycopy(input, middle + 1, rightArray, 0, right - middle);
            f1.changedValues++;

            int i = 0;
            int j = 0;
            for (int k = left; k < right + 1; k++)
            {
                if (i == leftArray.length)
                {
                    input[k] = rightArray[j];
                    j++;
                    f1.testedValue++;
                }
                else if (j == rightArray.length)
                {
                    input[k] = leftArray[i];
                    i++;
                    f1.testedValue++;
                }
                else if (leftArray[i] <= rightArray[j])
                {
                    input[k] = leftArray[i];
                    i++;
                    f1.testedValue++;
                }
                else
                {
                    input[k] = rightArray[j];
                    j++;
                    f1.testedValue++;
                }
            }
            z = ColorNumbers(input, temparray, z, f1);
            try{
                Thread.sleep(f1.delay);
            }
            catch (InterruptedException e) {
                System.out.println("Interrupted.");
            }
            f1.hatTextfeld2.haengeAn("Schritt " + z + ": " + Arrays.toString(input));
            f1.hatTextfeld2.haengeAn("\n");
            z = 0;
        }
    }
}
