public class Konto {

    private String id;
    private Kwota kwota;

    public String getID()
    {
        return this.id;
    }
    Konto(String id, Kwota kwota)
    {
        this.id = id;
        this.kwota = kwota.Copy(0);
    }

    public String toString()
    {
        return "[" + id + "]" + kwota;
    }
    public Kwota getStan()
    {
        return kwota.Copy(0);
    }
    public void setStan(Kwota kwota)
    {
        this.kwota = kwota;
    }

    public void changeAccState(Kwota kwota, Boolean bool)
    {
        if(bool)
        {
            this.kwota = Kwota.dodaj(this.kwota, kwota);
        }
        else
        {
            this.kwota = Kwota.odejmij(this.kwota, kwota);
        }
    }

}
