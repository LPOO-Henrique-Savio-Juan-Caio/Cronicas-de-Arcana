package main;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //nesse caso precisei criar a janela aqui pra ter controle sobre a hora dela fechar e etc
        JFrame frame = new JFrame();

        Menu menu = new Menu(frame);
        menu.menuStart();


    }
}
