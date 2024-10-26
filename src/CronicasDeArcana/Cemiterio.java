package CronicasDeArcana;

import java.util.ArrayList;

public class Cemiterio {

    private ArrayList<Carta> cemiterio;

    public Cemiterio(){
        this.cemiterio = new ArrayList<>();
        }

    public void adicionarCarta(Carta carta){
        this.cemiterio.add(carta);
    }

    public void removerCarta(Carta carta){
        this.cemiterio.remove(carta);
    }
}
