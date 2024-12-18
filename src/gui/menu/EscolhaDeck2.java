package gui.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import cartas.CartasJogo;
import cartas.DeckPadrao;
import main.Game;
import static gui.menu.TelaInicial.fonteCustomizada1;
import static soundTrack.SoundManager.playSoundEffect;

public class EscolhaDeck2 {

    private JPanel panel1;
    DeckPadrao deckPadrao = new DeckPadrao();
    private String jogador1;
    private String jogador2;
    private ArrayList<String> deckJogador1;
    private ArrayList<String> deckJogador2;

    //variaveis do GUI
    private JButton deck1Botao;
    private JButton deck2Botao;
    private JFrame frame;

    public EscolhaDeck2(String jogador1, String jogador2, ArrayList<String> deckJogador1, JFrame frame) {
        this.frame = TelaInicial.getFrame();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;

        //conteiner da tela
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel1.setBackground(Color.WHITE);
        
        Border bordaPreta = BorderFactory.createLineBorder(Color.BLACK, 3);
        panel1.setBorder(bordaPreta);

        //titulo
        Font fontePersonalizada = fonteCustomizada1;
        JLabel titulomenu3 = new JLabel(jogador2 + " ESCOLHA SEU DECK:");
        titulomenu3.setFont(fontePersonalizada);
        titulomenu3.setForeground(Color.BLACK);

        // ajuste posição do titulo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 20, 0); // Espaçamento superior e inferior
        gbc.anchor = GridBagConstraints.NORTH; // Garante que o título fique no topo
        panel1.add(titulomenu3, gbc);

        // deck1(botao)
        deck1Botao = new JButton("Deck1");
        deck1Botao.setFont(fontePersonalizada);
        deck1Botao.setBackground(Color.BLACK);
        deck1Botao.setForeground(Color.WHITE);
        deck1Botao.setPreferredSize(new Dimension(120, 180)); // Aumenta o tamanho do botão

        //posição botao deck1
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10); // Define espaçamento ao redor do botão
        panel1.add(deck1Botao, gbc);

        // deck2(botao)
        deck2Botao = new JButton("Deck2");
        deck2Botao.setFont(fontePersonalizada);
        deck2Botao.setBackground(Color.BLACK);
        deck2Botao.setForeground(Color.WHITE);
        deck2Botao.setPreferredSize(new Dimension(120, 180)); // Aumenta o tamanho do botão

        //posição botao2
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel1.add(deck2Botao, gbc);


        //ações do botoes

        deck1Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adcione o deck1 para o jogador2
                deckJogador2 = deckPadrao.getDeckPadrao1();


                    //instancia e inicia o jogo
                    Game game = new Game(jogador1, jogador2, deckJogador1, deckJogador2, frame);
                    game.gameStart();
                    //game é instanciado com o proprio frame ent n precisamos fechar

            }
        });

        deck2Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adciona o deck2 para o jogador2
                deckJogador2 = deckPadrao.getDeckPadrao2();

               //instacia e inicia o jogo
                Game game = new Game(jogador1, jogador2, deckJogador1, deckJogador2, frame);
                game.gameStart();
                //game é instanciado com o proprio frame ent n precisamos fechar




            }
        });
    }

    //tela do jogo
    public void menu3Start() {
    	new Thread(() -> playSoundEffect("arquivos/soundtracks/clickButtom01.wav")).start();
        //JFrame frame = new JFrame("Cronicas de Arcana");
        frame.setContentPane(new EscolhaDeck2(jogador1, jogador2, deckJogador1, frame).panel1); // Adiciona o painel da interface
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao clicar em "X"

        // Define a resolução 1024x768
        Dimension resolution4x3 = new Dimension(1024, 768);
        frame.setMinimumSize(resolution4x3); // Define o tamanho mínimo da janela
        frame.setSize(resolution4x3); // Define o tamanho inicial da janela
        frame.setMaximumSize(resolution4x3); // Define o tamanho máximo para manter a proporção

        frame.setVisible(true);  // Torna a janela visível
    }
}