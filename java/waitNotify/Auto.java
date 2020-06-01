package waitNotify;

public class Auto extends Thread{
    private Parcheggio parcheggio;

    //Costruttore
    public Auto(String nome, Parcheggio parcheggio) {
        super(nome);
        this.parcheggio = parcheggio;
        start();
    }
    
    @Override
    public void run(){
        while(true) { //loop
            synchronized (parcheggio){ 
                parcheggio.ingresso(); 
                System.out.println("L'auto " + super.getName() + " é entrata\n Posti disponibili: " + parcheggio.getTotalePosti() + "\n");
            }          
            synchronized (parcheggio){ 
                parcheggio.uscita(); 
                System.out.println("L'auto " + super.getName() + " é uscita\n Posti disponibili: " + parcheggio.getTotalePosti() + "\n");
            }
        }
    } 
}
