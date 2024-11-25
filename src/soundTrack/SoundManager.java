package soundTrack;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager {

    private static Clip backgroundClip;

    // Metodo para tocar música de fundo em loop
    public static void playBackgroundMusic(String filepath) {
        new Thread(() -> {
            try {
                File audioFile = new File(filepath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                backgroundClip = AudioSystem.getClip();
                backgroundClip.open(audioStream);
                backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); // Tocar em loop
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start();
    }

    //Metodo para tocar efeito sonoro
    public static void playSoundEffect(String filepath) {
        try {
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // Toca o som uma vez
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
