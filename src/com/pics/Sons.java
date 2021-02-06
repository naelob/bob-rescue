package com.pics;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Sons {
    private static Clip musiquePrincipale, musiqueSucces;

    public static void joueMusique() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (musiquePrincipale == null) {
            File f = new File("src/com/sons/bob.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            musiquePrincipale = AudioSystem.getClip();
            musiquePrincipale.open(audioIn);
        }
        musiquePrincipale.loop(100);
    }

    public static void stopMusique() {
        if (musiquePrincipale != null) musiquePrincipale.stop();
    }

    public static void joueMusiqueSuccess() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (musiqueSucces == null) {
            File f = new File("src/com/sons/success.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            musiqueSucces = AudioSystem.getClip();
            musiqueSucces.open(audioIn);
        }
        musiqueSucces.stop();
        musiqueSucces.setMicrosecondPosition(0);
        musiqueSucces.start();
    }
}
