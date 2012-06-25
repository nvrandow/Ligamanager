package ligamanager;

import java.io.File;

public class Bundesliga {

	public static void main(String[] args) {
		if(new File("data.ser").exists()){
		}
		else{
			// Bundesliga starten (Spielplan erstellen)
			Saison saison = new Saison(
				new Team[]{
					new Team("FC Augsburg", "SGL arena"),
					new Team("Hertha BSC", "Olympiastadion Berlin"),
					new Team("SV Werder Bremen", "Weser-Stadion"),
					new Team("Borussia Dortmund", "SIGNAL IDUNA PARK"),
					new Team("SC Freiburg", "MAGE SOLAR Stadion"),
					new Team("Hamburger SV", "Imtech Arena"),
					new Team("Hannover 96", "AWD-Arena"),
					new Team("TSG 1899 Hoffenheim", "Rhein-Neckar-Arena"),
					new Team("1. FC Kaiserslautern", "FRITZ-WALTER-STADION"),
					new Team("1. FC Köln", "RheinEnergieStadion"),
					new Team("Bayer 04 Leverkusen", "BayArena"),
					new Team("1. FSV Mainz 05", "Coface Arena"),
					new Team("Borussia Mönchengladbach", "BORUSSIA-PARK"),
					new Team("FC Bayern München", "Allianz Arena"),
					new Team("1. FC Nürnberg", "EasyCredit-Stadion"),
					new Team("FC Schalke 04", "VELTINS-Arena"),
					new Team("VfB Stuttgart", "Mercedes-Benz-Arena"),
					new Team("VfL Wolfsburg", "Volkswagen Arena")
				},
				new String[]{
					"Dr. Felix Brych",
					"Florian Meyer",
					"Wolfgang Stark",
					"Thorsten Kinhöfer",
					"Deniz Aytekin",
					"Manuel Gräfe",
					"Knut Kircher",
					"Günter Perl",
					"Peter Gagelmann",
					"Felix Zwayer",
					"Michael Weiner",
					"Tobias Welz",
					"Guido Winkmann",
					"Marco Fritz",
					"Peter Sippel",
					"Markus Schmidt",
					"Christian Dingert",
					"Dr. Jochen Drees",
					"Robert Hartmann",
					"Markus Wingenbach",
					"Babak Rafati",
					"Tobias Stieler"
				},
				new String[]{
					"Sa 15:30",
					"Sa 17:30",
					"So 18:30",
					"So 20:30"
				}
			);
		}
	}

}
