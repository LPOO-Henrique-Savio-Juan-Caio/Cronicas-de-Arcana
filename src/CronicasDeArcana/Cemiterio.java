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

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cartas no Cemitério:\n");
        
        if (cemiterio.isEmpty()) {
            sb.append("Nenhuma carta no cemitério.");
        } else {
            for (Carta carta : cemiterio) {
                sb.append("Nome: ").append(carta.getNome())
                  .append(", Tipo: ").append(carta.getClass().getSimpleName())
                  .append("\n");
            }
        }
        
        return sb.toString();
    }
}
