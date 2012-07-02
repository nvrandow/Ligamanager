package ligamanager;

import java.io.Serializable;

/**
 * Kapselt die Daten eines Fu&szlig;ballspiels
 * 
 * @author Nikolas von Randow
 * @version 1.0
 */
public class Begegnung implements Serializable {
	
	private String datum, anpfiff, schiedsrichter;
	private Team t1, t2;
	private boolean hinrunde;
	private int score1, score2;
	
	public Begegnung(String datum, String anpfiff, Team t1, Team t2, String schiedsrichter, boolean hinrunde) {
		this.datum = datum;
		this.anpfiff = anpfiff;
		this.t1 = t1;
		this.t2 = t2;
		this.schiedsrichter = schiedsrichter;
		this.hinrunde = hinrunde;
		score1 = 0;
		score2 = 0;
	}
	
	/**
	 * Ergebnis eintragen
	 * &Auml;ndert <code>torDifferenz</code> der Teams
	 * &Auml;ndert <code>punkte</code> der Teams folgenderma&szlig;en:
	 * <b>0</b> f&uuml;r Niederlage | <b>+1</b> f&uuml;r Unentschieden | <b>+3</b> f&uuml;r Sieg
	 * 
	 * @param score1 Tore, die <code>t1</code> erzielen konnte
	 * @param score2 Tore, die <code>t2</code> erzielen konnte
	 */
	public void setResults(int score1, int score2) {
		this.score1 = score1;
		this.score2 = score2;
		t1.addTorDifferenz(score1-score2);
		t2.addTorDifferenz(score2-score1);
		if(score1 > score2)
			t1.win();
		else if(score2 > score1)
			t2.win();
		else{
			t1.draw();
			t2.draw();
		}
	}
	
	/**
	 * @return Objekt als String-Array
	 */
	public String[] asJTableRow() {
		return new String[]{hinrunde ? "H" : "R", datum, anpfiff, t1.getStadion(), t1.getName(), String.valueOf(score1), String.valueOf(score2), t2.getName(), schiedsrichter};
	}
}
