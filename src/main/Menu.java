package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel panel1;
    private JTextField nomeJogador1;
    private JTextField nomeJogador2;
    private JButton continuarButton;

    public Menu() {
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jogador1Nome = nomeJogador1.getText();
                String jogador2Nome = nomeJogador2.getText();

                //depois de receber os nomes no menu1, inicio o menu2 que vai receber os deck de cada jogador
                Menu2 menu2 = new Menu2(jogador1Nome, jogador2Nome);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
