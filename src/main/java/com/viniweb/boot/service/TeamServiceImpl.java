package com.viniweb.boot.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.viniweb.boot.model.Team;


@Service("teamService")
public class TeamServiceImpl implements TeamService{
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<Team> teams;
	
	static{
		teams= populateTeams();
	}

	public List<Team> findAllTeams() {						
		return teams;
	}
	
	public List<Team> findTeamsByStadiumCapaticy() {		
		//sort by StadiumCapacity
		Collections.sort(teams, new Comparator<Team>() {
		@Override
			public int compare(Team o1, Team o2) {
				return o1.getStadiumCapacity() - o2.getStadiumCapacity();
			}
		});				
		return teams;
	}
	
	public Team findByName(String name) {
		for(Team team : teams){
			if(team.getName().equalsIgnoreCase(name)){
				return team;
			}
		}
		return null;
	}
	
	public void saveTeam(Team team) {
		team.setId(counter.incrementAndGet());
		teams.add(team);
	}
	
	public boolean isTeamExist(Team team) {
		return findByName(team.getName())!=null;
	}
	
	
	private static List<Team> populateTeams(){
		
		List<Team> teams = new ArrayList<Team>();			
		teams.add(new Team(counter.incrementAndGet(),"ManchesterUnited","Manchester","Tom",85000,"UEFA",25, "01-03-2016"));	
		teams.add(new Team(counter.incrementAndGet(),"WestHamUnited","WestHam","Paul",68000,"UEFA",25, "11-02-2014"));		
		teams.add(new Team(counter.incrementAndGet(),"LiverpoolUnited","Liverpool","Mathew",78000,"UEFA",24, "01-12-2011"));	
		teams.add(new Team(counter.incrementAndGet(),"Chelsea","London","Chris",56000,"EU",26, "04-05-2001"));	
		return teams;
	}
	
	private static Date getDate(String dateStr){
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
		String input = dateStr;
		Date date = null;
		try {
			date = sdfIn.parse(input);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
        return date;
	}

	
}