package CronicasDeArcana;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mao {

    private ArrayList<Carta> cartasMao;
    ArrayList<String> mao = new ArrayList<>();

    public Mao(ArrayList<String> nomesCartas, ArrayList<Carta> arrayCartas) {
        ArrayList<Carta> deckExemplo = new ArrayList<>(40);
        cartasMao = new ArrayList<>(5);
        deckExemplo = gerarCartas(nomesCartas, arrayCartas);

        Random random = new Random();
        int indiceAleatorio1 = random.nextInt(39);
        int[] indicesAnteriores = new int[5];

        /*for (int i = 0; i < 5; i++) {
            cartasMao.add(null); // Adiciona valores nulos para preencher os 5 slots
        }*/

        for (int i = 0; i < 5; i++) {
            cartasMao.add(deckExemplo.get(indiceAleatorio1));
            indiceAleatorio1 = random.nextInt(deckExemplo.size());
            indicesAnteriores[i] = indiceAleatorio1;
            for(int j = 0; j < 5; j++){
                if(indiceAleatorio1 == indicesAnteriores[j]){
                    indiceAleatorio1 = indiceAleatorio1 + 1;
                }
            }
        }
    }

    // Transforma o array de nome de cartas em um array da classe Carta
    /*private void gerarCartas(ArrayList<String> nomesCartas, ArrayList<Carta> arrayCartas, ArrayList<Carta> deckExemplo) {
        deckExemplo = new ArrayList<>(40);
        for (int i = 0; i < 40; i++) {
            if (selecionarCarta(arrayCartas, nomesCartas.get(i)) != null) {
                deckExemplo.add(selecionarCarta(arrayCartas, nomesCartas.get(i)));
            } else {
                System.out.println("Carta não encontrada: " + nomesCartas.get(i));
            }
        }
    }*/

    public ArrayList<Carta> gerarCartas(ArrayList<String> nomesCartas, ArrayList<Carta> arrayCartas) {
        ArrayList<Carta> cartasConvertidas = new ArrayList<>();
        Carta carta;
        for (String nome : nomesCartas) {
            carta = selecionarCarta(arrayCartas, nome);
            if (carta != null) {
                cartasConvertidas.add(carta); // Adiciona a carta correspondente se encontrada
            } else {
                System.out.println("Carta não encontrada: " + nome); // Exibe mensagem se não houver correspondência
            }
        }

        return cartasConvertidas;
    }


    public Carta selecionarCarta(ArrayList<Carta> cartas, String nomeCarta) {
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
