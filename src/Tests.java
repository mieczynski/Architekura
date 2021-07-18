import java.text.DecimalFormat;
import java.util.Random;

public class Tests {

    public static void DoubleLinkedListTest(int sizeOfStructure, int countOfTests) {
        long startTime;
        long endTime;
        long duration;
        double averageOfAdd = 0;
        double averageOfAdd_End = 0;
        double averageOfRemove = 0;
        String txt;
        Random generator = new Random();
        System.out.println("-------DoubleLinkedList-------");
        for (int i = 0; i < countOfTests; i++) {

            DoubleLinkedList list = new DoubleLinkedList();
            list.random(sizeOfStructure, 100000);
            int a = generator.nextInt(sizeOfStructure);
            //dodawanie w wybrane miejsce
            startTime = System.nanoTime();
            list.add(a,10000);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfAdd +=duration;
            // dodawanie na koniec
            startTime = System.nanoTime();
            list.add_end(10000);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfAdd_End +=duration;
            //usuwanie z wybranego miejsca
            startTime = System.nanoTime();
            list.remove(a);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfRemove +=duration;
        }
        txt = "Dodawanie w wybrane miejsce: " + (averageOfAdd / countOfTests) + " us\n" + "Dodawanie na koniec: "
         + (averageOfAdd_End / countOfTests) + " us\n" + "Usuniecie z wybranego miejsca " +
           (averageOfRemove/ countOfTests) + " us\n" ;
        System.out.println(txt);

        System.out.print("------------------------------");
    }
    public static void DynamicArrayTest(int sizeOfStructure, int countOfTests) {
        long startTime;
        long endTime;
        long duration;
        double averageOfAdd = 0;
        double averageOfAdd_End = 0;
        double averageOfPopIndex=0;
        double averageOfPop=0;
        String txt;
        Random generator = new Random();
        System.out.println("-------DynamicArray-------");
        for (int i = 0; i < countOfTests; i++) {

            DynamicArray array = new DynamicArray();
            array.random(sizeOfStructure, 100000);
            int a = generator.nextInt(sizeOfStructure);
            //dodawanie w wybrane miejsce
            startTime = System.nanoTime();
            array.push(a,a);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfAdd +=duration;
            // dodawanie na koniec
            startTime = System.nanoTime();
            array.push(a);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfAdd_End +=duration;
            //usuwanie z wybranego miejsca
            startTime = System.nanoTime();
            array.popIndex(a);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfPopIndex +=duration;
            startTime = System.nanoTime();
            array.pop();
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfPop +=duration;
        }
        txt = "Dodawanie w wybrane miejsce: " + (averageOfAdd / countOfTests) + " us\n" + "Dodawanie na koniec: "
                + (averageOfAdd_End / countOfTests) + " us\n" + "Usuniecie z wybranego miejsca " +
                (averageOfPopIndex/ countOfTests) + " us\n"+ "Usuniecie z końca " +
                (averageOfPop/ countOfTests) + " us\n" ;
        System.out.println(txt);

        System.out.print("------------------------------");
    }
    public static void TreeTest(int sizeOfStructure, int countOfTests) {
        long startTime;
        long endTime;
        long duration;
        double averageOfAdd = 0;
        double averageOfRemove = 0;
        String txt;
        Random generator = new Random();
        System.out.println("-------Tree-------");
        for (int i = 0; i < countOfTests; i++) {

           Tree tree= new Tree();
           int [] temp;
            temp = tree.random(sizeOfStructure, 100000);
            int a = generator.nextInt(sizeOfStructure);
            int rand = generator.nextInt(temp.length);

            //dodawanie wezela
            startTime = System.nanoTime();
            tree.addNode(a);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfAdd +=duration;
            //usuwanie wezla
            startTime = System.nanoTime();
            tree.removeNode(temp[rand]);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            averageOfRemove +=duration;
        }
        txt = "Dodawanie w wybrane miejsce: " + (averageOfAdd / countOfTests) + " us\n"
                + "Usuniecie z wybranego miejsca " + (averageOfRemove/ countOfTests) + " us\n" ;
        System.out.println(txt);

        System.out.print("------------------------------");
    }

}
