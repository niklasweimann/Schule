/**
 * @author Niklas Weimann
 * @version 2.1.3
 */
public class Listenelement
{
    // Bezugsobjekte
    private Listenelement previous;
    private Listenelement next;
    private EMail inhalt;
    // Attribute

    // Konstruktor
    public Listenelement()
    {
        inhalt = null;
        next = null;
        previous = null;
    }
    
    public Listenelement(EMail pEMail)
    {
        inhalt = pEMail;
        next = null;
        previous = null;
    }
    
    public Listenelement(EMail pInhalt, Listenelement pNext, Listenelement pPrevious)
    {
        inhalt = pInhalt;
        next = pNext;
        previous = pPrevious;
    }

    // Dienste
    public Listenelement getNext(){
        return next;
    }
    
    public Listenelement getPrevious(){
        return previous;
    }
    
    public EMail getInhalt()
    {
        return inhalt;
    }
    
    public void setNext(Listenelement pNext){
        next = pNext;
    }
    
    public void setPrevious(Listenelement pObject){
        previous = pObject;
    }
    
    public void setInhalt(EMail pInhalt)
    {
        inhalt = pInhalt;
    }
}
