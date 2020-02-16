package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class Skola {
    private List<Osoba> osobe = new ArrayList<>();
    private int brojOsoba=0;

    public void dodajOsobu(Osoba osoba) {
        osobe.add(osoba);
        brojOsoba++;
    }

    @Override
    public String toString() {
        String string="";
        for(int i=0; i<brojOsoba; i++){
            string+=osobe.get(i) + "\n";
        }
        return string;
    }

    public Set<Ucenik> ucenici() {
        Set<Ucenik> skup = new TreeSet<>();
        for(Osoba o: osobe){
            if(o instanceof Ucenik){
                skup.add((Ucenik) o);
            }
        }
        return skup;
    }

    public List<Osoba> filtriraj(Function<Osoba, Boolean> funkcija) {
        List<Osoba> lista = new ArrayList<>();
        for(Osoba o: osobe){
            if(funkcija.apply(o)){
                lista.add(o);
            }
        }
        return lista;
    }

    public List<Osnovac> topOsnovac() {
        List lista = filtriraj((Osoba o) -> {if(o instanceof Osnovac && ((Osnovac) o).prosjek()>=4) return true; return false;});
        return lista;
    }


    public List<Slavljenik> slavljenici() {
        List<Slavljenik> lista=new ArrayList<>();
        for(Osoba o: osobe){
            if(o instanceof Slavljenik){
                lista.add((Slavljenik) o);
            }
        }
        return lista;
    }
}
