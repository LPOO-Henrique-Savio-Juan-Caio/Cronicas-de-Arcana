package CronicasDeArcana;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mao {

    private ArrayList<Carta> cartasMao = new ArrayList<>(5);
    ArrayList<String> mao = new ArrayList<>();

    public Mao(String[] nomesCartas, List<Carta> arrayCartas) {
        Carta[] deckExemplo = new Carta[40];
        gerarCartas(nomesCartas, arrayCartas, deckExemplo);

        Random random = new Random();
        int indiceAleatorio1 = random.nextInt(deckExemplo.length);
        int indiceAnterior = indiceAleatorio1;

        /*for (int i = 0; i < 5; i++) {
            cartasMao.add(null); // Adiciona valores nulos para preencher os 5 slots
        }*/

        for (int i = 0; i < 5; i++) {
            cartasMao.add(deckExemplo[indiceAleatorio1]);
            indiceAleatorio1 = random.nextInt(deckExemplo.length);
            if(indiceAleatorio1 == indiceAnterior){
                indiceAleatorio1 = indiceAleatorio1 + 1;
            }
            indiceAnterior = indiceAleatorio1;
        }
    }

    // Transforma o array de nome de cartas em um array da classe Carta
    private void gerarCartas(String[] nomesCartas, List<Carta> arrayCartas, Carta[] deckExemplo) {
        for (int i = 0; i < 40; i++) {
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
        String mao = "";
        for(Carta carta : this.cartasMao){
          mao = mao + carta.getNome() + ", ";
        }
        return mao;
    }

    public ArrayList<Carta> getCartasMao(){
        return this.cartasMao;
    }

    public void removerCarta(Carta carta){
        this.cartasMao.remove(carta);

    }

    public void adicionarCarta(Carta carta){
        cartasMao.add(carta);

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
