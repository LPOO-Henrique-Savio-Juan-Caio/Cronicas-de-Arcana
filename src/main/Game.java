
package main;

import CronicasDeArcana.CampodeBatalha;
import CronicasDeArcana.Carta;
import CronicasDeArcana.Jogador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

// oq fiz hj: 
//0 - cada jogador precisa ter seu "campodebatalha"
//1 - criar GUI para cartas no campo de batalha
//2.1 - cartas no campo de batalha n gastam mana para atacar
//2 - criar logica de dano nas cartas que estao no campo de batalha
//2.1 - cartas no campo de batalha tb levam dano


//estamos aqui: 
//obs: mana insuficiente nao é suficiente para acabar o jogo, as cartas no campo tb precisam estar vazias
//3 - cartas serem mandados pro cemiterio apos "morrerem"
//4 - gui do cemiterio
//5 - funcionamento de encantamento(continua com efeito em X rounds)
//6 - mostrar vida das cartas que estao no campo de batalha

public class Game {

    private Jogador jogador1;
    private Jogador jogador2;
    private boolean isTurnoJogador1 = true;
    private boolean manaInsuficiente = true;

    private JFrame frame;
    private JPanel panel1;
    private JLabel playerInfo1, playerInfo2;
    private JPanel player1MaoPanel, player2MaoPanel;
    private JPanel player1CampoBatalhaPanel, player2CampoBatalhaPanel;

    public Game(String nome1, String nome2, ArrayList<String> deckJogador1, ArrayList<String> deckJogador2, JFrame frame) {
        this.frame = frame;

        jogador1 = new Jogador(nome1, new CartasJogo().getArrayCartas(), deckJogador1);
        jogador2 = new Jogador(nome2, new CartasJogo().getArrayCartas(), deckJogador2);


        //instanciando o campo de batalha
        


        initUI();
        gameStart();
    }

    private void initUI() {
        panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.BLACK);
    
        // Painel de informações dos jogadores
        JPanel playerInfoPanel = new JPanel(new BorderLayout());
        playerInfoPanel.setBackground(Color.BLACK);
    
        // Configurações para o Jogador 1
        playerInfo1 = new JLabel(createPlayerInfo(jogador1));
        setupPlayerLabel(playerInfo1);
        JPanel player1Panel = new JPanel();
        player1Panel.setBackground(Color.BLACK);
        player1Panel.add(playerInfo1);
    
        // Configurações para o Jogador 2
        playerInfo2 = new JLabel(createPlayerInfo(jogador2));
        setupPlayerLabel(playerInfo2);
        JPanel player2Panel = new JPanel();
        player2Panel.setBackground(Color.BLACK);
        player2Panel.add(playerInfo2);
    
        playerInfoPanel.add(player1Panel, BorderLayout.WEST);
        playerInfoPanel.add(player2Panel, BorderLayout.EAST);
        panel1.add(playerInfoPanel, BorderLayout.NORTH);
    
        // Painéis de mão dos jogadores (lados)
        player1MaoPanel = createMaoPanel(jogador1, jogador2);
        player1MaoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
    
        player2MaoPanel = createMaoPanel(jogador2, jogador1);
        player2MaoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
    
        // Painéis do campo de batalha dos jogadores
        player1CampoBatalhaPanel = createCampoBatalhaPanel(jogador1, jogador2);
        player1CampoBatalhaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
    
        player2CampoBatalhaPanel = createCampoBatalhaPanel(jogador2, jogador1);
        player2CampoBatalhaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
    
        // Painel principal central para o campo de batalha
        JPanel centralBattlePanel = new JPanel(new BorderLayout());
        centralBattlePanel.setBackground(Color.BLACK);
        centralBattlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
    
        // Adicionando os campos de batalha dos jogadores no painel central
        centralBattlePanel.add(player1CampoBatalhaPanel, BorderLayout.WEST);
        centralBattlePanel.add(player2CampoBatalhaPanel, BorderLayout.EAST);
    
