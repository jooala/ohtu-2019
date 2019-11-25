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
public abstract class Komento {
    protected Sovelluslogiikka sovellus;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected JButton nollaa;
    protected JButton undo;
    protected Komento aikaisempi;
    
    public Komento(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus, Komento aikaisempi) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.aikaisempi = aikaisempi;
    }
    
    public abstract void run();
    
    public abstract void peru();
}
