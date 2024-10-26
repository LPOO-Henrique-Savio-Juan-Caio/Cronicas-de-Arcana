package main;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static String jogador1;
    public static String jogador2;
    

    

    public static void main(String[] args) {
        //nesse caso precisei criar a janela aqui pra ter controle sobre a hora dela fechar e etc
        JFrame frame = new JFrame();

        // Menu menu = new Menu(frame);
        // menu.menuStart();

        //o codigo de cima é o correto, por enquanto vou instancia game direto aqui pra testar mais facil a tela de jogo:
        DeckPadrao deckpadrao = new DeckPadrao();
        jogador1 = "juan";
        jogador2 = "caio";
        ArrayList<String> deckJogador1;
        ArrayList<String> deckJogador2;
        deckJogador1 = deckpadrao.getDeckPadrao1();
        deckJogador2 = deckpadrao.getDeckPadrao2();

        Game game = new Game(jogador1, jogador2, deckJogador1, deckJogador2, frame);
        game.gameStart();

    }
}
