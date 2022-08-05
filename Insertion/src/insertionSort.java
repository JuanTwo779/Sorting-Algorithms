import java.util.*;

public class insertionSort {
    public static void main(String[] args)
    {
        Random objRand = new Random();
        int[] numbers = new int[objRand.nextInt(20)];

        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = objRand.nextInt(100);
        }

        System.out.println("Before: ");
        System.out.println(Arrays.toString(numbers));

        insertSort(numbers);
        System.out.println("");

        System.out.println("Now: ");
        System.out.println(Arrays.toString(numbers));

    }

    //array in increasing order
    private static void insertSort(int[] inputArray)
    {
        for(int i = 1; i < inputArray.length; i++)
        {
            int tempValue = inputArray[i];

            int j = i - 1;

            while(j >= 0 && inputArray[j] > tempValue)
            {
                inputArray[j + 1] = inputArray[j];
                j--;
            }

            inputArray[j + 1] = tempValue;
        }
    }


}
