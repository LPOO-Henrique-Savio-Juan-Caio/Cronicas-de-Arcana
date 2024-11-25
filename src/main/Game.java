package main;

import cartas.CartasJogo;
import entidades.*;
import gui.PainelJogadoresGui;
import gui.menu.TelaInicial;
import gui.zonas.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import gui.background.BackgroundPanel;
import logica.*;
import static gui.menu.TelaInicial.fonteCustomizada1;
import static soundTrack.SoundManager.playSoundEffect;

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
    private PainelJogadoresGui painelJogadores;
    private Logica logica;
    private MaoGui maoGui;
    private CemiterioGui cemiterioGui;
    private Image backgroundImage = new ImageIcon("arquivos/imagens/tabuleiroFundo.jpg").getImage();

    //instanciando progressao sem reiniciar os dados
    Progressao progressao = Progressao.getInstancia();

    public Game(String nome1, String nome2, ArrayList<String> deckJogador1, ArrayList<String> deckJogador2, JFrame frame) {
        this.frame = TelaInicial.getFrame();

        jogador1 = new Jogador(nome1, new CartasJogo().getArrayCartas(), deckJogador1);
        jogador2 = new Jogador(nome2, new CartasJogo().getArrayCartas(), deckJogador2);

        //inicializando componentes
        logica = new Logica(this, jogador1, jogador2, frame);
        campobatalhaGui = new CampoBatalhaGui(this, jogador1, jogador2, frame, logica);
        painelJogadores = new PainelJogadoresGui(this, jogador1, jogador2, frame, logica);
        maoGui = new MaoGui(this, jogador1, jogador2, frame, logica);
        cemiterioGui = new CemiterioGui(this, jogador1, jogador2, frame, logica);

        //add jogador a lista (caso ja n esteja)
        progressao.addJogador(nome1);
        progressao.addJogador(nome2);

        initUI();
        gameStart();
    }

    private void initUI() {
        // Cria o painel principal com fundo
        panel1 = new BackgroundPanel(backgroundImage);
        panel1.setLayout(new BorderLayout()); // Usando BorderLayout para melhor organização
        Border bordaPreta = BorderFactory.createLineBorder(Color.BLACK, 3);
        panel1.setBorder(bordaPreta);

        // Painel de informações dos jogadores (parte superior)
        JPanel playerInfoPanel = new JPanel(new GridLayout(1, 2));
        playerInfoPanel.setBackground(new Color(0, 0, 0, 0)); // Cor de fundo com transparência
        playerInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem interna
        playerInfoPanel.setFont(fonteCustomizada1);

        // Informações do Jogador 1
        playerInfo1 = new JLabel(painelJogadores.createPlayerInfo(jogador1), JLabel.CENTER);
        painelJogadores.setupPlayerLabel(playerInfo1);
        playerInfo1.setFont(fonteCustomizada1);
        playerInfoPanel.add(playerInfo1);

        // Informações do Jogador 2
        playerInfo2 = new JLabel(painelJogadores.createPlayerInfo(jogador2), JLabel.CENTER);
        painelJogadores.setupPlayerLabel(playerInfo2);
        playerInfo2.setFont(fonteCustomizada1);
        playerInfoPanel.add(playerInfo2);

        // Adiciona o painel de informações na parte superior
        panel1.add(playerInfoPanel, BorderLayout.NORTH);

        // Jogador 1 painéis de mão e cemitério (lados)
        JPanel player1SidePanel = new JPanel();
        player1SidePanel.setLayout(null);
        player1SidePanel.setPreferredSize(new Dimension(160, 500));
        player1SidePanel.setBackground(new Color(0, 0, 0, 0)); // Fundo com transparência
        player1SidePanel.setFont(fonteCustomizada1);

        player1MaoPanel = maoGui.createMaoPanel(jogador1, jogador2, 33, 4);
        player1MaoPanel.setBounds(0, 0, 150, 520);
        player1SidePanel.add(player1MaoPanel);

        ImageIcon cemiterioJogador1 = new ImageIcon("arquivos/imagens/jogador1Cemiterio.png");
        Image jogador1Escala = cemiterioJogador1.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        cemiterioJogador1 = new ImageIcon(jogador1Escala);

        player1Cemiterio = cemiterioGui.createCemiterioPanel(jogador1, jogador2, 10, 10, cemiterioJogador1);
        player1Cemiterio.setBackground(new Color(0, 0, 0, 0));
        player1Cemiterio.setBounds(new Rectangle(23, 548, 130, 80));
        player1SidePanel.add(player1Cemiterio);

        // Jogador 2 painéis de mão e cemitério (lados)
        JPanel player2SidePanel = new JPanel();
        player2SidePanel.setLayout(null);
        player2SidePanel.setBackground(new Color(0, 0, 0, 0)); // Fundo com transparência
        player2SidePanel.setFont(fonteCustomizada1);
        player2SidePanel.setPreferredSize(new Dimension(160, 500));

        player2MaoPanel = maoGui.createMaoPanel(jogador2, jogador1, 5, 130);
        player2MaoPanel.setBounds(10, 7, 150, 645);
        player2SidePanel.add(player2MaoPanel);

        ImageIcon cemiterioJogador2 = new ImageIcon("arquivos/imagens/jogador2Cemiterio.png");
        Image jogador2Escala = cemiterioJogador2.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        cemiterioJogador2 = new ImageIcon(jogador2Escala);

        player2Cemiterio = cemiterioGui.createCemiterioPanel(jogador2, jogador1, 10, 10, cemiterioJogador2);
        player2Cemiterio.setBackground(new Color(0, 0, 0, 0));
        player2Cemiterio.setBounds(new Rectangle(10, 10, 110, 80));
        player2SidePanel.add(player2Cemiterio);

        // Adiciona os painéis laterais ao painel principal
        panel1.add(player1SidePanel, BorderLayout.WEST);
        panel1.add(player2SidePanel, BorderLayout.EAST);

        // Campo de batalha (parte central)
        JPanel centralBattlePanel = new JPanel();
        centralBattlePanel.setLayout(null);
        centralBattlePanel.setBackground(new Color(0, 0, 0, 0));
        centralBattlePanel.setPreferredSize(new Dimension(600, 530));
        centralBattlePanel.setFont(fonteCustomizada1);
        centralBattlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem interna

        //campo de batalha jogador 1
        player1CampoBatalhaPanel = campobatalhaGui.createCampoBatalhaPanel(jogador1, jogador2);
        player1CampoBatalhaPanel.setLayout(null);
        player1CampoBatalhaPanel.setBounds(new Rectangle(10, 10, 180, 610));

        //campo de batalha jogador 2
        player2CampoBatalhaPanel = campobatalhaGui.createCampoBatalhaPanel(jogador2, jogador1);
        player2CampoBatalhaPanel.setLayout(null);
        player2CampoBatalhaPanel.setBounds(new Rectangle(480, 10, 180, 610));

        centralBattlePanel.add(player1CampoBatalhaPanel);
        centralBattlePanel.add(player2CampoBatalhaPanel);

        // Adiciona o campo de batalha na parte central
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
        new Thread(() -> playSoundEffect("arquivos/soundtracks/clickButtom01.wav")).start();
        frame.setTitle("Cronicas de Arcana");
        frame.setContentPane(panel1); // Adiciona o painel da interface
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao clicar em "X"

        // Define a resolução 1024x768
        Dimension resolution4x3 = new Dimension(1024, 768);
        frame.setMinimumSize(resolution4x3); // Define o tamanho mínimo da janela
        frame.setSize(resolution4x3); // Define o tamanho inicial da janela
        frame.setMaximumSize(resolution4x3); // Define o tamanho máximo para manter a proporção
        frame.pack();
        frame.setVisible(true);
    }
}