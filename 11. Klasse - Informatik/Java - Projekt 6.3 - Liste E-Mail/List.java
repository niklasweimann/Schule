/**
 * @author Niklas Weimann
 * @version 3.4.0
 */
public class List
{
    // Bezugsobjekte
    private Listenelement first;
    private Listenelement last;
    private Listenelement current;
    private int size = 0;
    private int pos = 0;
    // Attribute

    // Konstruktor
    public List()
    {

    }

    // Dienste

    /**
     * Gibt das letzte Listenelement in der Liste zurück
     * 
     * @return		last = Letztes Element in der Liste
     */
    public Listenelement getLast()
    {
        return last;
    }

    /**
     * Gibt die Anzahl der Listenelemente zurück
     * 
     * @return		size = Anzahl der Elemente in der Liste
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Gibt die Anzahl der Listenelemente zurück
     * 
     * @return		pos = Position in der Liste als Integer
     */
    public int getPos()
    {
        return pos;
    }

    /**
     * Die Anfrage liefert den Wert true, wenn die Liste keine Elemente enthält, sonst liefert sie den 
     * Wert false.
     * 
     * @return		(Beschreibung des Rückgabewertes)
     */
    public boolean isEmpty()
    {
        if(current == null){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Die Anfrage liefert den Wert true, wenn der Positionszeiger vor dem ersten Listenelement oder vor der 
     * leeren Liste steht, sonst liefert sie den Wert false.
     * 
     * @return		(Beschreibung des Rückgabewertes)
     */
    public boolean isBefore()
    {
        if(current == first || first == null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Die Anfrage liefert den Wert true, wenn der Positionszeiger hinter dem letzten Listenelement oder 
     * hinter der leeren Liste steht, sonst liefert sie den Wert false. 
     * 
     * @return		(Beschreibung des Rückgabewertes)
     */
    public boolean isBehind()
    {
        if(current == last || last == null){
            return true; 
        }
        else {
            return false;
        }
    }

    /**
     * Der Positionszeiger ist um eine Position in Richtung Listenende weitergerückt, d.h. wenn er vor der 
     * Liste stand, wird das Element am Listenanfang zum aktuellen Element, ansonsten das jeweils nachfolgende 
     * Listenelement. Stand der Positionszeiger auf dem letzten Listenelement, befindet er sich jetzt hinter 
     * der Liste. Befand er sich hinter der Liste, hat er sich nicht verändert. 
     * 
     */
    public void next()
    {
        if(current != last){
            current = current.getNext();
            pos++;
        }
        else if(current == null) { 
            current = first; 
        }
    }

    /**
     * Der Positionszeiger ist um eine Position in Richtung Listenanfang weitergerückt, d.h. wenn er hinter
     * der Liste stand, wird das Element am Listenende zum aktuellen Element, ansonsten das jeweils
     * vorhergehende Listenelement. Stand der Positionszeiger auf dem ersten Listenelement, befindet er sich
     * jetzt vor der Liste. Befand er sich vor der Liste, hat er sich nicht verändert. 
     * 
     * @param  y	(Beschreibung des Parameters)
     * @return		(Beschreibung des Rückgabewertes)
     */
    public void previous()
    {
        if(current != first){
            current = current.getPrevious();
            pos--;
        }
        else if(current == null)
        {
            current = last;
        }
    }

    /**
     * Der Positionszeiger steht auf dem ersten Listenelement. Falls die Liste leer ist befindet er sich 
     * jetzt hinter der Liste. 
     * 
     */
    public void toFirst()
    {
        if(this.isEmpty()== true && current == first)
        {
            current = last;
        }
    }

    /**
     * Der Positionszeiger steht auf dem letzten Listenelement. Falls die Liste leer ist befindet er 
     * sich jetzt vor der Liste.
     * 
     */
    public void toLast()
    {
        if(this.isEmpty()== true && current == last)
        {
            current = first;
        }
    }

    /**
     * Die Anfrage liefert den Wert des aktuellen Listenelements bzw. null, wenn die Liste keine Elemente 
     * enthält, bzw. der Positionszeiger vor oder hinter der Liste steht. 
     * 
     * @return		(Beschreibung des Rückgabewertes)
     */
    public Listenelement getItem()
    {
        if(this.isEmpty() == true && current == first && current == last) {
            return null;
        }
        else {
            return current;
        }
    }

    /**
     * Vorher: Der Positionszeiger steht nicht hinter der Liste. 
     * Nachher: Ein neues Listenelement mit dem entsprechenden Objekt ist angelegt und hinter der aktuellen 
     *          Position in die Liste eingefügt worden. Der Positionszeiger steht vor dem eingefügten Element. 
     * 
     * @param  EMail	Objekt, dass eingefügt werden soll
     */
    public void insertBehind(EMail pEMail)
    {
        Listenelement neu = new Listenelement(pEMail);
        if (this.isEmpty())
        {
            first = neu;
            current = neu;
            last = neu;
        }
        else if(current.getNext() == null)
        {
            current.setNext(neu);
            neu.setPrevious(current);
            last = neu;
        }
        else if(current.getNext()!= null)
        {
            current.getNext().setPrevious(neu);
            neu.setNext(current.getNext());
            current.setNext(neu);
            neu.setPrevious(current);
            size++;
        }
        current = neu;
        size++;
        pos++;
    }

    /**
     * Vorher: Der Positionszeiger steht nicht vor der Liste. 
     * Nachher: Ein neues Listenelement mit dem entsprechenden Objekt ist angelegt und vor der aktuellen
     *          Position in die Liste eingefügt worden. Der Positionszeiger steht hinter dem eingefügten 
     *          Element. 
     * 
     * @param  EMail	Objekt, dass eingefügt werden soll
     */
    public void insertBefore(EMail pEMail)
    {

    }

    /**
     * Vorher: Der Positionszeiger steht nicht vor oder hinter der Liste. 
     * Nachher: Das aktuelle Listenelement ist gelöscht. Der Positionszeiger steht auf dem Element hinter dem
     *          gelöschten Element, bzw. hinter der Liste, wenn das gelöschte Element das letzte Listenelement
     *          war. 
     * 
     */
    public void delete()
    {
        if(current == last && current != first)
        {
            current = current.getPrevious();
            current.setNext(null);
            last = current;
        }
        else if(current == first && current == last)
        {
            current = null;
            first = null;
            last = null;
        }
        else if(current != first || current != last || current != null)
        {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            current = current.getNext();

        }
        size--;
        pos--;
    }
}
