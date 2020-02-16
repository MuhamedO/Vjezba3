package ba.unsa.etf.rpr;

public class Srednjoskolac extends Ucenik implements Slavljenik{
    private int[] ocjeneSrednja = new int[100];
    private int brojOcjenaSrednja=0;

    public Srednjoskolac(String imePrezime) {
        super(imePrezime);
    }

    public void dodajOcjenuSrednja(int ocjena) throws IlegalnaOcjena {
        if(brojOcjenaSrednja==100){
            throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        }
        if(ocjena<1 || ocjena>5){
            throw new IlegalnaOcjena("Ilegalna ocjena " + ocjena);
        }
        ocjeneSrednja[brojOcjenaSrednja]=ocjena;
        brojOcjenaSrednja++;
    }


    public double prosjekSrednja() {
        if(brojOcjenaSrednja==0){
            return 0;
        }
        double suma=0;
        for(int i=0; i<brojOcjenaSrednja; i++){
            suma+=ocjeneSrednja[i];
        }
        return suma/brojOcjenaSrednja;
    }

    @Override
    public double prosjek() {
        int ukupanBrojOcjena=brojOcjenaSrednja+getBrojOcjena();
        if(ukupanBrojOcjena==0){
            return 0;
        }
        double ukupnaSumaOcjena = super.prosjek()*getBrojOcjena()+prosjekSrednja()*brojOcjenaSrednja;
        return ukupnaSumaOcjena/ukupanBrojOcjena;
    }

    @Override
    public String toString() {
        String string="";
        string+="Učenik srednje škole " + getImePrezime() + " (" + getBrojKnjizice() + "), " + "prosjek ocjena: ";
        double rezultat= Math.round(prosjek()*10);
        rezultat/=10;
        string+=rezultat;
        return string;
    }
}
