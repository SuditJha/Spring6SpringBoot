package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.CricketMatch;
import com.bean.Player;

public class CricketDAO {

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void allocatePlayertoMatch(int matchId, int playerId) {
		Transaction tx = session.beginTransaction();
		Player player = session.get(Player.class, playerId);
		CricketMatch match = session.get(CricketMatch.class, matchId);
		match.getPlayers().add(player);
		session.save(match);
		tx.commit();
	}
}