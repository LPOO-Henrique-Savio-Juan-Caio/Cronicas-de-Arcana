package entidades.zonas;

import entidades.carta.Carta;
import java.util.ArrayList;
import java.util.List;

public class CampoDeBatalha implements AcoesZonas{

    private List<Carta> CartasNoCampo;

    // Construtor para inicializar a lista
    public CampoDeBatalha() {
        this.CartasNoCampo = new ArrayList<>();
    }

    // Método para adicionar uma carta ao campo
    @Override
    public void adicionarCarta(Carta carta) {
        CartasNoCampo.add(carta);
    }

    @Override
    public void removerCarta(Carta carta) {
        CartasNoCampo.remove(carta);
    }

    // (Opcional) Getter para acessar as cartas no campo
    public List<Carta> getCartasNoCampo() {
        return CartasNoCampo;
    }

    // essa função recebe determinada carta e da dano em todas as cartas do campo
     public void danoCampoBatalha(Carta cartaInimiga) {
        for (Carta carta : CartasNoCampo) {
            //30% do seu dano total
            carta.receberDano(cartaInimiga.getPoder() * 0.30);
        }
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Cartas no Campo de Batalha: ");

    if (CartasNoCampo.isEmpty()) {
        sb.append("Nenhuma carta no campo.");
    } else {
        for (Carta carta : CartasNoCampo) {
            sb.append(carta.getNome()).append(", ");
        }
        // Remove a última vírgula e espaço
        sb.setLength(sb.length() - 2);
    }

    return sb.toString();
    }

    @Override
    public Carta selecionarCarta(ArrayList<Carta> arrayCartas, String nomeCarta){
        return null;
    }
}
