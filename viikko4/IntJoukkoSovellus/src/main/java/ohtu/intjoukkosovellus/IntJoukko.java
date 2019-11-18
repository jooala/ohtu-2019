
package ohtu.intjoukkosovellus;

import org.checkerframework.checker.units.qual.radians;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alustaLukujono(KAPASITEETTI);
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustaLukujono(kapasiteetti);
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        alustaLukujono(kapasiteetti);
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            lukujono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if(LuvunLisaysJosEiKuuluJoJoukkoon(luku) == true) {
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        int onMukana = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                onMukana++;
            }
        }
        if (onMukana > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                lukujono[kohta] = 0;
                break;
            }
        }
        if(LuvunPoistoJoukosta(luku, kohta) == true) {
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            String joukko = SuurempiJoukkoTekstiksi();
            return joukko;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko uusiTaulu = JoukonLisääminenUuteenJoukkoon(a);
        int[] tokaTaulu = b.toIntArray();
        for (int i = 0; i < tokaTaulu.length; i++) {
            uusiTaulu.lisaa(tokaTaulu[i]);
        }
        return uusiTaulu;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko uusiTaulu = new IntJoukko();
        int[] ekaTaulu = a.toIntArray();
        int[] tokaTaulu = b.toIntArray();
        for (int i = 0; i < ekaTaulu.length; i++) {
            for (int j = 0; j < tokaTaulu.length; j++) {
                if (ekaTaulu[i] == tokaTaulu[j]) {
                    uusiTaulu.lisaa(tokaTaulu[j]);
                }
            }
        }
        return uusiTaulu;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko uusiTaulu = JoukonLisääminenUuteenJoukkoon(a);
        int[] tokaTaulu = b.toIntArray();
        for (int i = 0; i < tokaTaulu.length; i++) {
            uusiTaulu.poista(i);
        }
 
        return uusiTaulu;
    }
    
    public void alustaLukujono(int kapasiteetti) {
        lukujono = new int[kapasiteetti];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenLkm = 0;
    }
    
    public static IntJoukko JoukonLisääminenUuteenJoukkoon( IntJoukko a) {
        IntJoukko uusiTaulu = new IntJoukko();
        int[] ekaTaulu = a.toIntArray();
        for (int i = 0; i < ekaTaulu.length; i++) {
            uusiTaulu.lisaa(ekaTaulu[i]);
        }
        return uusiTaulu;
    }

    public boolean LuvunLisaysJosEiKuuluJoJoukkoon(int luku) {
        if (!kuuluu(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujono.length == 0) {
                int[] taulukkoOld = new int[lukujono.length];
                taulukkoOld = lukujono;
                kopioiTaulukko(lukujono, taulukkoOld);
                lukujono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, lukujono);
            }
            return true;
        }
        return false;
    }
    public boolean LuvunPoistoJoukosta(int luku, int kohta) {
        int apu;
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = lukujono[j];
                lukujono[j] = lukujono[j + 1];
                lukujono[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    public String SuurempiJoukkoTekstiksi() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += lukujono[i];
            tuotos += ", ";
        }
        tuotos += lukujono[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }
}