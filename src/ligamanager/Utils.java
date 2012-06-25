package ligamanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Hilfsklasse f&uuml;r Fu&szligball-Bundesliga-Projekt
 *
 * @author Nikolas von Randow
 * @version 1.0
 */
public class Utils<E> {

	/**
	 * Erzeigt alle m&ouml;glichen 2er-Kombinationen aus einer Liste von Objekten
	 *
	 * @param elements beliebig langes Array
	 * @return Liste von Arrays mit je 2 Elementen (0=>Partner1, 1=>Partner2)
	 */
	public ArrayList<Pair<E>> allPairs(E[] elements) {
		ArrayList<Pair<E>> list = new ArrayList<Pair<E>>();
		for(int i=0; i<elements.length; i++)
			for(int j=i+1; j<elements.length; j++) // nur elemente danach => nie a-b UND b-a (Rückspiele werden anders gemacht)
				list.add(new Pair(elements[i], elements[j]));
		return list;
	}

	/**
	 * Giebt <code>number</code> Samstage ab <code>start</code> zur&uuml;ck
	 *
	 * @param start erster der Samstage (z. B. 11.02.12)
	 * @param number Anzahl an ben&ouml;tigten Samstagen
	 * @return <code>number</code> Samstage, inklusive <code>start</code>
	 * @throws ParseException wenn falsches Format oder <code>start</code> kein Samstag
	 */
	public static String[] nextSaturdays(String start, int number) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
		Date date = sdf.parse(start);
		long time = date.getTime();
		String[] saturdays = new String[number];
		if(date.getDay() == 6){
			for(int i=0; i<number; i++)
				saturdays[i] = sdf.format(new Date(time+604800000*i));
		}
		else
			throw new ParseException(start + " is no saturday!", 0);
		return saturdays;
	}

	/**
	 * Elemente werden nach dem Zufallsprinzip umsortiert
	 * 
	 * @param src generische Liste
	 * @return gemischte Liste
	 */
	public static ArrayList mix(ArrayList src) {
		ArrayList dest = new ArrayList(src.size());
		// Solange src nicht lehr ist...
		while(!src.isEmpty()){
			// ...wird das Element an einer zufälligen Stelle (zwischen 0 und restlicht Länge von src) entfernt und ans Ende von dest gehängt
			dest.add(src.remove((int) (Math.random()*src.size())));
		}
		return dest;
	}

}
