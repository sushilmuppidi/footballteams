package com.viniweb.boot.service;

import java.util.List;

import com.viniweb.boot.model.Team;

public interface TeamService {	
	
	/*
	 * Get a list of all Teams in JSON format 
	 */
	List<Team> findAllTeams();
	
	/*
	 * Get a list of teams sorted by their stadium capacity.
	 */
	List<Team> findTeamsByStadiumCapaticy();
	
	/*
	 * Get the details of a specific Team in JSON format
	 */
	Team findByName(String name);
	
	/*
	 * 
	 */
	void saveTeam(Team team);
	
	boolean isTeamExist(Team team);	
	
}
