package CronicasDeArcana;
import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private String nome;
    private double vida;
    private double mana;
    private Deck deck;
    private Mao mao;
    private Cemiterio cemiterio;


    //a questao aqui é que mao e cemiterio mudarao durante todo o jogo, ou seja, teremos que criar funções para mudar os objetos dessas classes.
    public Jogador(String nome, double vida, double mana,  List<Carta> arrayCartas,  String[] nomecartasDeck){
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.deck = new Deck(nomecartasDeck, arrayCartas);
        this.mao = new Mao(nomecartasDeck, arrayCartas);
        this.cemiterio = new Cemiterio();


    }

    public String imprimirMao() {
        return mao.imprimirMao();
    }

    //vamos tirar vida e mana do construtor, ja que todos terao a msm quantidade

    public String getNome(){
        return this.nome;
    }

    public void setVida(double vida){
        this.vida = vida;
    }
    public double getVida(){
        return this.vida;
    }

    public void setMana(double mana){
        this.mana = mana;
    }
    public double getMana(){
        return this.mana;
    }

    public Carta selecionarCarta(String nomeCarta){
        for (Carta carta : mao.getCartasMao()) {
            if (carta.getNome().equalsIgnoreCase(nomeCarta)) {
                return carta; // Retorna a carta caso encontre o nome no array de cartas
            }
        }
        return null;
    }

    public Carta selecionarCarta(List<Carta> cartas, String nomeCarta) {
        for (Carta carta : cartas) {
            if (carta.getNome().equalsIgnoreCase(nomeCarta)) {
                return carta; // Retorna a carta caso encontre o nome no array de cartas
            }
        }
        return null;
    }

    public void alterarVida(Carta carta){
        this.setVida(this.getVida() - carta.getPoder());
    }

    public void alterarMana(Carta carta){
        this.setMana(this.getMana() - carta.getCustoMana());
    }

    public void removerCarta(Carta carta){
        this.mao.removerCarta(carta);
    }

    public void adicionarCarta(Carta carta){
        this.mao.adicionarCarta(carta);
    }
}
