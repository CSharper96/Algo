package blatt10;

/**
 * Ausnahmeklasse f�r Fehler beim Stackoperationen
 * 
 * @author G. Schied
 */
public class StackException extends Exception
{
    public StackException() {
        super();
    }
    public StackException(String msg) {
        super(msg);
    }
}