        // Posicionando os painéis de mão e campo de batalha
        panel1.add(player1MaoPanel, BorderLayout.WEST);
        panel1.add(player2MaoPanel, BorderLayout.EAST);
        panel1.add(centralBattlePanel, BorderLayout.CENTER);
    }
    

    //função que cria o panel de cartas para cada jogador
    private JPanel createMaoPanel(Jogador jogador, Jogador jogadorRival) {
        JPanel playerMaoPanel = new JPanel();
        playerMaoPanel.setLayout(new BoxLayout(playerMaoPanel, BoxLayout.Y_AXIS));
        playerMaoPanel.setBackground(Color.BLACK);

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
            playerMaoPanel.add(cardButton);
            playerMaoPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        }
        return playerMaoPanel;
    }

//obs: como campo de batalha sempre começa vazio, talves essa função de criar seja ate desnecessaria (analisar dps)

    //função pra verificar as cartas no campo de batalha e criar o GUI do panel
    private JPanel createCampoBatalhaPanel(Jogador jogador, Jogador jogadorRival){
        JPanel playerCampoBatalhaPanel = new JPanel(new GridLayout(1, 2));
        playerCampoBatalhaPanel.setLayout(new BoxLayout(playerCampoBatalhaPanel, BoxLayout.Y_AXIS));
        playerCampoBatalhaPanel.setBackground(Color.BLACK);

        for(Carta carta : jogador.getCampoBatalha().getCartasnoCampo()){
            JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
            cardButton.setPreferredSize(new Dimension(100, 60));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            cardButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    //usar carta nao é suficiente aqui, tenho que criar um analogo a jogarcarta
                    usarCartaNoCampoBatalha(jogador, carta, jogadorRival);
                }
            });

            playerCampoBatalhaPanel.add(cardButton);
            playerCampoBatalhaPanel.add(Box.createRigidArea(new Dimension(0, 30)));



        }

        return playerCampoBatalhaPanel;

    }

    //função para ser usada toda vez que uma carta for jogador (atualizar o gui)
    private void atualizarCampoBatalhaPanel(Jogador jogador, JPanel campoBatalhaPanel) {
        campoBatalhaPanel.removeAll();
    
        for (Carta carta : jogador.getCampoBatalha().getCartasnoCampo()) {
            if(carta.getResistencia() > 0){

                JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
                cardButton.setPreferredSize(new Dimension(100, 60));
                cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                cardButton.addActionListener(e -> usarCartaNoCampoBatalha(jogador, carta, jogador == jogador1 ? jogador2 : jogador1));
                campoBatalhaPanel.add(cardButton);
                campoBatalhaPanel.add(Box.createRigidArea(new Dimension(0, 30)));

            }
            
        }
    
        campoBatalhaPanel.revalidate();
        campoBatalhaPanel.repaint();
    }

    public void usarCartaNoCampoBatalha(Jogador jogador, Carta carta, Jogador jogadorRival) {
        //verificação de turno, mudança de turno e etc(falta)
        if(isTurnoJogador1 && jogador.equals(jogador1) ||(!isTurnoJogador1 && jogador.equals(jogador2)) ){
            //dano no jogador rival
            jogadorRival.alterarVida(carta);
            //dano nas cartas do campo de batalha do rival
            jogadorRival.getCampoBatalha().danoCampoBatalha(carta);

            // Atualiza o painel de campo de batalha
            JPanel campoBatalhaPanel = jogador.equals(jogador1) ? player1CampoBatalhaPanel : player2CampoBatalhaPanel;
            atualizarCampoBatalhaPanel(jogador, campoBatalhaPanel);
            atualizarPainelJogadores(); // Atualiza as informações dos jogadores
            passarTurno();
            
        }
        else{
            JOptionPane.showMessageDialog(frame, "Não é o seu turno!");
        }
        
        
        
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
                jogador.getCampoBatalha().adicionarCartaAoCampo(carta);
                jogador.getMao().removerCarta(carta); // remove carta da mao e adciona outra de deck no lugar

                //atualiza o campo do jogador que jogou
                JPanel campoBatalhaPanel = jogador.equals(jogador1) ? player1CampoBatalhaPanel : player2CampoBatalhaPanel;
                atualizarCampoBatalhaPanel(jogador, campoBatalhaPanel);
    
                
                // pega o painel do jogador q jogou
                JPanel playerPanel = jogador.equals(jogador1) ? player1MaoPanel : player2MaoPanel;
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
