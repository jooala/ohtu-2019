package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.text.SimpleDateFormat;  
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
        
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        java.util.Date date=new java.util.Date();   
    
        Arrays.sort(players, Collections.reverseOrder());
        String nationality = "FIN";
        
        System.out.println("Players from " + nationality + " " + date);
        for (Player player : players) {
            if (player.getNationality().equals(nationality)) {
                System.out.println(player);
            }
        }   
    }
  
}