package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Peli {
    
    public KPSPelaajaVsPelaaja(Scanner scanner, Tuomari tuomari) {
        super(scanner, tuomari);
    }
    
    @Override
    String toisenPelaajanSiirto(String toinenSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    

}
