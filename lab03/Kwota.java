
public class Kwota {

    private int gr;

    private int getZl() {
        return gr / 100;
    }

    private int getGr() {
        return gr % 100;
    }

    Kwota(int zl, int gr) {
        set(zl, gr);
    }

    public String toString() {
        return getZl() + "zl " + getGr() + "gr";
    }


    public Kwota Copy(int agr) {
        return new Kwota(0, this.gr + agr);
    }


    public static Kwota dodaj(Kwota k1, Kwota k2) {
        return k1.Copy(k2.gr);
    }


    public static Kwota odejmij(Kwota k1, Kwota k2) {
        return k1.Copy(-k2.gr);
    }

    public void set(int zl, int gr) {
        this.gr = zl * 100 + gr;
    }

}