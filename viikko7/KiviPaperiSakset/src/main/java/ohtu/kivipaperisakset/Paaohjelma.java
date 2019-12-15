package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        KPSTehdas tehdas = new KPSTehdas(scanner);
        tehdas.run();

    }
}
