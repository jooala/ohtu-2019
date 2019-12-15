package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Peli {

    Tekoaly tekoaly = new Tekoaly();

    public KPSTekoaly(Scanner scanner, Tuomari tuomari) {
        super(scanner, tuomari);
    }
    
    @Override
    String toisenPelaajanSiirto(String toinenSiirto) {
        String tekoalySiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tekoalySiirto);
        tekoaly.asetaSiirto(toinenSiirto);
        return toinenSiirto;
    }
}
