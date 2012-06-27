package ligamanager;

import java.io.Serializable;

public class Team implements Serializable {

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

}
