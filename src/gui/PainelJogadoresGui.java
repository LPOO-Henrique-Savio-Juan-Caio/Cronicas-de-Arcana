package gui;

import entidades.Jogador;
import main.Game;
import logica.Logica;
import java.awt.*;
import javax.swing.*;
import static gui.menu.TelaInicial.fonteCustomizada1;

public class PainelJogadoresGui {

    private Game game;
    private Jogador jogador1;
    private Jogador jogador2;
    private JFrame frame;
    private Logica logica;

    public PainelJogadoresGui(Game game, Jogador jogador1, Jogador jogador2, JFrame frame, Logica logica ){
        this.game = game;
        this.frame = frame;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.logica = logica;
        
    }


    public void atualizarPainelJogadores() {
        game.getPlayerInfo1().setText(createPlayerInfo(jogador1));
        game.getPlayerInfo2().setText(createPlayerInfo(jogador2));
        frame.revalidate();
        frame.repaint();
    }

    public String createPlayerInfo(Jogador jogador) {
    	String informacoes = jogador.getNome() + "Vida: " + jogador.getVida() + "  Mana: " + jogador.getMana();
        return informacoes;
    }

    public void setupPlayerLabel(JLabel label) {
        label.setFont(fonteCustomizada1);
        label.setForeground(Color.WHITE);
    }

}
