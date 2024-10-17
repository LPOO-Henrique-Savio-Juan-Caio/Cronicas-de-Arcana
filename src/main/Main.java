package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Configura a janela principal

        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().getPanel1());
        frame.setMinimumSize(new Dimension(450,474));// Adiciona o painel da classe Menu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configura para fechar ao clicar no 'X
        frame.pack();  // Ajusta o tamanho da janela para caber nos componentes
        frame.setVisible(true);  // Torna a janela visível
    }
}
