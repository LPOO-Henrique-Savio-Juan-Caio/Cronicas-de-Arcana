package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel panel1;
    private JTextField nomeJogador1;
    private JTextField nomeJogador2;
    private JButton continuarButton;
    private JFrame frame;

    public Menu(JFrame frame) {

        //precisei fzr isso pra ter controle a janela dps de aberta
        this.frame = frame;

        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //armazena o nome dos jogadores no campo de texto
                String jogador1Nome = nomeJogador1.getText();
                String jogador2Nome = nomeJogador2.getText();

                //inicia o menu2 ja com o nome dos jogadores setados
                Menu2 menu2 = new Menu2(jogador1Nome, jogador2Nome, frame);
                menu2.menu2Start();
                frame.dispose();

            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    //função que inicia o menu, e controla a pagina
    public void menuStart(){
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu(frame).getPanel1());
        frame.setMinimumSize(new Dimension(450,474));// Adiciona o painel da classe Menu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configura para fechar ao clicar no 'X
        frame.pack();  // Ajusta o tamanho da janela para caber nos componentes
        frame.setVisible(true);  // Torna a janela visível
    }
}