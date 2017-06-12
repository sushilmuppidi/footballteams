package com.viniweb.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.viniweb.boot.model.Team;
import com.viniweb.boot.service.TeamService;
import com.viniweb.boot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class FootBallTeamsController {

	public static final Logger logger = LoggerFactory.getLogger(FootBallTeamsController.class);	
	@Autowired
	TeamService teamService; 
	
	/*
	 * Retrieve all teams
	 */
	@RequestMapping(value = "/teams/", method = RequestMethod.GET)
	public ResponseEntity<List<Team>> listAllTeams() {
		List<Team> teams = teamService.findAllTeams();
		if (teams.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);			
		}
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}
	
	/*
	 *  Retrieve teams by stadium capacity
	 */
	@RequestMapping(value = "/teambystadiumcapacity/", method = RequestMethod.GET)
	public ResponseEntity<List<Team>> listTeamsByStadiumCapacity() {
		List<Team> teams = teamService.findTeamsByStadiumCapaticy();
		if (teams.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);			
		}
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}
	
	/*
	 * Retrieve team
	 */
	@RequestMapping(value = "/team/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getTeam(@PathVariable("name") String name) {
		logger.info("Fetching Team with name {}", name);
		Team team = teamService.findByName(name);
		if (team == null) {
			logger.error("Team with name {} not found.", name);
			return new ResponseEntity(new CustomErrorType("Team with name " + name 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Team>(team, HttpStatus.OK);
	}
	
	/*
	 * Create a Team
	 */
	@RequestMapping(value = "/team/", method = RequestMethod.POST)
	public ResponseEntity<?> createTeam(@RequestBody Team team, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Team : {}", team);
		if (teamService.isTeamExist(team)) {
			logger.error("Unable to create. Team with name {} already exist", team.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. Team with name " + 
			team.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		teamService.saveTeam(team);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/team/{id}").buildAndExpand(team.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}		
}