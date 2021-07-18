import java.io.PrintStream;
import java.util.Random;

public class Tree {
    private Node root;

    class Node {
        private Node left;
        private Node right;
        private Node parent;
        private int key;

        public Node(int key) {
            this.key = key;
            this.right = null;
            this.left = null;
            this.parent = null;
        }

        public Node getLeft()
        {
            return left;
        }

        public void setLeft(Node left)
        {
            this.left = left;
        }

        public Node getRight()
        {
            return right;
        }

        public void setRight(Node right)
        {
            this.right = right;
        }

        public Node getParent()
        {
            return parent;
        }

        public void setParent(Node parent)
        {
            this.parent = parent;
        }

        public int getKey()
        {
            return key;
        }

        public void setKey(int key)
        {
            this.key = key;
        }
    }

    public Node getRoot()
    {
        return root;
    }

    public void setRoot(Node root)
    {
        this.root = root;
    }


    public Node getNode(int key)
    {
        Node current = getRoot();
        while(current != null && current.getKey() != key)
        {
            if(key > current.getKey())
            {
                current = current.getRight();
            }
            else
            {
                current = current.getLeft();
            }
        }

        if(current == null)
        {
            throw new NullPointerException("Nie znaleziono węzła z kluczem " + key);
        }

        return current;
    }
//dodawanie węzła
    public boolean addNode(int key)
    {
        Node parent = null;
        Node current = getRoot();
        while(current != null)
        {
            parent = current;
            if(current.getKey() == key)
            {
                return false;
            }

            if(key > current.getKey())
            {
                current = current.getRight();
            }
            else if(key < current.getKey())
            {
                current = current.getLeft();
            }
        }

        Node tmp = new Node(key);
        if(parent == null)
        {
            setRoot(tmp);
        }
        else if(key > parent.getKey())
        {
            parent.setRight(tmp);
            tmp.setParent(parent);
        }
        else if(key < parent.getKey())
        {
            parent.setLeft(tmp);
            tmp.setParent(parent);
        }
        return true;
    }
//usuwanie węzła
    public void removeNode(int key)
    {
        Node toDelete = getNode(key);
        Node tmp,pred = null;

        if(toDelete.getLeft() == null || toDelete.getRight() == null)
        {
            //usuwamy liść lub element z jednym poddrzewem
            tmp = toDelete;
        }
        else
        {
            //usuwamy węzeł, z dwoma potomkami - szukamy następnika
            tmp = successor(toDelete);
        }

        if(tmp.getLeft() != null)
        {
            pred = tmp.getLeft();
        }
        else
        {
            pred = tmp.getRight();
        }

        if(pred != null)
        {
            pred.setParent(tmp.getParent());
        }

        if(tmp.getParent() == null)
        {
            setRoot(pred);
        }
        else
        {
            if(tmp == tmp.getParent().getLeft())
            {
                tmp.getParent().setLeft(pred);
            }
            else
            {
                tmp.getParent().setRight(pred);
            }
        }

        if(tmp.getKey() != toDelete.getKey())
        {
            toDelete.setKey(tmp.getKey());
        }
    }
//następnik
    public Node successor(Node w)
    {
        if(w.getRight() != null)
        {
            return getMin(w.getRight());
        }

        Node tmp = w.getParent();
        while(w != null && w.getLeft().getKey() != tmp.getKey())
        {
            tmp = w;
            w = w.getLeft();
        }

        return w;
    }
    public Node getMin(Node w)
    {
        Node current = w;
        while(current.getLeft() != null)
        {
            current = current.getLeft();
        }
        return current;
    }

    public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getKey());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("|  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "|_";
            String pointerForLeft = (node.getRight() != null) ? "|--" : "'--";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeft());
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRight());
        }
    }

    public void print(PrintStream os) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", this.root);
        os.print(sb.toString());
    }
    int [] random(int test, int max)
    {
        int rand;
        int temp[] = new int[test];
        Random generator = new Random();
        for (int i=0;i<test;i++)
        {
            rand =generator.nextInt(max);
            this.addNode(rand);
            temp[i]=rand;
        }
    return temp;
    }
}

