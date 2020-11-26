package blatt07;
/**
 * Knoten eines binären Baums mit einem int-Wert als "Nutzinformation"
 */
public class TreeNode {
    int info;
    TreeNode left;
    TreeNode right;
    
    /** erzeugt Knoten mit angegebenem Wert und linkem sowie rechtem
     *  Teilbaum
     */
    public TreeNode(int v, TreeNode l, TreeNode r) {
        info = v;
        left = l;
        right = r;
    }

    /** erzeugt Blatt mit angegebenem Wert */
    public TreeNode(int v) {
        info = v;
        left = null;
        right = null;
    }
}
