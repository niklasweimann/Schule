/**
 * @author Niklas Weimann
 * @version 1.0.0
 */
public class Stapelelement
{
    private String content; // Inhalt des Elements
    private Stapelelement next; // Nachfolger des Elements

    // Konstruktor
    public Stapelelement()
    {

    }

    /**
     * Erstellt ein Stapelelement mit dem übergebenen String
     * 
     * @param  pContent   Weist dem Stapelelement einen Wert zu
     */
    public Stapelelement(String pContent)
    {
        this.content = pContent;
    }

    /**
     * Erstellt ein Stapelelement mit dem übergebenen Content und dem Nachfolgenden Stapelelemnt
     * 
     * @param  pContent   Weist dem Stapelelement einen Wert zu
     * @param  next       Weist dem Stapelelement einen Nachfolger zu
     */
    public Stapelelement(String pContent, Stapelelement next)
    {
        this.content = pContent;
        this.next = next;
    }

    /**
     * Gibt den aktuellen Wert des Stapelelements zurück
     * 
     * @return Wert des aktuellen Stapelelements
     */
    public String getContent()
    {
        return this.content;
    }

    /**
     * Gibt den aktuellen Nachfolger des Stapelelements zurück
     * 
     * @return Nachfolger des aktuellen Stapelelements
     */
    public Stapelelement getNext()
    {
        return this.next;
    }

    /**
     * Fügt dem Stapelelement einen neuen Wert zu
     * 
     * @param   content     Weist dem Stapelelement einen Wert zu
     */
    public void setContent(String pContent)
    {
        this.content = pContent;
    }

    /**
     * Fügt dem Stapelelement einen neuen Nachfolger zu
     * 
     * @param   content     Weist dem Stapelelement einen Nachfolger zu
     */
    public void setNext(Stapelelement pNext)
    {
        this.next = pNext;
    }
}
