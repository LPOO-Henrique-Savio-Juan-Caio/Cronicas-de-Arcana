package CronicasDeArcana;
import java.util.List;


public class Deck {

    private Carta[] cartas;



    //a ideia é criar um array com o nome de todas as cartas, eles serao percorridos um a um até que ache a carta em algum dos objetos que criaremos de cada tipo
    public Deck(String[] nomesCartas, List<Carta> arrayCartas){
        cartas = new Carta[nomesCartas.length];

        for (int i = 0; i < 30; i++) {
            if(selecionarCartas(arrayCartas, nomesCartas[i]) != null){
                cartas[i] = selecionarCartas(arrayCartas, nomesCartas[i]);
            }
            else{
                System.out.println("Carta não encontrada.");
            }
        }

        

    }

    public Carta selecionarCartas(List<Carta> cartas, String nomeCarta){

        for (Carta carta : cartas){
            if(carta.getNome().equalsIgnoreCase(nomeCarta)){
                return carta; //retorna a carta caso encontre o nome no array de cartas
            }
        }

        return null;

    }


    @Override
    public String toString(){
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
    }
    

}
