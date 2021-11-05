class Node
{
    Konto stored;
    Node next;
}

public class Bank {
    private final Node root;
    Bank()
    {
        root = new Node();
    }
    public void utworzKonto(String id)
    {
        Node temp = root;
        while(temp.stored != null)
        {
            temp = temp.next;
        }
        temp.stored = new Konto(id, new Kwota(0,0));
        temp.next = new Node();
    }
    public String toString()
    {
        String tempStr = "";
        Node current = root;
        while(current.stored != null)
        {
            tempStr += current.stored + " ;";
            current = current.next;
        }
        return tempStr;
    }
    public void wplataNaKonto(String id, Kwota kwota)
    {
        changeState(id,kwota, true);
    }

    public void changeState(String id, Kwota kwota, Boolean bool)
    {
        Node temp = root;
        while(temp.stored !=null && !temp.stored.getID().equals(id))
        {
            temp = temp.next;
        }
        if(temp.stored != null)
        {
            temp.stored.changeAccState(kwota, bool);
        }
    }

    public void wyplataZKonta(String id, Kwota kwota) {
        changeState(id, kwota, false);
    }


    public Kwota stanKonta(String id) {

        Node current = root;

        while (current.stored != null && !current.stored.getID().equals(id)) {
            current = current.next;
        }

        if (current.stored != null) {
            return current.stored.getStan();
        } else {
            return null;
        }
    }
}

