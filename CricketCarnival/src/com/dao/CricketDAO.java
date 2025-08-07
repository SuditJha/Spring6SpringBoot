package com.dao;

import org.hibernate.Session;
import com.bean.CricketMatch;

public class CricketDAO {

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public CricketMatch viewMatchwithPlayerDetails(int matchId) {
		CricketMatch match = session.get(CricketMatch.class, matchId);
		return match;
	}
}