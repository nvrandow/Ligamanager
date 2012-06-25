package ligamanager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import ligamanager.Pair;
import ligamanager.Pair;
import ligamanager.Utils;
import ligamanager.Utils;

/**
 * Testklasse f&uuml;r Utils
 *
 * @author Nikolas von Randow
 * @version 1.0
 */
public class UtilsTest {

	public static void main(String[] args) {
		ArrayList<Pair<String>> list = new Utils<String>().allPairs(new String[]{"a", "b", "c", "d", "e"});
		for(Pair<String> p : list)
			System.out.println(p);

		try{
			for(String s : Utils.nextSaturdays("11.02.12", 6))
				System.out.println(s);
		}
		catch(ParseException ex){
			System.err.println(ex);
		}

		ArrayList<String> referees = new ArrayList<String>();
		referees.addAll(Arrays.asList("Thomas", "Frank", "Petrov", "von Randow", "Schwaiger", "Freytag"));
		referees = new Utils().mix(referees);
		for(String s : referees)
			System.out.println(s);
	}

}
