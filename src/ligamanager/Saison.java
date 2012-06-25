package ligamanager;

import java.util.ArrayList;
import java.util.Arrays;

public class Saison {

	private Team[] teams;
	private ArrayList<String> schiedsrichter;
    private String[] anstossZeiten;

	public Saison(Team[] teams, String[] schiedsrichter, String[] anstossZeiten) {
		this.teams = teams;
		this.schiedsrichter = Utils.mix(new ArrayList(Arrays.asList(schiedsrichter)));
		this.anstossZeiten = anstossZeiten;

		ArrayList<Pair<Team>> pairs = null;

		boolean unsolved = true;
		while(unsolved){
			unsolved = false;

			int aktuellesI = 0, keineVeraenderungSeit = 0;

			pairs = Utils.mix(new Utils<Team>().allPairs(teams));
			ArrayList spielenDiesesWeSchon = new ArrayList(anstossZeiten.length);
			for(int i=0; i<pairs.size(); i++){

				// Wenn alle verbleibenden Elemente für aktuellen Platz durchprobiert wurden, wird ganz von forn angefangen
				if(keineVeraenderungSeit == pairs.size()-1-i){
					unsolved = true;
					break;
				}
				if(i == aktuellesI)
					keineVeraenderungSeit++;
				else{
					aktuellesI = i;
					keineVeraenderungSeit = 0;
				}

				// Wenn der Zähler durch die Anzahl an Spielen pro WE teilbar ist, "spielenDiesesWeSchon" lehren	
				if(i%anstossZeiten.length == 0)
					spielenDiesesWeSchon.clear();
				// Wenn schon gespielt...
				if(spielenDiesesWeSchon.contains(pairs.get(i).getE1()) || spielenDiesesWeSchon.contains(pairs.get(i).getE2())){
					// ...herausnehmen und hinten anstellen
					pairs.add(pairs.remove(i));
					i--; // nachgerutschtes Element nicht auslassen
				}
				// Sonst Teams zu Schon-Gespielt-Liste hinzufügen
				else{
					spielenDiesesWeSchon.add(pairs.get(i).getE1());
					spielenDiesesWeSchon.add(pairs.get(i).getE2());
				}
			}
		}

		Begegnung[] begegnungen = new Begegnung[pairs.size()];//*2
		for(int i=0; i<begegnungen.length; i++){
			Pair<Team> p = pairs.get(i);//%pairs.size()
                // anstossZeiten[i%anstossZeiten.length]
               // schiedsrichter[i%schiedsrichter.length]   Turnus
			begegnungen[i] = new Begegnung(anstossZeiten[i%anstossZeiten.length], p.getE1(), p.getE2(), this.schiedsrichter.get(i%this.schiedsrichter.size()), true);//i<pairs.size()-1
		}

		String[][] data = new String[begegnungen.length][9];
		for(int i=0; i<data.length; i++)
			data[i] = begegnungen[i].asJTableRow();

		MyUtil.printStringArray2d(data, new boolean[]{false, false, false, false, true, false, false, false, false});
	}

}
