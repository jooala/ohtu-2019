/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Joonas
 */
public class Komentokeskus {

    public static class Summa extends Komento {

        int aikaisempiTulos;

        public Summa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus, Komento aikaisempi) {
            super(tuloskentta, syotekentta, nollaa, undo, sovellus, aikaisempi);

        }

        @Override
        public void run() {
            int luku1 = Integer.parseInt(syotekentta.getText());
            sovellus.plus(luku1);

            aikaisempiTulos = Integer.parseInt(tuloskentta.getText());
            int laskunTulos = sovellus.tulos();

            syotekentta.setText("");
            tuloskentta.setText("" + laskunTulos);
            if (laskunTulos == 0) {
                nollaa.setEnabled(false);
            } else {
                nollaa.setEnabled(true);
            }
            undo.setEnabled(true);
        }

        @Override
        public void peru() {
            sovellus.setTulos(aikaisempiTulos);
            syotekentta.setText("");
            tuloskentta.setText("" + aikaisempiTulos);

        }

    }

    public static class Erotus extends Komento {

        int aikaisempiTulos;

        public Erotus(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus, Komento aikaisempi) {
            super(tuloskentta, syotekentta, nollaa, undo, sovellus, aikaisempi);
        }

        @Override
        public void run() {
            int luku1 = Integer.parseInt(syotekentta.getText());
            sovellus.miinus(luku1);
            aikaisempiTulos = Integer.parseInt(tuloskentta.getText());
            int laskunTulos = sovellus.tulos();

            syotekentta.setText("");
            tuloskentta.setText("" + laskunTulos);
            if (laskunTulos == 0) {
                nollaa.setEnabled(false);
            } else {
                nollaa.setEnabled(true);
            }
            undo.setEnabled(true);
        }

        @Override
        public void peru() {
            sovellus.setTulos(aikaisempiTulos);
            syotekentta.setText("");
            tuloskentta.setText("" + aikaisempiTulos);
        }
    }

    public static class Nollaa extends Komento {

        int aikaisempiTulos;

        public Nollaa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus, Komento aikaisempi) {
            super(tuloskentta, syotekentta, nollaa, undo, sovellus, aikaisempi);
        }

        @Override
        public void run() {
            sovellus.nollaa();

            int laskunTulos = sovellus.tulos();
            aikaisempiTulos = Integer.parseInt(tuloskentta.getText());
            syotekentta.setText("");
            tuloskentta.setText("" + laskunTulos);
            if (laskunTulos == 0) {
                nollaa.setEnabled(false);
            } else {
                nollaa.setEnabled(true);
            }
            undo.setEnabled(true);
        }

        @Override
        public void peru() {
            sovellus.setTulos(aikaisempiTulos);
            syotekentta.setText("");
            tuloskentta.setText("" + aikaisempiTulos);
        }
    }
}
