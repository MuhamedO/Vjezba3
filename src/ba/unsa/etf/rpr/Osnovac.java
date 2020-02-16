package ba.unsa.etf.rpr;

public class Osnovac extends Ucenik {

    public Osnovac(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        String string="";
        string+="Učenik osnovne škole " + getImePrezime() + " (" + getBrojKnjizice() + "), " + "prosjek ocjena: ";
        double rezultat= Math.round(prosjek()*10);
        rezultat/=10;
        string+=rezultat;
        return string;
    }
}
