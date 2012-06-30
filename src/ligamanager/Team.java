package ligamanager;

import java.io.Serializable;

/**
 * Representiert eine Mannschaft
 * 
 * @author Nikolas von Randow
 * @version 1.0
 */
public class Team implements Serializable, Comparable<Team> {
	
	private String name, stadion;
	private int punkte;
	
	public Team(String name, String stadion) {
		this.name = name;
		this.stadion = stadion;
	}
	
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	
	public int getPunkte() {
		return punkte;
	}
	
	public String getStadion() {
		return stadion;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public int compareTo(Team t) {
		return -1; // TODO
	}
}
