package entidades.zonas;

import entidades.carta.Carta;
import java.util.ArrayList;

public class Deck implements AcoesZonas{

    private ArrayList<Carta> cartas;



    //a ideia é criar um array com o nome de todas as cartas, eles serao percorridos um a
    // um até que ache a carta em algum dos objetos que criaremos de cada tipo
    public Deck(ArrayList<String> nomesCartas, ArrayList<Carta> arrayCartas){
        this.cartas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Carta cartaSelecionada = selecionarCarta(arrayCartas, nomesCartas.get(i));
            if (cartaSelecionada != null) {
                cartas.add(cartaSelecionada);
            } else {
                System.out.println("Carta não encontrada: " + nomesCartas.get(i));
            }
        }
    }

    public void adicionarCarta(Carta carta){
        this.cartas.add(carta);
    }
    public void removerCarta(Carta carta){
        this.cartas.remove(carta);
    }

    public Carta selecionarCarta(ArrayList<Carta> cartas, String nomeCarta) {
        for (Carta carta : cartas) {
            if (carta.getNome().equalsIgnoreCase(nomeCarta)) {
                return carta; // Retorna a carta se encontrar o nome no array
            }
        }
        return null; // Retorna null apenas se o loop terminar sem encontrar a carta
    }
    

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

}
