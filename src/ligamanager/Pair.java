package ligamanager;

/**
 * Speichert 2 Elemente eines beliebigen gleichen Typs
 * 
 * @author Nikolas von Randow
 * @version 1.0
 */
public class Pair<E> {
	
	private E e1, e2;
	
	public Pair(E e1, E e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public E getE1() {
		return e1;
	}
	
	public E getE2() {
		return e2;
	}
	
	@Override
	public String toString() {
		return e1 + ", " + e2;
	}
}
