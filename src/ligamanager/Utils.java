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
	 * Erzeugt alle m&ouml;glichen 2er-Kombinationen aus einer Liste von Objekten
	 * 
	 * @param elements beliebig langes Array
	 * @return Liste von Arrays mit je 2 Elementen (0=>Partner1, 1=>Partner2)
	 */
	public ArrayList<Pair<E>> allPairs(E[] elements) {
		ArrayList<Pair<E>> list = new ArrayList<Pair<E>>();
		for(int i = 0; i < elements.length; i++)
			for(int j = i + 1; j < elements.length; j++)
				// nur elemente danach => nie a-b UND b-a (Rückspiele werden anders gemacht)
				list.add(new Pair<E>(elements[i], elements[j]));
		return list;
	}
	
	/**
	 * Gibt <code>number</code> Samstage ab <code>start</code> zur&uuml;ck
	 * 
	 * @param startSaturday erster Samstage (z. B. 11.02.12)
	 * @param number Anzahl an ben&ouml;tigten Samstagen + Sonntage (bei ungerader Zahl ist letztes Datum ein Samstag)
	 * @return <code>number</code> Samstage + Sonntage, inklusive <code>start</code>
	 * @throws ParseException wenn falsches Format oder <code>start</code> kein Samstag
	 */
	@SuppressWarnings("deprecation")
	public static String[] nextSaturdaysAndSundays(String startSaturday, int number) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
		Date date = sdf.parse(startSaturday);
		long secPerDay = 604800000; // in extra long-Variable => kein int-Überlauf
		long time = date.getTime();
		String[] days = new String[number];
		if(date.getDay() == 6){
			for(int i = 0; i < number / 2 * 2; i += 2){ // "/2*2" => bei ungeraden Zahlen wird nicht versucht einen
														// letzten Sonnatg einzutragen
				days[i] = sdf.format(new Date(time + secPerDay * i / 2));
				days[i + 1] = sdf.format(new Date(time + secPerDay * i / 2 + 86400000));
			}
			if(number % 2 != 0)
				days[number - 1] = sdf.format(new Date(time + secPerDay * (number - 1) / 2));
		}
		else
			throw new ParseException(startSaturday + " is no saturday!", 0);
		return days;
	}
	
	/**
	 * Elemente werden nach dem Zufallsprinzip umsortiert
	 * 
	 * @param src Liste von Elementen beliebigen Typs
	 * @return gemischte Liste
	 */
	public ArrayList<E> mix(ArrayList<E> src) {
		ArrayList<E> dest = new ArrayList<E>(src.size());
		// Solange src nicht lehr ist...
		while(!src.isEmpty())
			// ...wird das Element an einer zufälligen Stelle (zwischen 0 und restlicht Länge von src) entfernt und ans
			// Ende von dest gehängt
			dest.add(src.remove((int) (Math.random() * src.size())));
		return dest;
	}
	
	public static void printStringArray2d(String[][] array) {
		try{
			boolean[] rightAligned = new boolean[array[0].length];
			for(int i = 0; i < rightAligned.length; i++)
				rightAligned[i] = false;
			printStringArray2d(array, rightAligned);
		}
		catch(IllegalArgumentException ex){
		}
	}
	
	/**
	 * 
	 * @param array (Spalten &times; Zeilen)
	 * @param rightAligned gibt f&uuml;r jede Spalte an, ob sie rechts-b&uuml;ndig sein soll (<code>true</code>) oder
	 *        nicht (<code>false</code>)
	 * @throws IllegalArgumentException wenn <code>array</code> und <code>rightAligned</code> nicht gleichlang sind
	 */
	public static void printStringArray2d(String[][] array, boolean[] rightAligned) throws IllegalArgumentException {
		if(array[0].length != rightAligned.length)
			throw new IllegalArgumentException("Column-count has to match align-count!");
		
		int[] maxLen = new int[array[0].length];
		for(int i = 0; i < array[0].length; i++){
			maxLen[i] = Integer.MIN_VALUE;
			for(int j = 0; j < array.length; j++)
				if(maxLen[i] < array[j][i].length())
					maxLen[i] = array[j][i].length();
		}
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(" | ");
				if(!rightAligned[j])
					System.out.print(array[i][j]);
				for(int k = 0; k < maxLen[j] - array[i][j].length(); k++)
					System.out.print(" ");
				if(rightAligned[j])
					System.out.print(array[i][j]);
			}
			System.out.println(" | ");
		}
	}
}
