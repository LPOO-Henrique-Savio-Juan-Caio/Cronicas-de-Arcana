package CronicasDeArcana;
import java.util.List;


public class Mao {

    private Carta[] cartas;
    //deduzindo que 5 cartas fiquem na mao
    public Mao(List<Carta> ListaCartas, String[] nomeCartas){
        cartas = new Carta[5];

        for (int i = 0; i < 5; i++) {
            if(selecionarCartas(ListaCartas, nomeCartas[i]) != null){
                cartas[i] = selecionarCartas(ListaCartas, nomeCartas[i]);
            }
            else{
                System.out.println("Carta não encontrada.");
            }
        }



    }

    //percebe-se que essa função esta se repetindo, vamos dar um jeito depois de so usar ela uma vez para nao ficar repetitivo
    public Carta selecionarCartas(List<Carta> cartas, String nomeCarta){

        for (Carta carta : cartas){
            if(carta.getNome().equalsIgnoreCase(nomeCarta)){
                return carta; //retorna a carta caso encontre o nome no array de cartas
            }
        }

        return null;

    }


}
