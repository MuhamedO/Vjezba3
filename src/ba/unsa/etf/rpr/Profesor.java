package ba.unsa.etf.rpr;

public class Profesor extends Nastavnik {

    public Profesor(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        String string="";
        string+="Profesor " + getImePrezime();
        return string;
    }
}
