public class Main
{
    public static void main(String[] args)
    {


        BazaLudnosci base = new BazaLudnosci();
        base.add(new Obywatel("12312451","mat","kowalski"));
        base.add(new Obywatel("121231111","adax","polak"));
        base.add(new Obywatel("1666","aaaa","meh"));
        base.add(new Obywatel("777","babab","cygan"));
        base.print();
        System.out.println();

        System.out.println("Szukam pesel 1666");
        long start = System.nanoTime();
        Obywatel o = base.find("PESEL", "1666");
        long finish = System.nanoTime();
        if (o != null) {
            o.print();
        }
        System.out.println("Time elapsed [ns]: " + (finish - start));


    }

}

/**
 * class representing "Obywatel"
 */
class Obywatel
{
    /**
     * number of instances
     */
    static int counter = 0;
    /**
     * String pesel
     */
    private final String _pesel;
    /**
     * String name
     */
    private final String _name;
    /**
     * String surname
     */
    private final String _surname;

    /**
     * Constructor
     */
    Obywatel(String pesel, String name, String surname) {
        counter++;
        _pesel = pesel;
        _name = name;
        _surname = surname;
    }
    String getPESEL()
    {
        return _pesel;
    }
    String getname()
    {
        return _name;
    }
    String getsurname()
    {
        return _surname;
    }

    /**
     * printer for Obywatel
     */
    void print() {
        System.out.println("Name: " + _name + " " + _surname + ", PESEL: " +_pesel);
    }

}

/**
 * class representing node of binary tree
 */
class Node
{
    /**
     * actual element
     */
    private Obywatel root;
    /**
     * left child
     */
    private Node leftChild;
    /**
     * right child
     */
    private Node rightChild;

    /**
     * Function adds new element to tree
     * @param o
     */
    void add(Obywatel o)
    {
        if(root == null)
        {
            root = o;
            leftChild = new Node();
            rightChild = new Node();
        }
        else if (o.getPESEL().equals(root.getPESEL()))
        {
            System.out.println("Pesel nie jest unikalny");
        }
        else if(o.getPESEL().hashCode() > root.getPESEL().hashCode())
        {
            leftChild.add(o);
        }
        else
        {
            rightChild.add(o);
        }
    }

    /**
     * printer for tree
     * @param sp
     */
    void print(int sp)
    {
        if(root != null)
        {
            for(int i = 0; i<sp; i++)
            {
                System.out.println(" ");
            }
            root.print();
            leftChild.print(sp);
            rightChild.print(sp);
        }
    }

    /**
     * Function which finds node with given value
     * @param nr value
     */
    Obywatel findByPESEL(String nr) {
        if (root == null) {
            return null;
        } else if (root.getPESEL().equals(nr)) {
            return root;
        } else if (nr.hashCode() > root.getPESEL().hashCode()) {
            return leftChild.findByPESEL(nr);
        } else {
            return rightChild.findByPESEL(nr);
        }
    }

    /**
     * Function which finds node with given name/surname
     * @param name
     * @param myName
     */
    Obywatel findByName(String name, boolean myName) {
        if (root != null)
        {
            if ((root.getname().equals(name) && myName) || (root.getsurname().equals(name) && !myName))
            {
                return root;
            }
            else
            {
                if (leftChild.findByName(name, myName) != null)
                {
                    return leftChild.findByName(name, myName);
                }

                if (rightChild.findByName(name, myName) != null)
                {
                    return rightChild.findByName(name, myName);
                }
            }
        }
        return null;
    }

}

/**
 * class representing binary tree
 */
class BazaLudnosci {

    /**
     * root of the tree
     */
    private final Node root = new Node();

    /**
     * function inserting new element to tree
     * @param o
     */
    void add(Obywatel o) {
        root.add(o);
    }

    /**
     * function printing
     */
    void print() {
        System.out.println("Printing whole base:\n");
        root.print(0);
    }

    /**
     * Function to find node by given value
     * @param key
     * @param value
     * @return
     */
    Obywatel find(String key, String value) {
        return switch (key) {
            case "NAME" -> root.findByName(value, true);
            case "SURNAME" -> root.findByName(value, false);
            case "PESEL" -> root.findByPESEL(value);
            default -> null;
        };
    }
}