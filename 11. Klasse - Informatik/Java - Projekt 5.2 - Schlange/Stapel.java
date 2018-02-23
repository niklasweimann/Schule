/**
 * @author  Niklas Weimann
 * @version 1.0.0
 */
public class Stapel
{
    private Stapelelement top;

    // Konstruktor
    public Stapel()
    {

    }

    /**
     * Gibt "True" zurück, wenn der Stapel leer ist
     * 
     * @return		True, wenn der Stapel leer ist und False, wenn noch etwas im Stapel ist
     */
    public boolean isEmpty()
    {
        return this.getTop() == null;
    }

    
    /**
     * Legt ein neues Stapelelement auf den Stapel
     * 
     * @param  pStapelelement	Stapelelement, das auf den Stapel gelegt werden soll.
     */
    public void push(Stapelelement pStapelelement)
    {
        if(this.isEmpty())
        {
            this.top = pStapelelement;
        }
        else
        {
            Stapelelement oldTop = this.top;
            this.top = pStapelelement;
            this.top.setNext(oldTop);
        }
    }
    
    /**
     * Entfernt das oberste Element des Stapels
     */
    public void pop()
    {
        this.top = this.top.getNext();
    }
    
    /**
     * Gibt das Oberste Stapelelement zurück
     * 
     * @return		oberstes Stapelelement
     */
    public Stapelelement getTop()
    {
        return this.top;
    }
    
    /**
     * Entfernt das oberste Stapelelement
     */
    public void erase()
    {
        this.top = null;
    }
}
