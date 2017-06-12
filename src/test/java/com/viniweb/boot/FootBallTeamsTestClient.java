package com.viniweb.boot;
 
import java.net.URI;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.viniweb.boot.model.Team; 

public class FootBallTeamsTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/FootBallTeams/api";
     
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllTeams(){
        System.out.println("Testing listAllTeams API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> teamsMap = restTemplate.getForObject(REST_SERVICE_URI+"/teams/", List.class);
         
        if(teamsMap!=null){
            for(LinkedHashMap<String, Object> map : teamsMap){
                System.out.println("Team : id="+map.get("id")+", Name="+map.get("name")+", City="+map.get("city")+", "
                		+ " Owner="+map.get("owner") +", Stadium Capacity="+map.get("stadiumCapacity")
                		+", Competition="+map.get("competition")+", NumberOfPlayers="+map.get("numberOfPlayers")
                		+ ", Date Of Creation="+map.get("dateOfCreation") );            
            }
        }else{
            System.out.println("No team exist----------");
        }
    }
     
    /* GET team by name*/
    private static void getTeam(){
        System.out.println("Testing getTeam API----------");
        RestTemplate restTemplate = new RestTemplate();
        Team team = restTemplate.getForObject(REST_SERVICE_URI+"/team/ManchesterUnited", Team.class);
        System.out.println(team);
    }
     
    /* POST */
    private static void createTeam() {
        System.out.println("Testing create Team API----------");
        RestTemplate restTemplate = new RestTemplate();      
        Team team = new Team(0,"Team1","City1", "Owner1", 50000, "UEFA",20, "10-09-2012");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/team/", team, Team.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    public static void main(String args[]){
        listAllTeams();
        getTeam();
        createTeam();
        listAllTeams();     
    }
}