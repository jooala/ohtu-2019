/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void StatisticsKonstruktoriOikein() {
        assertEquals(readerStub.getPlayers().get(0).getName(), "Semenko");
    }
    
    @Test
    public void SearchToimiiOikein() {
        Player eiLoydy = stats.search("Selänne");
        assertEquals(eiLoydy, null);
        Player Loytyi = stats.search("Kurri");
        assertEquals(Loytyi.getName(), "Kurri");
    }
    
    @Test
    public void TeamToimiiOikein() {
        String eiOlemassaTiimi = "EIP";
        List<Player> eiTiimi = stats.team(eiOlemassaTiimi);
        assertTrue(eiTiimi.isEmpty());
        
        String onOlemassaTiimi = "EDM";
        List<Player> onTiimi = stats.team(onOlemassaTiimi);
        assertEquals(onTiimi.get(0).getName(), "Semenko");
        
    }
    
    @Test
    public void topScorersToimiiOikein() {
        int maara = -1;
        List<Player> EiYhtaan = stats.topScorers(maara);
        assertTrue(EiYhtaan.isEmpty());
        
        maara = 4;
        List<Player> Topmaalit = stats.topScorers(maara);
        assertEquals(Topmaalit.get(0).getName(), "Gretzky");
    }
}
