package entidades.zonas;
import entidades.carta.Carta;

import java.util.ArrayList;
import java.util.Random;

public class Mao implements AcoesZonas{

    private ArrayList<Carta> cartasMao;
    private Deck deck;

    public Mao(ArrayList<String> nomesCartas, ArrayList<Carta> arrayCartas, Deck deck) {
        this.deck = deck;
        cartasMao = new ArrayList<>(5);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int indiceAleatorio = random.nextInt(deck.getCartas().size());
            Carta cartaSorteada = deck.getCartas().get(indiceAleatorio);

            cartasMao.add(cartaSorteada);
            deck.getCartas().remove(indiceAleatorio);
        }
    }

    public ArrayList<Carta> gerarCartas(ArrayList<String> nomesCartas, ArrayList<Carta> arrayCartas) {
        ArrayList<Carta> cartasConvertidas = new ArrayList<>();
        for (String nome : nomesCartas) {
            Carta carta = selecionarCarta(arrayCartas, nome);
            if (carta != null) {
                cartasConvertidas.add(carta);
            } else {
                System.out.println("Carta não encontrada: " + nome);
            }
        }
        return cartasConvertidas;
    }

    public Carta selecionarCarta(ArrayList<Carta> cartas, String nomeCarta) {
        for (Carta carta : cartas) {
            if (carta.getNome().equalsIgnoreCase(nomeCarta)) {
                return carta;
            }
        }
        return null;
    }

    public String imprimirMao() {
        StringBuilder mao = new StringBuilder();
        for (Carta carta : this.cartasMao) {
            mao.append(carta.getNome()).append(", ");
        }
        return mao.toString();
    }

    public ArrayList<Carta> getCartasMao() {
        return this.cartasMao;
    }

    public void removerCarta(Carta carta) {
        if (this.cartasMao.remove(carta)) {
            adicionarCartaDoDeck();
        }
    }

    public void adicionarCartaDoDeck() {
        if (!deck.getCartas().isEmpty()) {
            Random random = new Random();
            int indiceAleatorio = random.nextInt(deck.getCartas().size());
            Carta cartaNova = deck.getCartas().get(indiceAleatorio);
            
            cartasMao.add(cartaNova);
            deck.getCartas().remove(indiceAleatorio);
        } else {
            System.out.println("O deck está vazio! Não foi possível adicionar uma nova carta à mão.");
        }
    }

    public void adicionarCarta(Carta carta) {
        cartasMao.add(carta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cartas na mão:\n");
        for (Carta carta : cartasMao) {
            sb.append(carta.toString()).append("\n");
        }
        return sb.toString();
    }
}
