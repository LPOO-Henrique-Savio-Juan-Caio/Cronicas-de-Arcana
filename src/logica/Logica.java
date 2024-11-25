package logica;

import Enum.Efeito;
import entidades.Jogador;
import entidades.carta.*;
import gui.PainelJogadoresGui;
import gui.menu.TelaInicial;
import gui.zonas.*;
import java.util.ArrayList;
import javax.swing.*;
import main.Game;
import soundTrack.SoundManager;
import static soundTrack.SoundManager.playSoundEffect;

public class Logica {
    private Game game;
    private Jogador jogador1;
    private Jogador jogador2;
    private JFrame frame;
    private boolean isTurnoJogador1;
    private MaoGui maogui;
    Progressao progressao = Progressao.getInstancia();
    private CampoBatalhaGui campobatalhaGui;
    private PainelJogadoresGui paineljogadores;
    private CemiterioGui cemiteriogui;
    private TelaInicial telaInicial;
    private ArrayList<Encantamento> encantamentoAtivosJ1;
    private ArrayList<Encantamento> encantamentoAtivosJ2;

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
        cemiteriogui = new CemiterioGui(game, jogador1, jogador2, frame, this);
        telaInicial = new TelaInicial(this.frame);

        //inicializando array de encantamentosAtivos:
        encantamentoAtivosJ1 = new ArrayList<>();
        encantamentoAtivosJ2 = new ArrayList<>();
    }

    public void passarTurno() {
        isTurnoJogador1 = !isTurnoJogador1;
        Jogador jogadorAtual = isTurnoJogador1 ? jogador1 : jogador2;
        Jogador proximoJogador = isTurnoJogador1 ? jogador2 : jogador1;

        //aviso de turno primeiro
        JOptionPane.showMessageDialog(frame, "Turno de " + jogadorAtual.getNome());

        //mana regenerando todos os rounds
        if(isTurnoJogador1){
            jogadorAtual.addMana(2);
            proximoJogador.addMana(2);
            paineljogadores.atualizarPainelJogadores();
            JOptionPane.showMessageDialog(frame, "+2 de mana para ambos os jogadores");

            //logica para encantamentos ativos
            if (!encantamentoAtivosJ1.isEmpty()) {
                for (Encantamento encantamento : encantamentoAtivosJ1) {

                    //ativa cada encantamento do jogador1
                    if (encantamento.getDuracao() != 0) {
                        jogarEncantamento(jogador1, jogador2, encantamento, encantamento);
                        encantamento.decrescerDuracao();
                        JOptionPane.showMessageDialog(frame, "Encantamento " + encantamento.toString() + ":" + encantamento.getDuracao() + " restantes");

                    } else {
                        encantamentoAtivosJ1.remove(encantamento);
                    }
                }
            }
        } else if(!isTurnoJogador1){
            if (!encantamentoAtivosJ2.isEmpty()) {
                for (Encantamento encantamento : encantamentoAtivosJ2) {
                    if (encantamento.getDuracao() != 0) {
                        jogarEncantamento(jogador2, jogador1, encantamento, encantamento);
                        encantamento.decrescerDuracao();
                        JOptionPane.showMessageDialog(frame, "Encantamento " + encantamento.toString() + ":" + encantamento.getDuracao() + " restantes");
                    } else {
                        encantamentoAtivosJ2.remove(encantamento);
                    }
                }
            }
        }

        // Condições de vitória
        if (jogador1.getVida() <= 0) {
            JOptionPane.showMessageDialog(frame, "Vitória de " + jogador2.getNome());
            progressao.addVitoria(jogador1.getNome());

            //vai pra tela inicial
            telaInicial.menuStart();
            return;

        } else if (jogador2.getVida() <= 0) {
            JOptionPane.showMessageDialog(frame, "Vitória de " + jogador1.getNome());
            progressao.addVitoria(jogador2.getNome());

            //vai pra tela inicial
            telaInicial.menuStart();
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
        }
    }

    //função criada para verificar se ja tem 5 cartas no campo
    public boolean verificarCampoBatalha(Jogador jogador){
        //caso tenha menos de 5 cartas no campo
        if(jogador.getCampoBatalha().getCartasNoCampo().size() < 5){
            return true;
        }

        //caso tenha 5 ou mais
        else{
            return false;
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
        return jogador.getCampoBatalha().getCartasNoCampo().isEmpty();
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

                //verificação de numero maximo de cartas no campo (para criaturas apenas)
                if (verificarCampoBatalha(jogador) || !(carta instanceof Criatura criatura) ) {

                    //som de carta
                    new Thread(() -> playSoundEffect("arquivos/soundtracks/cardButton.wav")).start();


                    //Criatura: vai pro campo de batalha, é removida da mao e gasta mana
                    if (carta instanceof Criatura criatura) {
                        jogador.getCampoBatalha().adicionarCarta(carta);
                        jogador.getMao().removerCarta(carta);
                        jogador.alterarMana(carta);

                    } //feitiço:
                    else if (carta instanceof Feitico feitico) {
                        jogarFeitico(jogador, jogadorRival, feitico, carta);
                    } //encantamento: efeito em determinado numero de rounds
                    else if (carta instanceof Encantamento encantamento) {
                        System.out.println("encantamento lançado");

                        //colocamos o encantamento na lista de encantamentos do jogador respectivo
                        if (jogador.equals(jogador1)) {

                            //aviso de lançamento do encantamento
                            JOptionPane.showMessageDialog(frame, "Encantamento " + encantamento.toString() + " lançado pelo " + jogador.getNome());

                            //joga o encantamento e coloca -1 na duração
                            jogarEncantamento(jogador1, jogador2, encantamento, carta);

                            //gasta mana
                            jogador.alterarMana(carta);
                            encantamento.decrescerDuracao();

                            //adiciona a lista que vai ter seu efeito todos os round
                            encantamentoAtivosJ1.add(encantamento);

                        } else if (jogador.equals(jogador2)) {

                            //aviso de lançamento do encantamento
                            JOptionPane.showMessageDialog(frame, "Encantamento " + encantamento.toString() + " lançado pelo " + jogador.getNome());

                            //joga o encantamento e coloca -1 na duração
                            jogarEncantamento(jogador2, jogador1, encantamento, carta);
                            encantamento.decrescerDuracao();

                            //adiciona a lista que vai ter seu efeito todos os round
                            encantamentoAtivosJ2.add(encantamento);
                        }
                    }

                    // Painéis dos campos de batalha dos jogadores
                    JPanel campoBatalhaPanel = jogador.equals(jogador1) ? game.getplayer1CampoBatalhaPanel() : game.getplayer2CampoBatalhaPanel();
                    JPanel campoBatalhaPanelRival = jogadorRival.equals(jogador1) ? game.getplayer1CampoBatalhaPanel() : game.getplayer2CampoBatalhaPanel();

                    // Atualiza os painéis do campo de batalha
                    campobatalhaGui.atualizarCampoBatalhaPanel(jogadorRival, campoBatalhaPanelRival, jogador);
                    campobatalhaGui.atualizarCampoBatalhaPanel(jogador, campoBatalhaPanel, jogadorRival);
                    System.out.println(jogador.getCampoBatalha().toString());

                    // Atualiza a mão do jogador
                    maogui.atualizarPanelMao(jogador);

                    // Atualiza o painel de jogadores e passa o turno
                    paineljogadores.atualizarPainelJogadores();
                    passarTurno();
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Numero Maximo de cartas no Campo de Batalha");
                }

            } else {
                JOptionPane.showMessageDialog(frame, "Mana insuficiente!");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Não é o seu turno!");
        }
    }

    public void jogarFeitico(Jogador jogador, Jogador jogadorRival, Feitico feitico, Carta carta){
        System.out.println("feitiço lançado");
        String tipoEfeito = feitico.getEfeito();
        Efeito efeito = Efeito.valueOf(tipoEfeito.toUpperCase());
        double valorEfeito = efeito.getEfeito();
        if(valorEfeito > 0){
            if(tipoEfeito.equals("dano") ||tipoEfeito.equals("muito_dano") ){

                //tirar vida do jogadorRival
                jogadorRival.alterarVidaDouble(-efeito.getEfeito());

                //tira vida das cartas do jogadorRival
                jogadorRival.getCampoBatalha().danoCampoBatalha(carta);
                JOptionPane.showMessageDialog(frame, "Feitiço de Dano lançado! Causou " + efeito.getEfeito() + " de dano no oponente.");
            }
            else if(tipoEfeito.equals("mana") ||tipoEfeito.equals("muita_mana")){

                //dar mana
                jogador.alterarManaDouble(efeito.getEfeito());
                JOptionPane.showMessageDialog(frame, "Feitiço de Mana lançado! Ganhou " + efeito.getEfeito() + " de mana.");
            }
        }
        else if(valorEfeito < 0){

            //dar vida(resistencia) ao jogador
            jogador.alterarVidaDouble(-efeito.getEfeito());
            JOptionPane.showMessageDialog(frame, "Feitiço de Vida lançado! Recuperou " + -efeito.getEfeito() + " de vida.");
        }
        else{
            JOptionPane.showMessageDialog(frame, "O feitiço Necromancia foi escolhido, escolha uma carta para reviver");
            Carta cartaEscolhida = cemiteriogui.selecionarCartaCemiterio(jogador);
            jogador.getCemiterio().getCartasCemiterio().remove(cartaEscolhida);
            jogador.getCampoBatalha().adicionarCarta(cartaEscolhida);
            JOptionPane.showMessageDialog(frame, "Carta: " + cartaEscolhida.getNome() + " revivida direto para o Campo de Batalha");

            //enchendo a vida da carta:
            cartaEscolhida.setResistencia(cartaEscolhida.getResistenciaTotal());
            System.out.println(jogador.getCampoBatalha().toString());
        }

        // Remove o feitiço da mão e gasta mana
        jogador.getMao().removerCarta(carta);
        jogador.alterarMana(carta);
    }

    public void jogarEncantamento(Jogador jogador, Jogador jogadorRival, Encantamento encantamento, Carta carta){
        System.out.println("encantamento lançado");
        String tipoEfeito = encantamento.getEfeito();
        Efeito efeito = Efeito.valueOf(tipoEfeito.toUpperCase());
        double valorEfeito = efeito.getEfeito();
        if(valorEfeito > 0){
            if(tipoEfeito.equals("dano") ||tipoEfeito.equals("muito_dano") ){

                //tirar vida do jogadorRival
                //tira vida das cartas do jogadorRival
                jogadorRival.getCampoBatalha().danoCampoBatalha(carta);
                jogadorRival.alterarVidaDouble(-efeito.getEfeito());
                JOptionPane.showMessageDialog(frame, "Encantamento " + encantamento.toString() + " causou " +  efeito.getEfeito() + " de dado em " + jogadorRival.getNome());
            }
            else if(tipoEfeito.equals("mana") ||tipoEfeito.equals("muita_mana")){

                //dar mana
                jogador.alterarManaDouble(efeito.getEfeito());
                JOptionPane.showMessageDialog(frame, "Encantamento " + encantamento.toString() + " forneceu " +  -efeito.getEfeito() + " de mana para " + jogador.getNome());
            }
        }
        else if(valorEfeito < 0){

            //dar vida(resistencia) ao jogador
            jogador.alterarVidaDouble(-efeito.getEfeito());
            JOptionPane.showMessageDialog(frame, "Encantamento " + encantamento.toString() + " forneceu " +  -efeito.getEfeito() + " de vida para " + jogador.getNome());
        }

        // Remove o Encantamento da mão e gasta mana
        jogador.getMao().removerCarta(carta);
        paineljogadores.atualizarPainelJogadores();
    }
}