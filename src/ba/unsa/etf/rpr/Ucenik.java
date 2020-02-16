package ba.unsa.etf.rpr;

public class Ucenik extends Osoba implements Comparable<Ucenik> {
    private String brojKnjizice="";
    private int[] ocjene = new int[100];
    private int brojOcjena=0;

    public Ucenik(String imePrezime) {
        super(imePrezime);
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String brojKnjizice) {
        this.brojKnjizice = brojKnjizice;
    }

    public int getBrojOcjena() {
        return brojOcjena;
    }

    public void dodajOcjenu(int ocjena) throws IlegalnaOcjena {
        if(brojOcjena==100){
            throw new IllegalArgumentException("Dosegnut maksimalni broj ocjena");
        }
        if(ocjena<1 || ocjena>5){
            throw new IlegalnaOcjena("Ilegalna ocjena " + ocjena);
        }
        ocjene[brojOcjena]=ocjena;
        brojOcjena++;
    }

    public double prosjek() {
        if(brojOcjena==0){
            return 0;
        }
        double suma=0;
        for(int i=0; i<brojOcjena; i++){
            suma+=ocjene[i];
        }
        return suma/brojOcjena;
    }

    @Override
    public int compareTo(Ucenik o) {
        if(prosjek()>o.prosjek()){
            return -1;
        }
        return 1;
    }
}
