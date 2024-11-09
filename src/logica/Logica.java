package logica;

import entidades.Jogador;
import entidades.carta.Carta;
import java.awt.*;
import javax.swing.*;
import gui.zonas.CampoBatalhaGui;
import gui.PainelJogadoresGui;
import main.Game;
import main.Progressao;

//aqui vou colocar todas as funções que sao da logica do jogo
//obs: estou comentando algumas funções do GUI, como atualizar painel dos jogadores
//vamos colocar isturnoJogador como parte dessa classe

//problema: +4mana esta entrando de maneira errada


public class Logica {
    //vou ter q dar um jeito de instanciar Game aqui, para ter acesso a alguns metodos
    private Game game;

    private Jogador jogador1;
    private Jogador jogador2;
    private JFrame frame;
    private boolean isTurnoJogador1;
    Progressao progressao = Progressao.getInstancia();

    //por enquanto vou puxar alguns metodos GUI de la, depois vou mudar para as classes respectivas
    private CampoBatalhaGui campobatalhaGui;
    private PainelJogadoresGui paineljogadores;

    //nesse caso logica recebe como parametro a propria classe game
    public Logica(Game game, Jogador jogador1, Jogador jogador2, JFrame frame){
        this.game = game; // Armazenando a instância de Game
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.frame = frame;
        this.isTurnoJogador1 = true;
        campobatalhaGui = new CampoBatalhaGui(game, jogador1, jogador2, frame, this);
        paineljogadores = new PainelJogadoresGui(game, jogador1, jogador2, frame, this);
        

        

       
        
    }

    public void passarTurno() {
        isTurnoJogador1 = !isTurnoJogador1;
        Jogador jogadorAtual = isTurnoJogador1 ? jogador1 : jogador2;
        Jogador proximoJogador = isTurnoJogador1 ? jogador2 : jogador1;

        //mana regenerando todo round
        if(isTurnoJogador1){
            jogadorAtual.addMana(4);
            proximoJogador.addMana(4);
            paineljogadores.atualizarPainelJogadores();
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

    public boolean verificarMana(Jogador jogador) {
        for (Carta carta : jogador.getMao().getCartasMao()) {
            if (jogador.getMana() >= carta.getCustoMana()) {
                return false; // Mana suficiente para pelo menos uma carta
            }
        }
        return true; // Mana insuficiente para todas as cartas
    }

    public boolean CampoVazio(Jogador jogador) {
        return jogador.getCampoBatalha().getCartasnoCampo().isEmpty();
    }

    public boolean isTurnoJogador1() {
        return isTurnoJogador1;
    }

public void usarCartaNoCampoBatalha(Jogador jogador, Carta carta, Jogador jogadorRival) {

        //verificação de turno
        if(isTurnoJogador1() && jogador.equals(jogador1) ||(!isTurnoJogador1() && jogador.equals(jogador2)) ){
            //dano no jogador rival
            jogadorRival.alterarVida(carta);
            //dano nas cartas do campo de batalha do rival
            jogadorRival.getCampoBatalha().danoCampoBatalha(carta);

            //painel do jogador
            JPanel campoBatalhaPanel = jogador.equals(jogador1) ? game.getplayer1CampoBatalhaPanel() : game.getplayer2CampoBatalhaPanel();
            
            //painel do jogador rival
            JPanel campoBatalhaPanelRival = jogadorRival.equals(jogador1) ? game.getplayer1CampoBatalhaPanel() : game.getplayer2CampoBatalhaPanel();
           
            //atualiza painel do jogador que sofreu dano e do que atacou
            campobatalhaGui.atualizarCampoBatalhaPanel(jogadorRival, campoBatalhaPanelRival, jogador);
            campobatalhaGui.atualizarCampoBatalhaPanel(jogador, campoBatalhaPanel, jogadorRival);

            //verificação do funcionamento enquanto n temos gui para vida das cartas
            System.out.println(jogador.getCampoBatalha().toString());
            System.out.println(jogadorRival.getCampoBatalha().toString());

            paineljogadores.atualizarPainelJogadores(); 
            passarTurno();
            
        }
        else{
            JOptionPane.showMessageDialog(frame, "Não é o seu turno!");
        }
        
        
        
    }

    public void jogarCarta(Jogador jogador, Carta carta, Jogador jogadorRival) {
        if ((isTurnoJogador1() && jogador.equals(jogador1)) || (!isTurnoJogador1() && jogador.equals(jogador2))) {
            if (jogador.getMana() >= carta.getCustoMana()) {
                
                //usa carta, adciona ao campo de batalha e remove da mao
                usarCarta(jogador, carta, jogadorRival);
                jogador.getCampoBatalha().adicionarCartaAoCampo(carta);
                jogador.getMao().removerCarta(carta); 

                //painel de ambos os jogadores
                JPanel campoBatalhaPanel = jogador.equals(jogador1) ? game.getplayer1CampoBatalhaPanel() : game.getplayer2CampoBatalhaPanel();
                
                
                JPanel campoBatalhaPanelRival = jogadorRival.equals(jogador1) ? game.getplayer1CampoBatalhaPanel() : game.getplayer2CampoBatalhaPanel();
                //atualiza painel do jogador que sofreu dano
                campobatalhaGui.atualizarCampoBatalhaPanel(jogadorRival, campoBatalhaPanelRival, jogador);
                //atualiza painel do proprio jogador
                campobatalhaGui.atualizarCampoBatalhaPanel(jogador, campoBatalhaPanel, jogadorRival);
                
                //verificar funcionamento
                // System.out.println(jogadorRival.getCampoBatalha().toString());
                // System.out.println(jogador.getCampoBatalha().toString());
                

                //obs:podemos adcionar o trecho abaixo em outra função como fiz para campo de batalha (organizar)

                // pega o painel do jogador q jogou
                JPanel playerPanel = jogador.equals(jogador1) ? game.getplayer1MaoPanel() : game.getplayer2MaoPanel();
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
                paineljogadores.atualizarPainelJogadores();
                passarTurno();
            } else {
                JOptionPane.showMessageDialog(frame, "Mana insuficiente!");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Não é o seu turno!");
        }
    }


    public void usarCarta(Jogador jogador, Carta carta, Jogador jogadorRival){
        jogador.alterarMana(carta);
        jogadorRival.alterarVida(carta);

    }


    
}
