package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Peli{

    TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    public KPSParempiTekoaly(Scanner scanner, Tuomari tuomari) {
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
