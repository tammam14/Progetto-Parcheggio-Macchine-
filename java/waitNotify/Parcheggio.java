package waitNotify;

public class Parcheggio {
    private int totalePosti = 10;

    public int getTotalePosti() {
        return totalePosti;
    }
    
    //Metodo per regolare l'igresso delle auto
    public void ingresso(){
        while (totalePosti == 0) { 
            try{
                wait();  
            } catch (InterruptedException e) {}
        } 
        totalePosti--;
    }
    
    //L'auto esce dal parcheggio
    public void uscita()
    {
        totalePosti++; 
        notifyAll();
    }
}
