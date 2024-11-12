package main;

import cartas.CartasJogo;
import entidades.*;
import gui.PainelJogadoresGui;
import gui.zonas.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import logica.*;

//questoes sobre a logica do jogo:
//obs: as cartas jogadas na mao dao dano nas cartas que ja estao no campo de batalha?
//obs2: as cartas (que estao no campo) darao dano em todas as cartas que estao no campo do rival?
//obs2.1: o dano das cartas nas cartas do campo rival sera 100% do dado?
//obs3: a mana aumenta por round!

//PROGRESSAO: a estrutura da progressao esta toda criada na classe "Progressao", todo começo de jogo
//é chamada a função addJogador para ambos os jogadores, mas o jogador so é adcionado se por acaso ele ainda
//nao estiver na lista.
//quando decretado o vencedor eh chamada a função addVitoria para o jogador vencedor
//pretendo criar uma tela onde mostre os jogadores e sua respectivas vitorias em uma especia de ranking
//obs: progressao é instanciada de uma maneira interessante (ainda nao testei), mas aparentemente pode ser instanciada em qlqr classe

//fiz hoje:
//4 - separar as funções em classes diferentes (logica , guimao, guicampo...etc)
//5 - clicar com botao direito nas cartas mostra suas informações

//estamos aqui: 
//5 - funcionamento de encantamento(continua com efeito em X rounds) e feitiço(de boinha) - ambos nao vao para o campo de batalha
//6 - mostrar vida das cartas que estao no campo de batalha
//7 - tela ranking jogadores
//8 - tela instruções do jogo

//obs: tentei implementar feitiço mas ficou muito confuso.

public class Game {


    private Jogador jogador1;
    private Jogador jogador2;

    private JFrame frame;
    private JPanel panel1;
    private JLabel playerInfo1, playerInfo2;
    private JPanel player1MaoPanel, player2MaoPanel;
    private JPanel player1CampoBatalhaPanel, player2CampoBatalhaPanel;
    private JPanel player1Cemiterio, player2Cemiterio;

    private CampoBatalhaGui campobatalhaGui;
    private PainelJogadoresGui paineljogadores;
    private Logica logica;
    private MaoGui maoGui;
    private CemiterioGui cemiteriogui;

    //instanciando progressao sem reiniciar os dados
    Progressao progressao = Progressao.getInstancia();

    public Game(String nome1, String nome2, ArrayList<String> deckJogador1, ArrayList<String> deckJogador2, JFrame frame) {
        this.frame = frame;

        jogador1 = new Jogador(nome1, new CartasJogo().getArrayCartas(), deckJogador1);
        jogador2 = new Jogador(nome2, new CartasJogo().getArrayCartas(), deckJogador2);

        //inicializando componentes
        logica = new Logica(this, jogador1, jogador2, frame);
        campobatalhaGui = new CampoBatalhaGui(this, jogador1, jogador2, frame, logica);
        paineljogadores = new PainelJogadoresGui(this, jogador1, jogador2, frame, logica);
        maoGui = new MaoGui(this, jogador1, jogador2, frame, logica);
        cemiteriogui = new CemiterioGui(this, jogador1, jogador2, frame, logica);
        
        //add jogador a lista (caso ja n esteja)
        progressao.addJogador(nome1);
        progressao.addJogador(nome2);

        initUI();
        gameStart();
    }

