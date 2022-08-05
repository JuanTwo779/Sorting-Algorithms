import java.util.Random;

public class Bubble
{
    public int[] bubbleSort (int[] list)
    {
        int temp = 0; //used for swaps

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]){
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }

            }

        }
        return list;
    }

    public static void main(String[] args) {
        Bubble bub = new Bubble();
        int[] list = bub.bubbleSort(bub.randomArray());

        System.out.println(" ");
        for (int n: list ) {
            System.out.print(n + ", ");
        }

    }

    public int[] randomArray()
    {
        Random rnd = new Random();
        int[] list = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = rnd.nextInt(100);
            System.out.print(list[i] + ", ");
        }
        return list;
    }

}
