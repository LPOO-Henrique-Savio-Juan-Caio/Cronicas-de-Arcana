package logica;

import Enum.Efeito;
import entidades.Jogador;
import entidades.carta.Carta;
import entidades.carta.Criatura;
import entidades.carta.Encantamento;
import entidades.carta.Feitico;
import gui.PainelJogadoresGui;
import gui.zonas.CampoBatalhaGui;
import gui.zonas.MaoGui;
import javax.swing.*;
import main.Game;
import main.Progressao;

//aqui vou colocar todas as funções que sao da logica do jogo
//obs: estou comentando algumas funções do GUI, como atualizar painel dos jogadores
//vamos colocar isturnoJogador como parte dessa classe

//problema: a logica de reviver cartas do cemiterio ainda esta paia, ver isso depois, fazer com que o jogador possa escolher
//problema2: os encantamento ainda n atacam as cartas que estao no campo
//na vdd toda a logica de encantamento e feitiço ta complicada


public class Logica {
    //vou ter q dar um jeito de instanciar Game aqui, para ter acesso a alguns metodos
    private Game game;

    private Jogador jogador1;
    private Jogador jogador2;
    private JFrame frame;
    private boolean isTurnoJogador1;
    private MaoGui maogui;
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
        maogui = new MaoGui(game, jogador1, jogador2, frame, this);
        

        

       
        
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
        // Verifica se é o turno do jogador correto
        if ((isTurnoJogador1() && jogador.equals(jogador1)) || (!isTurnoJogador1() && jogador.equals(jogador2))) {
            if (jogador.getMana() >= carta.getCustoMana()) {
                //aqui vou colocar uma estrutura condicional para cada "tipo" de carta:

                //Criatura: vai pro campo de batalha, é removida da mao e gasta mana
                if(carta instanceof Criatura criatura){
                    jogador.getCampoBatalha().adicionarCartaAoCampo(carta);
                    jogador.getMao().removerCarta(carta); 
                    jogador.alterarMana(carta);
                    //falta colocar pra gastar mana

                }
                //encantamento: apenas tem seu efeito no oponente
                else if(carta instanceof Feitico feitico){
                    System.out.println("feitiço lançado");
                    String tipoEfeito = feitico.getEfeito();
                    Efeito efeito = null;

                    switch (tipoEfeito.toUpperCase()) {
                        case "DANO":
                            efeito = Efeito.DANO;
                            jogadorRival.alterarVidaDouble(-efeito.getEfeito());
                            JOptionPane.showMessageDialog(frame, "Feitiço de Dano lançado! Causou " + efeito.getEfeito() + " de dano no oponente.");
                            break;
                        case "MUITO_DANO":
                            efeito = Efeito.MUITO_DANO;
                            jogadorRival.alterarVidaDouble(-efeito.getEfeito());
                            JOptionPane.showMessageDialog(frame, "Feitiço de Muito Dano lançado! Causou " + efeito.getEfeito() + " de dano no oponente.");
                            break;
                        case "VIDA":
                            efeito = Efeito.VIDA;
                            jogador.alterarVidaDouble(-efeito.getEfeito());
                            JOptionPane.showMessageDialog(frame, "Feitiço de Vida lançado! Recuperou " + -efeito.getEfeito() + " de vida.");
                            break;
                        case "MUITA_VIDA":
                            efeito = Efeito.MUITA_VIDA;
                            jogador.alterarVidaDouble(-efeito.getEfeito());
                            JOptionPane.showMessageDialog(frame, "Feitiço de Muita Vida lançado! Recuperou " + -efeito.getEfeito() + " de vida.");
                            break;
                        case "MANA":
                            efeito = Efeito.MANA;
                            jogador.alterarManaDouble(efeito.getEfeito());
                            JOptionPane.showMessageDialog(frame, "Feitiço de Mana lançado! Ganhou " + efeito.getEfeito() + " de mana.");
                            break;
                        case "MUITA_MANA":
                            efeito = Efeito.MUITA_MANA;
                            jogador.alterarManaDouble(efeito.getEfeito());
                            JOptionPane.showMessageDialog(frame, "Feitiço de Muita Mana lançado! Ganhou " + efeito.getEfeito() + " de mana.");
                            break;
                        case "REVIVER":
                            efeito = Efeito.REVIVER;
                            if (!jogador.getCemiterio().getCartasCemiterio().isEmpty()) {
                                // Revive uma criatura aleatória do cemitério
                                //por enquanto esta essa doidera, depois vamos fazer com que o jogador possa escolher
                                Carta cartaReviver = jogador.getCemiterio().getCartasCemiterio().get(0); // Pega a primeira carta
                                jogador.getCemiterio().getCartasCemiterio().remove(cartaReviver);
                                jogador.getCampoBatalha().adicionarCartaAoCampo(cartaReviver);
                                JOptionPane.showMessageDialog(frame, "Feitiço de Reviver lançado! Criatura " + cartaReviver.getNome() + " revivida.");
                            } else {
                                JOptionPane.showMessageDialog(frame, "Não há criaturas para reviver.");
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(frame, "Tipo de feitiço desconhecido.");
                            break;
                    }
                
                    // Remove o feitiço da mão e gasta mana
                    jogador.getMao().removerCarta(carta);
                    jogador.alterarMana(carta);
                }

                //tem seu efeito em um determinado numero de round
                else if (carta instanceof Encantamento encantamento) {
                    System.out.println("encantamento lançado");
                    
                }
                
    
                // Painéis dos campos de batalha dos jogadores
                JPanel campoBatalhaPanel = jogador.equals(jogador1) ? game.getplayer1CampoBatalhaPanel() : game.getplayer2CampoBatalhaPanel();
                JPanel campoBatalhaPanelRival = jogadorRival.equals(jogador1) ? game.getplayer1CampoBatalhaPanel() : game.getplayer2CampoBatalhaPanel();
    
                // Atualiza os painéis do campo de batalha
                campobatalhaGui.atualizarCampoBatalhaPanel(jogadorRival, campoBatalhaPanelRival, jogador);
                campobatalhaGui.atualizarCampoBatalhaPanel(jogador, campoBatalhaPanel, jogadorRival);
                
                // Atualiza a mão do jogador
                maogui.atualizarPanelMao(jogador);
    
                // Atualiza o painel de jogadores e passa o turno
                paineljogadores.atualizarPainelJogadores();
                passarTurno();
            } else {
                JOptionPane.showMessageDialog(frame, "Mana insuficiente!");
            }
        } 
        else{
            JOptionPane.showMessageDialog(frame, "Não é o seu turno!");
        }
     }
    

    public void usarCarta(Jogador jogador, Carta carta, Jogador jogadorRival){
        jogador.alterarMana(carta);
        jogadorRival.alterarVida(carta);

    }


    
}