    private void initUI() {
        panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(new Color(0, 128, 0));
    
        // gui de informações dos jogadores
        JPanel playerInfoPanel = new JPanel(new BorderLayout());
        playerInfoPanel.setBackground(new Color(0, 128, 0));
    
        // Configurações para o Jogador 1
        playerInfo1 = new JLabel(paineljogadores.createPlayerInfo(jogador1));
        paineljogadores.setupPlayerLabel(playerInfo1);
        JPanel player1Panel = new JPanel();
        player1Panel.setBackground(new Color(0, 128, 0));
        player1Panel.add(playerInfo1);
    
        // Configurações para o Jogador 2
        playerInfo2 = new JLabel(paineljogadores.createPlayerInfo(jogador2));
        paineljogadores.setupPlayerLabel(playerInfo2);
        JPanel player2Panel = new JPanel();
        player2Panel.setBackground(new Color(0, 128, 0));
        player2Panel.add(playerInfo2);
    
        playerInfoPanel.add(player1Panel, BorderLayout.WEST);
        playerInfoPanel.add(player2Panel, BorderLayout.EAST);
        panel1.add(playerInfoPanel, BorderLayout.NORTH);
    
        // Painéis de mão dos jogadores (lados)
        player1MaoPanel = maoGui.createMaoPanel(jogador1, jogador2);
        player1MaoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem

    
        player2MaoPanel = maoGui.createMaoPanel(jogador2, jogador1);
        player2MaoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem

        //gui cemiterio
        player1Cemiterio = cemiteriogui.createCemiterioPanel(jogador1);
        player2Cemiterio = cemiteriogui.createCemiterioPanel(jogador2);

        // Painel vertical para o Jogador 1 (contém mão e cemitério)
        JPanel player1SidePanel = new JPanel();
        player1SidePanel.setLayout(new BoxLayout(player1SidePanel, BoxLayout.Y_AXIS));
        player1SidePanel.setBackground(new Color(0, 128, 0));
        player1SidePanel.add(player1MaoPanel);
        player1SidePanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espaço entre mão e cemitério
        player1SidePanel.add(player1Cemiterio);
        player1SidePanel.setPreferredSize(new Dimension(200, 300));

        // Painel vertical para o Jogador 2 (contém mão e cemitério)
        JPanel player2SidePanel = new JPanel();
        player2SidePanel.setLayout(new BoxLayout(player2SidePanel, BoxLayout.Y_AXIS));
        player2SidePanel.setBackground(new Color(0, 128, 0));
        player2SidePanel.add(player2MaoPanel);
        player2SidePanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espaço entre mão e cemitério
        player2SidePanel.add(player2Cemiterio);
        player2SidePanel.setPreferredSize(new Dimension(200, 400));
    
        // Painéis do campo de batalha dos jogadores
        player1CampoBatalhaPanel = campobatalhaGui.createCampoBatalhaPanel(jogador1, jogador2);
        player1CampoBatalhaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
    
        player2CampoBatalhaPanel = campobatalhaGui.createCampoBatalhaPanel(jogador2, jogador1);
        player2CampoBatalhaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
    
        // gui principal central para o campo de batalha
        JPanel centralBattlePanel = new JPanel(new BorderLayout());
        centralBattlePanel.setBackground(new Color(0, 128, 0));
        centralBattlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
    
        // Adicionando os campos de batalha dos jogadores no painel central
        centralBattlePanel.add(player1CampoBatalhaPanel, BorderLayout.WEST);
        centralBattlePanel.add(player2CampoBatalhaPanel, BorderLayout.EAST);

        
        // Posicionando os painéis de mão e campo de batalha
        panel1.add(player1SidePanel, BorderLayout.WEST);
        panel1.add(player2SidePanel, BorderLayout.EAST);
        panel1.add(centralBattlePanel, BorderLayout.CENTER);
    }

    public JLabel getPlayerInfo1() {
        return playerInfo1;
    }
    
    public JLabel getPlayerInfo2() {
        return playerInfo2;
    }

    public JPanel getplayer1CampoBatalhaPanel(){
        return player1CampoBatalhaPanel;
    }

    public JPanel getplayer2CampoBatalhaPanel(){
        return player2CampoBatalhaPanel;
    }

    public JPanel getplayer1MaoPanel(){
        return player1MaoPanel;
    }

    public JPanel getplayer2MaoPanel(){
        return player2MaoPanel;
    }
    
    



    public void gameStart() {
        frame.setTitle("Cronicas de Arcana");
        frame.setContentPane(panel1); // Adiciona o painel da interface
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao clicar em "X"

        // Define a resolução com proporção 4:3 (por exemplo, 1024x768)
        Dimension resolution4x3 = new Dimension(1024, 768);
        frame.setMinimumSize(resolution4x3); // Define o tamanho mínimo da janela
        frame.setSize(resolution4x3); // Define o tamanho inicial da janela
        frame.setMaximumSize(resolution4x3); // Define o tamanho máximo para manter a proporção
        frame.pack();
        frame.setVisible(true);

        // System.out.println(jogador1.toString());
        // System.out.println(jogador2.toString());
    }
}