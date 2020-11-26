package blatt07;

import java.util.*;

/**
 * Implementierung f�r bin�re Suchb�ume
 */
public class SearchTree {

	/************************************************************
	 * TODO TODO zu implementierende Methoden siehe unten TODO
	 ************************************************************/

	private TreeNode root;

	/** Konstruktor erzeugt leeren Baum */
	public SearchTree() {
		root = null;
	}

	/** Pr�ft, ob der Baum leer ist */
	public boolean isEmpty() {
		return (root == null);
	}

	/** Berechnet die H�he des Baums */
	public int height() {
		return height(root);
	}

	private int height(TreeNode r) {
		if (r == null)
			return 0;
		else
			return 1 + Math.max(height(r.left), height(r.right));
	}

	/** berechnet Anzahl der Knoten des Baums */
	public int size() {
		return size(root);
	}

	private int size(TreeNode r) {
		if (r == null) {
			return 0;
		} else {
			return 1 + size(r.left) + size(r.right);
		}
	}

	/**
	 * F�gt einen neuen Knoten mit Wert v in den Baum ein, falls v noch nicht
	 * enthalten ist
	 */
	public boolean insert(int v) {
		if (root == null) {
			// Baum war bisher leer
			root = new TreeNode(v);
			return true; // erfolgreich eingef�gt
		} else {
			// Wert v in den nicht leeren Baum mit Wurzel root einf�gen
			return insertRek(root, v);
		}
	}

	/**
	 * rekursive Methode, um den Wert v in den Suchbaum mit der Wurzel r einzuf�gen
	 */
	private boolean insertRek(TreeNode r, int v) {
		if (v < r.info) {
			if (r.left == null) {
				r.left = new TreeNode(v);
				return true;
			} else {
				return insertRek(r.left, v);
			}
		} else if (v > r.info) {
			if (r.right == null) {
				r.right = new TreeNode(v);
				return true;
			} else {
				return insertRek(r.right, v);
			}
		} else // (v == r.info)
			return false; // Wert war bereits vorhanden

	}

	/**
	 * sucht im Baum nach dem Knoten mit dem Wert v
	 * 
	 * @return Referenz auf Knoten, falls Suche erfolgreich und null-Referenz sonst
	 */
	public TreeNode searchNode(int v) {
		return searchNodeRek(root, v);
	}

	public TreeNode searchNodeRek(TreeNode r, int v) {
		if (r == null) {
			return null;
		} else {
			if (v < r.info) {
				return searchNodeRek(r.left, v); // im linken Teilbaum
													// weitersuchen
			} else if (v > r.info) {
				return searchNodeRek(r.right, v); // im rechten Teilbaum
													// weitersuchen
			} else {
				// v == r.value //Wert gefunden
				return r;
			}
		}
	}

	/**
	 * gibt den Baum 'grafisch' ueber die Konsole aus
	 */
	public void print() {
		if (root != null) {
			print(root.left, "    ", true);
			System.out.println("+---" + root.info);
			print(root.right, "    ", false);
		} else {
			System.out.println("(empty tree)");
		}
	}

	/** rekursive Hilfsmethode zur Ausgabe des Baums */
	private void print(TreeNode r, String prefix, boolean links) {
		if (r != null) {
			if (links)
				print(r.left, prefix + "    ", links);
			else
				print(r.left, prefix + "|   ", !links);

			System.out.println(prefix + "+---" + r.info);

			if (links)
				print(r.right, prefix + "|   ", !links);
			else
				print(r.right, prefix + "    ", links);

		}
	}

	/**************************************************************************************
	 * Aufgabe 7.3
	 **************************************************************************************/

	/** Bestimmt die Summe aller Werte, die im Baum gespeichert sind. */
	private int _Sum = 0;
	public int sum() {

		sumRek(root);

		return _Sum;
	}
	private void sumRek(TreeNode node)
	{
		_Sum += node.info;
		if(node.left != null)
		{
			sumRek(node.left);
		}
		if(node.right != null)
		{
			sumRek(node.right);
		}
	}

	/** Berechnet die Anzahl der Bl�tter des Baums */
	private int _LeaveCounter = 0;
	public int leaves() {

		leavesRek(root);

		return _LeaveCounter;
	}
	private void leavesRek(TreeNode node)
	{
		if(node.right == null && node.left == null)
		{
			_LeaveCounter++;
		}
		else
		{
			if(node.left != null)
			{
				leavesRek(node.left);
			}
			if(node.right != null)
			{
				leavesRek(node.right);
			}
		}
	}

	/**
	 * F�gt den Wert v iterativ in den Suchbaum ein. Liefert true als Ergebnis,
	 * falls der Wert noch nicht enthalten war und false, falls er vorher schon
	 * gespeichert war.
	 */
	public boolean insertIter(int v) {
		TreeNode node = root;
		while(true)
		{
			if(node == null) {
				root = new TreeNode(v);
				return true;
			}
			else if (v < node.info) {
				if (node.left == null) {
					node.left = new TreeNode(v);
					return true;
				} else {
					node = node.left;
				}
			} else if (v > node.info) {
				if (node.right == null) {
					node.right = new TreeNode(v);
					return true;
				} else {
					node = node.right;
				}
			} else
				return false;
		}
	}

	public int extractMin() {
		if(root == null) throw new RuntimeException();

		TreeNode node = root;

		while(node.left != null)
		{
			node = node.left;
		}

		return node.info;
	}

	/**
	 * Liefert eine sortierte Liste mit den Werten des Baums
	 */
	public ArrayList<Integer> toSortedList() {
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		toSortedListRek(root, sortedList);

		Collections.sort(sortedList);
		return sortedList;
	}
	private void toSortedListRek(TreeNode node, ArrayList<Integer> list)
	{
		list.add(node.info);
		if(node.left != null)
			toSortedListRek(node.left, list);
		if (node.right != null)
			toSortedListRek(node.right, list);
	}

	/** Checks whether both trees contain the same set of values */
	public boolean equals(SearchTree other) {
		ArrayList<Integer> thisTree = toSortedList();
		ArrayList<Integer> otherTree = other.toSortedList();
		if(thisTree.equals(otherTree)) return true;
		else return false;
	}
}
