
package ohtu;

import java.util.Collections;

public class Player implements Comparable<Player>{
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;
    private int sum;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setNationality() {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public String getTeam() {
        return this.team;
    }
    
    public int getGoals() {
        return this.goals;
    }
    
     public int getAssists() {
        return this.assists;
    }
    
    public String getPlayersByPoints() {
        
        String list = String.format("%20s %3s %2s +%3s =%3s", getName(), getTeam(), getGoals(), getAssists(), getPoints());
        return list;
    }
    @Override
    public String toString() {
        return getPlayersByPoints();
    }

    @Override
    public int compareTo(Player o) {
        if(this.getPoints() > o.getPoints()) {
            return 1;
        } else if (this.getPoints() == o.getPoints()) {
            return 0;
        } else {
            return -1;
        }
    }
    
    public int getPoints() {
        int sum = goals + assists;
        return sum;
    }
}
