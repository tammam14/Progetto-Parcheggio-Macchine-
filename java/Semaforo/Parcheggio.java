package Semaforo;

import java.util.concurrent.Semaphore;

public class Parcheggio {
    private int totalePosti  = 10;
    private Semaphore Disponibile;
    private Semaphore Occupato;
    
    //Costruttore
    public Parcheggio() {
        Disponibile = new Semaphore(totalePosti, true); 
        Occupato = new Semaphore(0, true); 
    }
    
    public int getTotalePosti() {
        return totalePosti;
    }
    
    public void ingresso()
    {
        try
        {
            Disponibile.acquire(); 
            totalePosti--;
        } catch (InterruptedException e) {}       
        Occupato.release(); 
    }
    
    public  void uscita()
    {
        try
        {
            Occupato.acquire(); 
            totalePosti++;
        } catch (InterruptedException e) {}      
        Disponibile.release(); 
    }
}
