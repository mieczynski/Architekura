import java.util.Random;

public class DynamicArray
{
    private int array[];
    private int max_size;
    private int size;

    public DynamicArray()
    {
        array = new int[1];
        max_size = 1;
        size = 0;
    }
    public void push(int data)
    {
        if (size == max_size) {
            int temp[] = new int[max_size + 1];

            for (int i = 0; i < max_size; i++)
                temp[i] = array[i];

            max_size ++;
            array = temp;
        }

        array[size] = data;
        size++;
    }
    void push(int data, int index)
    {
        if (index == max_size)
        {
            push(data);
        }
        else if(index>=size || index<0)
        {
            System.out.println("Brak elementu na podanym indeksie");
        }
        else
        {
            int temp[] = new int[max_size + 1];
            for (int i =0;i<index;i++)
                temp[i] = array[i];
            for(int i =index; i<max_size;i++)
                temp[i+1]=array[i];
            temp[index]=data;
            array=temp;
            size++;
            max_size++;
        }
    }
    int get(int index)
    {
        if (index < max_size)
            return array[index];

        return -1;
    }
    void pop()
    {
        size--;
        max_size--;
    }

    public void popIndex(int index){
        if(index>=size || index<0)
        {
            System.out.println("Brak elementu na podanym indeksie1");
        }
        else
        {
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=0;
            size--;
            max_size--;
        }
    }
    int size()
    {
        return size;
    }

    int getMax_size()
    {
        return max_size;
    }

    void print()
    {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    void random(int test, int max)

    {
        int temp[] = new int[test];
        Random generator = new Random();
        for (int i=0;i<test;i++)
            temp[i]=(generator.nextInt(max));

        array=temp;
        size=test-1;
        max_size=size+1;
    }
}
