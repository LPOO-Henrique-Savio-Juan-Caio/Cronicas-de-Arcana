
package main;

import CronicasDeArcana.CampodeBatalha;
import CronicasDeArcana.Carta;
import CronicasDeArcana.Jogador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

// oq falta: 
// implantar uma logica de trocar as cartas da mao
// usar o campo de batalha, uma vez q as cartas sao usadas vao para o campo de batalha e podem sofrer dano
//quando a vida de uma carta acabar ela vai para o cemiterio, e entra a proxima carta do deck na mao

//0.1 = removerCarta alem de remover adciona a proxima do deck


// 1 - cartas indo pro campo de batalha ao serem escolhidas ( mudando posição na tela)
// 2 - cartas dando dano nas cartas do campo de batalha do outro jogador
// 3 - cartas "morrendo e indo pro cemiterio"

public class Game {

    private Jogador jogador1;
    private Jogador jogador2;
    private boolean isTurnoJogador1 = true;
    private boolean manaInsuficiente = true;

    private JFrame frame;
    private JPanel panel1;
    private JLabel playerInfo1, playerInfo2;
    private JPanel player1CardsPanel, player2CardsPanel;
    private CampodeBatalha campoBatalha;

    public Game(String nome1, String nome2, ArrayList<String> deckJogador1, ArrayList<String> deckJogador2, JFrame frame) {
        this.frame = frame;

        jogador1 = new Jogador(nome1, new CartasJogo().getArrayCartas(), deckJogador1);
        jogador2 = new Jogador(nome2, new CartasJogo().getArrayCartas(), deckJogador2);


        //instanciando o campo de batalha
        campoBatalha = new CampodeBatalha();


        initUI();
        gameStart();
    }

    private void initUI() {
        panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.BLACK);

        JPanel playerInfoPanel = new JPanel(new BorderLayout());
        playerInfoPanel.setBackground(Color.BLACK);

        playerInfo1 = new JLabel(createPlayerInfo(jogador1));
        setupPlayerLabel(playerInfo1);
        JPanel player1Panel = new JPanel();
        player1Panel.setBackground(Color.BLACK);
        player1Panel.add(playerInfo1);

        playerInfo2 = new JLabel(createPlayerInfo(jogador2));
        setupPlayerLabel(playerInfo2);
        JPanel player2Panel = new JPanel();
        player2Panel.setBackground(Color.BLACK);
        player2Panel.add(playerInfo2);

        playerInfoPanel.add(player1Panel, BorderLayout.WEST);
        playerInfoPanel.add(player2Panel, BorderLayout.EAST);
        panel1.add(playerInfoPanel, BorderLayout.NORTH);

        player1CardsPanel = createPlayerCardsPanel(jogador1, jogador2);
        player2CardsPanel = createPlayerCardsPanel(jogador2, jogador1);

