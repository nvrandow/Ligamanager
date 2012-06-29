package ligamanager;

public class MyUtil {

	/**
	 * Ausgabe eines 2d-String-Arrays als Tabelle, wobei die Spalten jeweils so
	 * breit wie ihr l&auml;ngstes Element sind
	 *
	 * @param array (Spalten &times; Zeilen)
	 */
	public static void printStringArray2d(String[][] array) {
		try {
			boolean[] rightAligned = new boolean[array[0].length];
			for (int i = 0; i < rightAligned.length; i++) {
				rightAligned[i] = false;
			}
			printStringArray2d(array, rightAligned);
		} catch (IllegalArgumentException ex) {
		}
	}

	/**
	 *
	 * @param array (Spalten &times; Zeilen)
	 * @param rightAligned gibt f&uuml;r jede Spalte an, ob sie
	 * rechts-b&uuml;ndig sein soll (
	 * <code>true</code>) oder nicht (
	 * <code>false</code>)
	 * @throws IllegalArgumentException wenn
	 * <code>array</code> und
	 * <code>rightAligned</code> nicht gleichlang sind
	 */
	public static void printStringArray2d(String[][] array, boolean[] rightAligned) throws IllegalArgumentException {
		if (array[0].length != rightAligned.length) {
			throw new IllegalArgumentException("Column-count has to match align-count!");
		}

		int[] maxLen = new int[array[0].length];
		for (int i = 0; i < array[0].length; i++) {
			maxLen[i] = Integer.MIN_VALUE;
			for (int j = 0; j < array.length; j++) {
				if (maxLen[i] < array[j][i].length()) {
					maxLen[i] = array[j][i].length();
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(" | ");
				if (!rightAligned[j]) {
					System.out.print(array[i][j]);
				}
				for (int k = 0; k < maxLen[j] - array[i][j].length(); k++) {
					System.out.print(" ");
				}
				if (rightAligned[j]) {
					System.out.print(array[i][j]);
				}
			}
			System.out.println(" | ");
		}
	}
}
