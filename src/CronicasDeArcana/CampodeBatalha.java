package CronicasDeArcana;

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

    // (Opcional) Getter para acessar as cartas no campo
    public List<Carta> getCartasnoCampo() {
        return CartasnoCampo;
    }
}
