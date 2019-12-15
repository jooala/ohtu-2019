/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author Joonas
 */
public class KPSTehdas {
    Scanner scanner;
    Tuomari tuomari;
    
    public KPSTehdas(Scanner scanner) {
        Tuomari tuomari = new Tuomari();
        this.scanner = scanner;
    }

    void run() {
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPSPelaajaVsPelaaja moninpeli = new KPSPelaajaVsPelaaja(scanner, tuomari);
                moninpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPSTekoaly yksinpeli = new KPSTekoaly(scanner, tuomari);
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly(scanner, tuomari);
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }
    }
}
