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
	private int punkte, torDifferenz;
	
	public Team(String name, String stadion) {
		this.name = name;
		this.stadion = stadion;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStadion() {
		return stadion;
	}
	
	/**
	 * F&uuml;gt <b>3</b> Punkte f&uuml;r einen Sieg hinzu
	 */
	public void win() {
		addPunkte(3);
	}

	/**
	 * F&uuml;gt <b>1</b> Punkt f&uuml;r ein Unentschieden hinzu
	 */
	public void draw() {
		addPunkte(1);
	}
	
	private void addPunkte(int punkte) {
		this.punkte += punkte;
	}
	
	public int getPunkte() {
		return punkte;
	}
	
	/**
	 * Verrechnet Tordifferenz eines Spieles mit bisheriger
	 * @param torDifferenz
	 */
	public void addTorDifferenz(int torDifferenz) {
		this.torDifferenz += torDifferenz;
	}
	
	public int getTorDifferenz() {
		return torDifferenz;
	}
	
	@Override
	public String toString() {
		return name + " (Stadion: " + stadion + ", Punkte: " + punkte + ", Torfifferenz: " + torDifferenz + ")";
	}
	
	/**
	 * Vergleicht mit anderm Team nach Punkten, dann nach Tordifferenz
	 */
	@Override
	public int compareTo(Team t) {
		if(punkte < t.getPunkte())
			return 1;
		else if(t.getPunkte() < punkte)
			return -1;
		else if(torDifferenz < t.getTorDifferenz())
			return 1;
		else if(t.getTorDifferenz() < torDifferenz)
			return -1;
		return 0;
	}
	
	/**
	 * @return Objekt als String-Array
	 */
	public String[] asJTableRow() {
		return new String[]{name, String.valueOf(punkte), String.valueOf(torDifferenz)};
	}
}
