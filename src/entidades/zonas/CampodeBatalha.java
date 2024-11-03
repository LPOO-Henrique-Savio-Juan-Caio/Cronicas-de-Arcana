package entidades.zonas;

import entidades.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class CampodeBatalha {

    private List<Carta> CartasnoCampo;

    // Construtor para inicializar a lista
    public CampodeBatalha() {
        this.CartasnoCampo = new ArrayList<>();
    }

    // Método para adicionar uma carta ao campo
    public void adicionarCartaAoCampo(Carta carta) {
        CartasnoCampo.add(carta);
    }

    public void removerCarta(Carta carta) {
        CartasnoCampo.remove(carta);
    }

    // (Opcional) Getter para acessar as cartas no campo
    public List<Carta> getCartasnoCampo() {
        return CartasnoCampo;
    }

    // essa função recebe determinada carta e da dano em todas as cartas do campo
     public void danoCampoBatalha(Carta cartaInimiga) {
        for (Carta carta : CartasnoCampo) {
            carta.receberDano(cartaInimiga.getPoder());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cartas no Campo:\n");
        for (Carta carta : CartasnoCampo) {
            sb.append("Nome: ").append(carta.getNome())
              .append(", Resistência: ").append(carta.getResistencia())
              .append("\n");
        }
        return sb.toString();
    }
}
