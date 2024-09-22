package CronicasDeArcana;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mao {

    private Carta[] cartasMao;

    public Mao(String[] nomesCartas, List<Carta> arrayCartas) {
        cartasMao = new Carta[5];
        Carta[] deckExemplo = new Carta[5];
        gerarCartas(nomesCartas, arrayCartas, deckExemplo);

        Random random = new Random();
        int indiceAleatorio = random.nextInt(deckExemplo.length);

        for (int i = 0; i < 5; i++) {
            cartasMao[i] = deckExemplo[indiceAleatorio];
            indiceAleatorio = random.nextInt(deckExemplo.length);
        }
    }

    // Transforma o array de nome de cartas em um array da classe Carta
    private void gerarCartas(String[] nomesCartas, List<Carta> arrayCartas, Carta[] deckExemplo) {
        for (int i = 0; i < 5; i++) {
            if (selecionarCarta(arrayCartas, nomesCartas[i]) != null) {
                deckExemplo[i] = selecionarCarta(arrayCartas, nomesCartas[i]);
            } else {
                System.out.println("Carta não encontrada: " + nomesCartas[i]);
            }
        }
    }

    public Carta selecionarCarta(List<Carta> cartas, String nomeCarta) {
        for (Carta carta : cartas) {
            if (carta.getNome().equalsIgnoreCase(nomeCarta)) {
                return carta; // Retorna a carta caso encontre o nome no array de cartas
            }
        }
        return null;
    }
    
    public String imprimirMao(){
        ArrayList<String> mao = new ArrayList<>();
        for(Carta carta : cartasMao){
            mao.add(carta.getNome());
        }
        return String.join(", ", mao);
    }

    public Carta[] getCartasMao(){
        return cartasMao;
    }
   // @Override
   /* public String toString() {
        StringBuilder sb = new StringBuilder("Cartas na mão:\n");
        for (Carta carta : cartasMao) {
            sb.append(carta.toString()).append("\n"); // Certifique-se de que a classe Carta tem um método toString implementado
        }
        return sb.toString();
    }*/
}
