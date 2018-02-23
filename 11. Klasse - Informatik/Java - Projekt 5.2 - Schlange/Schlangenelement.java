
/**
 * @author 
 * @version 
 */
public class Schlangenelement
{
    private String content;
    private Schlangenelement next;
    // Konstruktor
    public Schlangenelement()
    {

    }

    /**
     * Erstellt ein Schlangenelement mit dem übergebenen String
     * 
     * @param  pContent   Weist dem Schlangenelement einen Wert zu
     */
    public Schlangenelement(String pContent)
    {
        this.content = pContent;
    }
    
    /**
     * Erstellt ein Schlangenelement mit dem übergebenen Content und dem Nachfolgenden Schlangenelement
     * 
     * @param  pContent   Weist dem Schlangenelement einen Wert zu
     * @param  next       Weist dem Schlangenelement einen Nachfolger zu
     */
    public Schlangenelement(String pContent, Schlangenelement next)
    {
        this.content = pContent;
        this.next = next;
    }
    
    /**
     * Gibt den aktuellen Wert des Schlangenelements zurück
     * 
     * @return Wert des aktuellen Schlangenelements
     */
    public String getContent()
    {
        return this.content;
    }
    
    /**
     * Gibt den aktuellen Nachfolger des Schlangenelements zurück
     * 
     * @return Nachfolger des aktuellen Schlangenelements
     */
    public Schlangenelement getNext()
    {
        return this.next;
    }
    
    /**
     * Fügt dem Schlangenelement einen neuen Wert zu
     * 
     * @param   content     Weist dem Schlangenelement einen Wert zu
     */
    public void setContent(String pContent)
    {
        this.content = pContent;
    }

    /**
     * Fügt dem Schlangenelement einen neuen Nachfolger zu
     * 
     * @param   content     Weist dem Schlangenelement einen Nachfolger zu
     */
    public void setNext(Schlangenelement pNext)
    {
        this.next = pNext;
    }
}
