import java.util.Random;

public class DoubleLinkedList<Integer, count> {
    private Node<Integer> first;
    private Node<Integer> last;
    private int size=0;
    private static class Node<Integer> {
        private int element;
        private Node<Integer> next;
        private Node<Integer> previous;

        Node(int element) {
            this.element = element;
        }
    }
    public boolean isEmpty() {
        return first == null;
    }

    public Node<Integer> getFirst() {
        return first;
    }

    public void setFirst(Node<Integer> first) {
        this.first = first;
    }

    public Node<Integer> getLast() {
        return last;
    }

    public void setLast(Node<Integer> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int get(int index) {
        return getNode(index).element;
    }

    private Node<Integer> getNode(int index) {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index);
        }
        Node<Integer> currentNode = first;
        int currentIndex = index;
        while (currentIndex > 0) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Index " + index);
            }
            currentNode = currentNode.next;
            currentIndex--;
        }
        return currentNode;
    }

    public boolean add(int index, int element) {
        if (first == null && index == 0) {
            first = new Node<>(element);
            last = first;
            size++;
            return true;
        }

        Node<Integer> nodeAtIndex = getNode(index);

        if (index> size) {
            throw new IndexOutOfBoundsException("Index " + index);
        }
        else
        {
            size++;
            // dodawanie na koniec listy
            if (nodeAtIndex == null) {
                Node<Integer> previousLast = last;
                last = new Node<>(element);
                last.previous = previousLast;
                previousLast.next = last;
                return true;
            }

            //dodawanie na poczatek listy
            if (nodeAtIndex.previous == null) {
                Node<Integer> previousFirst = first;
                first = new Node<>(element);
                first.next = previousFirst;
                previousFirst.previous = first;
                return true;
            }

            Node<Integer> newNode = new Node<>(element);
            Node<Integer> previous = nodeAtIndex.previous;
            previous.next = newNode;
            newNode.previous = previous;

            newNode.next = nodeAtIndex;
            nodeAtIndex.previous = newNode;
            return true;
        }


    }
public void add_end(int element)
{ if (first == null) {
    first = new Node<>(element);
    last = first;

}
    Node<Integer> previousLast = last;
    Node temp = new Node<>(element);
    last = temp;
    last.previous = previousLast;
    previousLast.next = last;
    size++;
}
    public void print()
    {
        Node<Integer> node = first;
        System.out.println("Elementy list: ");
        for (int i=0;i<size;i++){
            System.out.print(node.element + " ");
            node = node.next;
        }
    }

    public int remove(int index) {
        if (index >size) {
            throw new IndexOutOfBoundsException("Index " + index);
        }
        Node<Integer> nodeToRemove = getNode(index);
        Node<Integer> previousNode = nodeToRemove.previous;
        Node<Integer> nextNode = nodeToRemove.next;
        int removedElement = nodeToRemove.element;
        size--;
        //usuwanie z poczatku
        if (previousNode == null) {
            if (nextNode == null) {
                first = null;
                last = null;
            }
            else {
                first = nextNode;
                nextNode.previous = null;
            }
            return removedElement;
        }

        // usuwanie z konca
        if (nextNode == null) {
            last = previousNode;
            previousNode.next = null;
            return removedElement;
        }

        previousNode.next = nextNode;
        nextNode.previous = previousNode;

        return removedElement;
    }

    void random(int test, int max)
    {
        Random generator = new Random();
        for (int i=0;i<test;i++)
            this.add_end(generator.nextInt(max));
    }

}


