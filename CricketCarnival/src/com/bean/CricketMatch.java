package com.bean;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CricketMatch")
public class CricketMatch {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int matchId;
	private String matchName;
	private Date matchDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "CricketMatch_Player", joinColumns = { @JoinColumn(name = "cricketmatch_matchId") }, inverseJoinColumns = { @JoinColumn(name = "players_playerid") })
	private Set<Player> players = new HashSet<Player>();

	// Getters and Setters
	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
}