        panel1.add(player1CardsPanel, BorderLayout.WEST);
        panel1.add(player2CardsPanel, BorderLayout.EAST);
    }

    private JPanel createPlayerCardsPanel(Jogador jogador, Jogador jogadorRival) {
        JPanel playerCardsPanel = new JPanel();
        playerCardsPanel.setLayout(new BoxLayout(playerCardsPanel, BoxLayout.Y_AXIS));
        playerCardsPanel.setBackground(Color.BLACK);

        for (Carta carta : jogador.getMao().getCartasMao()) {
            JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
            cardButton.setPreferredSize(new Dimension(100, 60));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            cardButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    jogarCarta(jogador, carta, jogadorRival);
                }
            });
            playerCardsPanel.add(cardButton);
            playerCardsPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        }
        return playerCardsPanel;
    }

    private void setupPlayerLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
    }

    private String createPlayerInfo(Jogador jogador) {
        return "<html>" + jogador.getNome() + "<br>Vida: " + jogador.getVida() + "<br>Mana: " + jogador.getMana() + "</html>";
    }

    //obs: apenas cartas na mao podem ser jogadas, depois que forem jogadas vao para o campo de batalha e entao sao apenas usadas
    private void jogarCarta(Jogador jogador, Carta carta, Jogador jogadorRival) {
        if ((isTurnoJogador1 && jogador.equals(jogador1)) || (!isTurnoJogador1 && jogador.equals(jogador2))) {
            if (jogador.getMana() >= carta.getCustoMana()) {
                
                //usa carta e remove da mao: a ideia é adicionar ela no campo de batalha depois de remover da mao
                usarCarta(jogador, carta, jogadorRival);
                campoBatalha.adicionarCartaAoCampo(carta);
                jogador.getMao().removerCarta(carta); // remove carta da mao e adciona outra de deck no lugar
                //envia a carta pro campo de batalha
                SendCampodeBatalha(carta);
    
                
                // pega o painel do jogador q jogou
                JPanel playerPanel = jogador.equals(jogador1) ? player1CardsPanel : player2CardsPanel;
                //remove tudo
                playerPanel.removeAll();
                
                //e constroi novamente com a carta atualizada
                for (Carta cartaAtual : jogador.getMao().getCartasMao()) {
                    JButton cardButton = new JButton(cartaAtual.getNome() + " (Mana: " + cartaAtual.getCustoMana() + ")");
                    cardButton.setPreferredSize(new Dimension(100, 60));
                    cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    
                    cardButton.addActionListener(e -> jogarCarta(jogador, cartaAtual, jogadorRival));
    
                    playerPanel.add(cardButton);
                    playerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
                }
    
                // Atualiza a interface gráfica
                playerPanel.revalidate();
                playerPanel.repaint();
                atualizarPainelJogadores();
                passarTurno();
            } else {
                JOptionPane.showMessageDialog(frame, "Mana insuficiente!");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Não é o seu turno!");
        }
    }

    //enviar uma carta ao campo de batalha apos ela ser "jogada"
    public void SendCampodeBatalha(Carta carta){
        campoBatalha.adicionarCartaAoCampo(carta);
        //depois disso construir um for para criar as cartas de campo de batalha


    }
    
    
        

          

    private void atualizarPainelJogadores() {
        playerInfo1.setText(createPlayerInfo(jogador1));
        playerInfo2.setText(createPlayerInfo(jogador2));
        frame.revalidate();
        frame.repaint();
    }

    private void passarTurno() {
        isTurnoJogador1 = !isTurnoJogador1;
    
        // Checa as condições de vitória:
        if (jogador1.getVida() <= 0) {
            JOptionPane.showMessageDialog(frame, "Vitória de " + jogador2.getNome()); 
            frame.dispose(); 
            return;
        } else if (jogador2.getVida() <= 0) {
            JOptionPane.showMessageDialog(frame, "Vitória de " + jogador1.getNome()); 
            frame.dispose(); 
            return;
        }

        // Verifica mana no início do turno:
        Jogador jogadorAtual = isTurnoJogador1 ? jogador1 : jogador2;
        Jogador proximoJogador = isTurnoJogador1 ? jogador2 : jogador1;
        if (verificarMana(jogadorAtual) && verificarMana(proximoJogador)) {
            JOptionPane.showMessageDialog(frame, "Mana insuficiente para ambos, EMPATE");
            frame.dispose();  // Chama recursivamente para passar para o próximo turno
        } 
        else if (verificarMana(jogadorAtual)) { 
            JOptionPane.showMessageDialog(frame, "Mana insuficiente para " + jogadorAtual.getNome() + ". Pulando turno...");
            passarTurno();
        }
        else {
            JOptionPane.showMessageDialog(frame, "Turno de " + jogadorAtual.getNome());
        }
    }

    //Por enquanto como ainda temos apenas criaturas, a carta tira vida e gasta mana
    public void usarCarta(Jogador jogador, Carta carta, Jogador jogadorRival){
        jogador.alterarMana(carta);
        jogadorRival.alterarVida(carta);

    }



    private boolean  verificarMana(Jogador jogador) {
        manaInsuficiente = true; // Supõe que a mana é insuficiente inicialmente
    
        for (Carta carta : jogador.getMao().getCartasMao()) {
            if (jogador.getMana() >= carta.getCustoMana()) {
                manaInsuficiente = false; // Suficiente para pelo menos uma carta
                return manaInsuficiente; // Interrompe o loop, já que encontramos uma carta jogável
            }

        
        }

        return manaInsuficiente;
    }

 


    public void gameStart() {
        frame.setContentPane(this.panel1);
        frame.setMinimumSize(new Dimension(800, 474));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // System.out.println(jogador1.toString());
        // System.out.println(jogador2.toString());
    }
}
