
/**
 * @author 
 * @version 
 */
public class Schlange
{
    private Schlangenelement first;
    private Schlangenelement last;

    private int size;

    public Schlange() {
    }

    /**
     * Hängt ein Schlangenelement an die Schlang an
     * 
     * @param  value    Wert, der in das Schlangenelement gespeichert wird
     */
    public void enqueue(String value){
        if(value == null) // Wenn null, dann Fehler ausgeben!
        {
            throw new IllegalArgumentException("Wert darf nicht null sein");
        }
        if(last == null){
            this.first = this.last = new Schlangenelement(value);
        }else{
            Schlangenelement entry = new Schlangenelement(value);
            last.setNext(entry);
            last = entry;
        }
        size++;
    }

    /**
     * Hängt das erste Element von der Schlange ab und gibt den Wert zurück
     * 
     * @return      Wert des Schlangenelements
     */
    public String dequeue(){
        if(first != null){
            Schlangenelement entry = first;
            first = entry.getNext();
            entry.setNext(null);
            size--;
            return entry.getContent();
        }
        return null;
    }

    /**
     * Gibt zurück, ob die Schlange leer ist
     * 
     * @return      True, wenn Schlange leer, False, wenn Schlangenelemente 
     * in Schlange
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Gibt an, wie groß die Schlange ist
     * 
     * @return   Gibt die Größe der Schlange als INT zurück
     */
    public int size(){
        return size;
    }
}