import java.util.Scanner;
import java.util.Arrays;

public class MinHeap
{
    private int[] heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public MinHeap()
    {
        this.maxSize = 0;
        this.size = 0;
        heap = new int[this.maxSize + 1];
    }

    public MinHeap(int maxSize)
    {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    public void display()
    {
        if (heap.length > (size / 2) * 2 + 1)
        {
            System.out.println("PARENT NODE" + "\t" + "LEFT NODE" + "\t" + "RIGHT NODE");
            for (int i = 1; i <= size / 2; i++)
            {
                System.out.print(" " + heap[i] + "\t\t" + heap[2 * i]
                        + "\t\t" + heap[2 * i + 1]);
                System.out.println();
            }
        }
        else
            System.out.println("Not a complete binary tree. Add more elements!");
    }

    public void getUserInput()
    {
        boolean cont = true;
        do
        {
            System.out.println("Press 1 to insert an element onto the heap");
            System.out.println("Press 2 to remove the root node from the heap");
            System.out.println("Press 3 to view the heap");
            System.out.println("Press 4 to exit");
            Scanner console = new Scanner(System.in);
            String choice = console.nextLine();
            switch(choice)
            {
                case "1":
                    insertValue();
                    break;
                case "2":
                    remove();
                    break;
                case "3":
                    display();
                    break;
                case "4":
                    System.out.println("Exiting. Goodbye!");
                    cont = false;
                    break;
                default:
                    System.out.println("Unrecognized input. Exiting!");
                    break;
            }

        }while(cont);
    }

    public void insert(int element)
    {
        heap = Arrays.copyOf(heap, heap.length + 1);
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void insertValue()
    {
        boolean cont = true;
        int value = 0;
        do
        {
            Scanner console = new Scanner(System.in);
            System.out.println("Please enter a numeric value");
            try
            {
                value = Integer.parseInt(console.nextLine());
                cont = false;
            }
            catch(Exception e)
            {
                System.out.println("Incorrect numeric entry. Try again!");
            }
        }while(cont);
        insert(value);
        minHeap();
    }

    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size)
            return true;
        return false;
    }

    public int leftChild(int pos)
    {
        return (2 * pos);
    }

    public static void main(String[] arg)
    {
        MinHeap minHeap = new MinHeap();
        minHeap.startDemo();
    }

    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            minHeapify(pos);
        }
    }

    private void minHeapify(int pos)
    {
        if (!isLeaf(pos))
        {
            if (heap[pos] > heap[leftChild(pos)]
                    || heap[pos] > heap[rightChild(pos)])
            {
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else
                {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public int parent(int pos)
    {
        return pos / 2;
    }

    public int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    public void swap(int firstPosition, int secondPosition)
    {
        int tmp;
        tmp = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = tmp;
    }

    public int remove()
    {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    public void startDemo()
    {
        getUserInput();
    }
}
