package main;

import CronicasDeArcana.Jogador;
import java.awt.*;
import javax.swing.*;

public class Game {
    //aqui onde faremos toda logica do jogo
    //outra class vai receber o gui

    //como primeira parte do jogo, vamos instanciar jogador1, jogador2
    //esses jogadores vao receber nome e seu deck
    //obviamente pretendo criar um meno que recebera essas informações



    private Jogador jogador1;
    private Jogador jogador2;
    private String nome1;
    private String nome2;
    private String[] deckjogador1;
    private String[] deckjogador2;

    CartasJogo cartasjogo = new CartasJogo();

    //componentes gui
    private JFrame frame;
    private JPanel panel1;






    //construtor para instanciar essas classes
    //obviamente esse construtor sera preenchido no menu do jogo
    public Game(String nome1, String nome2, String[] deckJogador1, String[] deckJogador2, JFrame frame ) {
        this.frame = frame;

        this.nome1 = nome1;
        this.nome2 = nome2;
        this.deckjogador1 = deckJogador1;
        this.deckjogador2 = deckJogador2;

         


        //instanciando os jogadores
        jogador1 = new Jogador(nome1, cartasjogo.getArrayCartas(), deckJogador1);
        jogador2 = new Jogador(nome2, cartasjogo.getArrayCartas(), deckJogador2);
        


        //container da tela
        panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.BLACK);

        //obs: aqui estamos usando o layout: BorderLayout() - organiza os componentes de acordo com norte, sul, leste e oeste

        // painel para info dos jogadores
        JPanel playerInfoPanel = new JPanel(new BorderLayout());
        playerInfoPanel.setBackground(Color.BLACK);

        // info do jogador1 - esquerda:
        //posição, estilização e composição do panel:
        JPanel player1Panel = new JPanel();
        player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.Y_AXIS));
        player1Panel.setBackground(Color.BLACK);
        JLabel playerInfo1 = new JLabel("<html>" + nome1 + "<br>Vida: " + jogador1.getVida() + "<br>Mana: " + jogador1.getMana() + "</html>");
        playerInfo1.setFont(new Font("Arial", Font.BOLD, 14));
        playerInfo1.setForeground(Color.WHITE);
        player1Panel.add(playerInfo1);

        // info do jogador2 - direita:
        //posição, estilização e composição do panel:
        JPanel player2Panel = new JPanel();
        player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.Y_AXIS));
        player2Panel.setBackground(Color.BLACK);
        JLabel playerInfo2 = new JLabel("<html>" + nome2 + "<br>Vida: " + jogador2.getVida() + "<br>Mana: " + jogador2.getMana() + "</html>");
        playerInfo2.setFont(new Font("Arial", Font.BOLD, 14));
        playerInfo2.setForeground(Color.WHITE);
        player2Panel.add(playerInfo2);

        //add componente
        playerInfoPanel.add(player1Panel, BorderLayout.WEST);
        playerInfoPanel.add(player2Panel, BorderLayout.EAST);

        // add componente ao principal
        panel1.add(playerInfoPanel, BorderLayout.NORTH);

       // cartas na mao do jogador1 - esquerda (container)
        JPanel player1CardsPanel = new JPanel();
        player1CardsPanel.setLayout(new BoxLayout(player1CardsPanel, BoxLayout.Y_AXIS));
        player1CardsPanel.setBackground(Color.BLACK);
        player1CardsPanel.setPreferredSize(new Dimension(80, 280)); // Tamanho ajustado para acomodar o espaçamento

        //carta por carta a ser colocada no container
        //obs: ainda n sei como vou atribuir uma carta da mao aos botoes, talves tenha q tirar o for e criar individualmente
        for (int i = 0; i < 5; i++) {
            JButton cardButton = new JButton("Carta " + (i + 1));
            cardButton.setPreferredSize(new Dimension(80, 40)); // 80 de largura e 40 de altura
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza os botões no painel
            player1CardsPanel.add(cardButton);
            player1CardsPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espaçamento vertical de 10px
        }

        // cartas na mao do jogador2 - direita(container)
        JPanel player2CardsPanel = new JPanel();
        player2CardsPanel.setLayout(new BoxLayout(player2CardsPanel, BoxLayout.Y_AXIS));
        player2CardsPanel.setBackground(Color.BLACK);
        player2CardsPanel.setPreferredSize(new Dimension(80, 280)); // Tamanho ajustado para acomodar o espaçamento

        //carta por carta a ser colocada no container
        //obs: ainda n sei como vou atribuir uma carta da mao aos botoes, talves tenha q tirar o for e criar individualmente
        for (int i = 0; i < 5; i++) {
            JButton cardButton = new JButton("Carta " + (i + 1));
            cardButton.setPreferredSize(new Dimension(80, 40)); // 80 de largura e 40 de altura
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza os botões no painel
            player2CardsPanel.add(cardButton);
            player2CardsPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espaçamento vertical de 10px
        }

        // add container de carta ao container principal
        panel1.add(player1CardsPanel, BorderLayout.WEST);
        panel1.add(player2CardsPanel, BorderLayout.EAST);


        
        
        

    }


    //na intenção de testar se as informações estavam sendo recebidas
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game Info:\n");
        sb.append("Jogador 1: ").append(nome1).append("\n");
        sb.append("Deck Jogador 1: ").append(deckjogador1 != null ? String.join(", ", deckjogador1) : "N/A").append("\n");
        sb.append("Jogador 2: ").append(nome2).append("\n");
        sb.append("Deck Jogador 2: ").append(deckjogador2 != null ? String.join(", ", deckjogador2) : "N/A").append("\n");
        return sb.toString();
    }



    //tela
    //por enquanto vou fazer um main aqui:
    public void gameStart(){

        //teste das infos
        
        // Use a instância atual (this) em vez de criar uma nova instância de Game
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(this.panel1); 
        frame.setMinimumSize(new Dimension(800,474));// Adiciona o painel da classe Menu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configura para fechar ao clicar no 'X'
        frame.pack();  // Ajusta o tamanho da janela para caber nos componentes
        frame.setVisible(true);  // Torna a janela visível
        

    }

    
}
