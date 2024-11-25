package main;

import javax.swing.*;
import gui.menu.TelaInicial;
import soundTrack.SoundManager;

public class Main {

    private static SoundManager soundManager = new SoundManager();

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        soundManager.playBackgroundMusic("arquivos/soundtracks/musica_de_fundo_[cut_158sec].wav");
        TelaInicial menu = new TelaInicial(frame);
        menu.menuStart();
    }
}