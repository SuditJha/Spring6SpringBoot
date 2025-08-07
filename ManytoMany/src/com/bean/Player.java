package com.bean;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int playerId;
	private String playerName;
	private int runsScored;

	@ManyToMany(mappedBy = "players")
	private Set<CricketMatch> matches = new HashSet<CricketMatch>();


	public Set<CricketMatch> getMatches() {
		return matches;
	}
	public void setMatches(Set<CricketMatch> matches) {
		this.matches = matches;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
}