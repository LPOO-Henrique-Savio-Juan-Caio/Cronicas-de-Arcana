package entidades.zonas;

import entidades.carta.Carta;
import java.util.ArrayList;

public class Cemiterio implements AcoesZonas{

    private ArrayList<Carta> cemiterio;

    public Cemiterio(){
        this.cemiterio = new ArrayList<>();
        }

    public ArrayList<Carta> getCartasCemiterio() {
        return cemiterio;
    }

    public Carta selecionarCarta(ArrayList<Carta> arrayCartas, String nomeCarta) {
        return null;
    }

    public void adicionarCarta(Carta carta){
        this.cemiterio.add(carta);
    }

    public void removerCarta(Carta carta){
        this.cemiterio.remove(carta);
    }

}
