package ligamanager;

public class Begegnung {

	private String datum, anpfiff, schiedsrichter;
	private Team t1, t2;
	private boolean hinrunde;
	private int score1, score2;

	public Begegnung(String anpfiff, Team t1, Team t2, String schiedsrichter, boolean hinrunde) {
		this.datum = "25.06.2012";
		this.anpfiff = anpfiff;
		this.t1 = t1;
		this.t2 = t2;
		this.schiedsrichter = schiedsrichter;
		this.hinrunde = hinrunde;
		score1 = 0;
		score2 = 0;
	}

	public void setResults(int score1, int score2) {
		this.score1 = score1;
		this.score2 = score2;
	}

	public String[] asJTableRow() {
		return new String[]{hinrunde?"H":"R", datum, anpfiff, t1.getStadion(), t1.toString(), String.valueOf(score1), String.valueOf(score2), t2.toString(), schiedsrichter};
	}

}
