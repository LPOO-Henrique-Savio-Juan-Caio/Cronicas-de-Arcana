
package main;

import entidades.*;
import entidades.carta.Carta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


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

//estamos aqui: 

//5 - funcionamento de encantamento(continua com efeito em X rounds) e feitiço(de boinha) - ambos nao vao para o campo de batalha
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
    private JPanel player1Cemiterio, player2Cemiterio;

    //instanciando progressao sem reiniciar os dados
    Progressao progressao = Progressao.getInstancia();

    public Game(String nome1, String nome2, ArrayList<String> deckJogador1, ArrayList<String> deckJogador2, JFrame frame) {
        this.frame = frame;

        jogador1 = new Jogador(nome1, new CartasJogo().getArrayCartas(), deckJogador1);
        jogador2 = new Jogador(nome2, new CartasJogo().getArrayCartas(), deckJogador2);


        
        //add jogador a lista (caso ja n esteja)
        progressao.addJogador(nome1);
        progressao.addJogador(nome2);

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

        //gui cemiterio
        player1Cemiterio = createCemiterioPanel(jogador1);
        player2Cemiterio = createCemiterioPanel(jogador2);

        // Painel vertical para o Jogador 1 (contém mão e cemitério)
        JPanel player1SidePanel = new JPanel();
        player1SidePanel.setLayout(new BoxLayout(player1SidePanel, BoxLayout.Y_AXIS));
        player1SidePanel.setBackground(Color.BLACK);
        player1SidePanel.add(player1MaoPanel);
        player1SidePanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espaço entre mão e cemitério
        player1SidePanel.add(player1Cemiterio);
        player1SidePanel.setPreferredSize(new Dimension(200, 300));

        // Painel vertical para o Jogador 2 (contém mão e cemitério)
        JPanel player2SidePanel = new JPanel();
        player2SidePanel.setLayout(new BoxLayout(player2SidePanel, BoxLayout.Y_AXIS));
        player2SidePanel.setBackground(Color.BLACK);
        player2SidePanel.add(player2MaoPanel);
        player2SidePanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espaço entre mão e cemitério
        player2SidePanel.add(player2Cemiterio);
        player2SidePanel.setPreferredSize(new Dimension(200, 400));
    
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
        panel1.add(player1SidePanel, BorderLayout.WEST);
        panel1.add(player2SidePanel, BorderLayout.EAST);
        panel1.add(centralBattlePanel, BorderLayout.CENTER);
    }

    //função gui do cemiterio: a priore um botao que abre uma pagina com todas as cartas
    private JPanel createCemiterioPanel(Jogador jogador){

        JPanel playerCemiterioPanel = new JPanel();
        playerCemiterioPanel.setLayout(new BoxLayout(playerCemiterioPanel, BoxLayout.Y_AXIS));
        playerCemiterioPanel.setBackground(Color.BLACK);

        //botao que "abre" uma page com o cemiterio de cada jogador
        JButton cardButton = new JButton( "Cemiterio " + jogador.getNome());
            cardButton.setPreferredSize(new Dimension(100, 60));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            cardButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
            cardButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {

                    // jdialog para exibir as cartas
                    JDialog cemiterioDialog = new JDialog();
                    cemiterioDialog.setTitle("Cemitério de " + jogador.getNome());
                    cemiterioDialog.setSize(300, 400); // Ajuste o tamanho conforme necessário
                    cemiterioDialog.setLocationRelativeTo(null); // Centraliza na tela
                    
                    
                    JPanel cemiterioPanel = new JPanel();
                    cemiterioPanel.setLayout(new BoxLayout(cemiterioPanel, BoxLayout.Y_AXIS));
                    cemiterioPanel.setBackground(Color.DARK_GRAY);
                    //for que itera sobre as cartas
                    for (Carta carta : jogador.getCemiterio().getCartasCemiterio()){

                        JButton cartaButton = new JButton(carta.getNome());
                        cartaButton.setPreferredSize(new Dimension(150, 40));
                        cartaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                        cartaButton.addActionListener(ev -> {
                            // informações da carta
                            JOptionPane.showMessageDialog(cemiterioDialog, 
                                "Detalhes da Carta: \n" + carta.toString(), 
                                "Detalhes da Carta", 
                                JOptionPane.INFORMATION_MESSAGE);
                        });
                        cemiterioPanel.add(cartaButton);
                        cemiterioPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espaço entre cartas

                    }

                    // adciona o dialog ao panel do cemiterio
                    cemiterioDialog.add(new JScrollPane(cemiterioPanel));
                    cemiterioDialog.setVisible(true);
                    
                }
            });
            playerCemiterioPanel.add(cardButton);
            return playerCemiterioPanel;

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
                    //função usada para dar dano tanto no jogador como nas cartas que estao no campo
                    usarCartaNoCampoBatalha(jogador, carta, jogadorRival);
                }
            });

            

            playerCampoBatalhaPanel.add(cardButton);
            playerCampoBatalhaPanel.add(Box.createRigidArea(new Dimension(0, 30)));



        }

        return playerCampoBatalhaPanel;

    }

    private void atualizarCampoBatalhaPanel(Jogador jogador, JPanel campoBatalhaPanel, Jogador jogadorRival) {
        
        //remove as cartas do panel
        campoBatalhaPanel.removeAll();
    
        //lista para armazenar cartas com vida <= 0
        List<Carta> cartasParaRemover = new ArrayList<>();


        //itera sobre as cartas no campo de batalha
        for (Carta carta : jogador.getCampoBatalha().getCartasnoCampo()) {
            //verifica se as cartas estao vivas
            if (carta.getResistencia() > 0) {
                //cria gui da carta
                JPanel cartaPanel = new JPanel();
                cartaPanel.setLayout(new BoxLayout(cartaPanel, BoxLayout.Y_AXIS));
                cartaPanel.setBackground(Color.DARK_GRAY);

                JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
                cardButton.setPreferredSize(new Dimension(100, 60));
                cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                cardButton.addActionListener(e -> usarCartaNoCampoBatalha(jogador, carta, jogadorRival));
                
                //barra de progresso da vida (em desenvolvimento)
                // JProgressBar barraVida = new JProgressBar(0, (int) carta.getResistencia()); // vida máxima da carta
                // barraVida.setValue((int) carta.getResistencia()); // vida atual da carta
                // barraVida.setPreferredSize(new Dimension(100, 2));
                // barraVida.setForeground(Color.RED);//estipular uma condicional aqui
                // barraVida.setAlignmentX(Component.CENTER_ALIGNMENT);
    
                // cartaPanel.add(cardButton);
                // cartaPanel.add(barraVida);
                
    
                
                campoBatalhaPanel.add(cardButton);
                campoBatalhaPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    
            } else {//caso n esteja viva
                
                //adciona ao cemiterio e coloca na lista pra remover
                jogador.getCemiterio().adicionarCarta(carta);
                cartasParaRemover.add(carta); // Marca para remoção depois
            }
        }
    
        //remove cartas da lista
        for (Carta carta : cartasParaRemover) {
            jogador.getCampoBatalha().removerCarta(carta);
        }
    
        
        campoBatalhaPanel.revalidate();
        campoBatalhaPanel.repaint();
    }
    

    //função de ação das cartas do campo de batalha
    public void usarCartaNoCampoBatalha(Jogador jogador, Carta carta, Jogador jogadorRival) {

        //verificação de turno
        if(isTurnoJogador1 && jogador.equals(jogador1) ||(!isTurnoJogador1 && jogador.equals(jogador2)) ){
            //dano no jogador rival
            jogadorRival.alterarVida(carta);
            //dano nas cartas do campo de batalha do rival
            jogadorRival.getCampoBatalha().danoCampoBatalha(carta);

            //painel do jogador
            JPanel campoBatalhaPanel = jogador.equals(jogador1) ? player1CampoBatalhaPanel : player2CampoBatalhaPanel;
            
            //painel do jogador rival
            JPanel campoBatalhaPanelRival = jogadorRival.equals(jogador1) ? player1CampoBatalhaPanel : player2CampoBatalhaPanel;
           
            //atualiza painel do jogador que sofreu dano e do que atacou
            atualizarCampoBatalhaPanel(jogadorRival, campoBatalhaPanelRival, jogador);
            atualizarCampoBatalhaPanel(jogador, campoBatalhaPanel, jogadorRival);

            //verificação do funcionamento enquanto n temos gui para vida das cartas
            System.out.println(jogador.getCampoBatalha().toString());
            System.out.println(jogadorRival.getCampoBatalha().toString());

            atualizarPainelJogadores(); 
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

    //ação das cartas que estao na mao
    private void jogarCarta(Jogador jogador, Carta carta, Jogador jogadorRival) {
        if ((isTurnoJogador1 && jogador.equals(jogador1)) || (!isTurnoJogador1 && jogador.equals(jogador2))) {
            if (jogador.getMana() >= carta.getCustoMana()) {
                
                //usa carta, adciona ao campo de batalha e remove da mao
                usarCarta(jogador, carta, jogadorRival);
                jogador.getCampoBatalha().adicionarCartaAoCampo(carta);
                jogador.getMao().removerCarta(carta); 

                //painel de ambos os jogadores
                JPanel campoBatalhaPanel = jogador.equals(jogador1) ? player1CampoBatalhaPanel : player2CampoBatalhaPanel;
                
                
                JPanel campoBatalhaPanelRival = jogadorRival.equals(jogador1) ? player1CampoBatalhaPanel : player2CampoBatalhaPanel;
                //atualiza painel do jogador que sofreu dano
                atualizarCampoBatalhaPanel(jogadorRival, campoBatalhaPanelRival, jogador);
                //atualiza painel do proprio jogador
                atualizarCampoBatalhaPanel(jogador, campoBatalhaPanel, jogadorRival);
                
                //verificar funcionamento
                // System.out.println(jogadorRival.getCampoBatalha().toString());
                // System.out.println(jogador.getCampoBatalha().toString());
                

                //obs:podemos adcionar o trecho abaixo em outra função como fiz para campo de batalha (organizar)

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
    
                //atualiza o gui e passa o turno
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
        Jogador jogadorAtual = isTurnoJogador1 ? jogador1 : jogador2;
        Jogador proximoJogador = isTurnoJogador1 ? jogador2 : jogador1;

        //mana regenerando todo round
        if(isTurnoJogador1){
            jogadorAtual.addMana(4);
            proximoJogador.addMana(4);
            atualizarPainelJogadores();
            JOptionPane.showMessageDialog(frame, "+4 de mana para ambos os jogadores");
            

        }
    
        // Condições de vitória
        if (jogador1.getVida() <= 0) {
            JOptionPane.showMessageDialog(frame, "Vitória de " + jogador2.getNome());
            progressao.addVitoria(jogador1.getNome());
            frame.dispose();
            return;
        } else if (jogador2.getVida() <= 0) {
            JOptionPane.showMessageDialog(frame, "Vitória de " + jogador1.getNome());
            progressao.addVitoria(jogador2.getNome());
            frame.dispose();
            return;
        }
    
        // verificação de mana suficiente (falta verificar se ainda existem cartas no campo de batalha)
        if ((verificarMana(jogadorAtual) && verificarMana(proximoJogador)) && 
        (CampoVazio(jogadorAtual) && CampoVazio(proximoJogador))) {
            JOptionPane.showMessageDialog(frame, "Mana insuficiente para ambos. EMPATE!");
            frame.dispose();
            return;
        }
    
        if (verificarMana(jogadorAtual) && 
        CampoVazio(jogadorAtual)) {
            JOptionPane.showMessageDialog(frame, "Mana insuficiente para " + jogadorAtual.getNome() + ". Pulando turno...");
            passarTurno(); //recursao
        } else {
            JOptionPane.showMessageDialog(frame, "Turno de " + jogadorAtual.getNome());
        }
    }

    //verifica se o campo esta vazio (poderia fazer direto em passar turno mas vou evitar)
    public boolean CampoVazio(Jogador jogador) {
        return jogador.getCampoBatalha().getCartasnoCampo().isEmpty();
    }

    //Por enquanto como ainda temos apenas criaturas, a carta tira vida e gasta mana
    public void usarCarta(Jogador jogador, Carta carta, Jogador jogadorRival){
        jogador.alterarMana(carta);
        jogadorRival.alterarVida(carta);

    }





    private boolean verificarMana(Jogador jogador) {
        for (Carta carta : jogador.getMao().getCartasMao()) {
            if (jogador.getMana() >= carta.getCustoMana()) {
                return false; // Mana suficiente para pelo menos uma carta
            }
        }
        return true; // Mana insuficiente para todas as cartas
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
