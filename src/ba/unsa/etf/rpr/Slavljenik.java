package ba.unsa.etf.rpr;

import java.time.LocalDate;

public interface Slavljenik {
    default String rodjendan(LocalDate datumRodjenja){
        String string="";
        if(datumRodjenja.getDayOfMonth()==LocalDate.now().getDayOfMonth() && datumRodjenja.getMonth()==LocalDate.now().getMonth()){
            string+="Sretan rodjendan!";
        }
        return string;
    }
}
