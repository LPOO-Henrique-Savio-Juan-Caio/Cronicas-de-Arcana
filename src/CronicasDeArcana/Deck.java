package CronicasDeArcana;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Carta> cartas;



    //a ideia é criar um array com o nome de todas as cartas, eles serao percorridos um a um até que ache a carta em algum dos objetos que criaremos de cada tipo
    public Deck(ArrayList<String> nomesCartas, ArrayList<Carta> arrayCartas){
        this.cartas = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Carta cartaSelecionada = selecionarCartas(arrayCartas, nomesCartas.get(i));
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

    public Carta selecionarCartas(ArrayList<Carta> cartas, String nomeCarta) {
        Carta carta1 = cartas.get(0);
        for (Carta carta : cartas) {
            if (carta.getNome().equalsIgnoreCase(nomeCarta)) {
                carta1 = carta; //retorna a carta caso encontre o nome no array de cartas
            } else {
                return null;
            }
        } return carta1;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    

   // @Override
   /* public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Deck:\n");
        for (Carta carta : cartas) {
            if (carta != null) {
                sb.append(carta.getNome()).append("\n");
            } else {
                sb.append("Carta não encontrada.\n");
            }
        }
        return sb.toString();
    }*/
}
