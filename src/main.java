import java.util.Random;
import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        String txt = "Proszę podać wybrać strukturę do testowania: \n" +
                "1. Tablica dynamiczna \n"+
                "2. Lista dwukierunkowa \n"+
                "3. Drzwo \n"+
                "4. Wyświetlenie przykładowej tablicy \n"+
                "5. Wyświetlenie przykładowej listy \n"+
                "6. Wyświetlenie przykładowego drzewa \n";
                System.out.print(txt);
        int option = sc.nextInt();
       int sizeOfStructure;
       int countOfTests;

        switch(option)
        {
            case 1:
                System.out.println("Proszę podać wielkość struktury\n");
                sizeOfStructure = sc.nextInt();
                System.out.println("Proszę podać ilość testów\n");
                countOfTests = sc.nextInt();
                Tests.DynamicArrayTest(sizeOfStructure,countOfTests);
                break;
            case 2:
                System.out.println("Proszę podać wielkość struktury\n");
                sizeOfStructure = sc.nextInt();
                System.out.println("Proszę podać ilość testów\n");
                countOfTests = sc.nextInt();
                Tests.DoubleLinkedListTest(sizeOfStructure,countOfTests);
                break;

            case 3:
                System.out.println("Proszę podać wielkość struktury\n");
                sizeOfStructure = sc.nextInt();
                System.out.println("Proszę podać ilość testów\n");
                countOfTests = sc.nextInt();
                Tests.TreeTest(sizeOfStructure,countOfTests);
                break;
            case 4:
                DynamicArray array = new DynamicArray();
                array.random(10,100);
                array.print();
                break;
            case 5:
                DoubleLinkedList list = new DoubleLinkedList();
                list.random(10,100);
                list.print();
                break;
            case 6:
                Tree tree = new Tree();
                tree.random(10,100);
                tree.print(System.out);
                break;
        }
        sc.close();
    }
}
