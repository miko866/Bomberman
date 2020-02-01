package client.activity;

import client.BombermanPanel;
import client.gui.GUIButton;
import client.gui.GUIComponent;

import javax.swing.*;
import java.awt.*;

public class GameActivity extends Activity {

    private GUIComponent toolbar;
    private GUIButton back;
    private GUIScore scoreRed, scoreOrange, scoreGreen, scoreBlue;
    private GUIGameCanvas canvas;
    private static final int HEIGHT = 19;
    private static final int WIDTH = 19;
    private static final int PREF_WIDTH = 600;
    private static final int PREF_HEIGHT = 600;


    public GameActivity() {
        toolbar = new GUIComponent(0, 50) {
            @Override
            public void revalidate(int screenWidth, int screenHeight) {
                this.setWidth(screenWidth);
                super.revalidate(screenWidth, screenHeight);
            }
        };
        toolbar.setBackground(Color.WHITE);

        back = new GUIButton(5, 5, 40, 40);
        back.setBackground(Color.BLACK);
        back.setOnClickListener(() -> {
            finish();
            BombermanPanel.startActivity(MainMenuActivity.class);
        });

        scoreRed = new GUIScore(320, null);
        scoreOrange = new GUIScore(215, null);
        scoreGreen = new GUIScore(110, null);
        scoreBlue = new GUIScore(5, null);

        canvas = new GUIGameCanvas(this, 0, 0) {
            @Override
            public void revalidate(int screenWidth, int screenHeight) {
                double aspect = 1920d / 1080d, aspect2= screenWidth /(double) screenHeight;

                if(aspect > aspect2) {
                    setWidth((int) (aspect * screenHeight));
                    setHeight((int) (1080d / 1920d * getWidth()));
                    setY((screenHeight - getHeight()) / 2);
                } else {
                    setHeight((int)(1080d /1920d *  screenWidth));
                    setWidth((int) (1920d / 1080d * getHeight()));
                    setY(-(screenHeight - getHeight()) / 2);
                }

                screenHeight += 50;
                super.revalidate(screenWidth,screenHeight);
            }

        };

        components.add(toolbar);
        components.add(back);
        components.add(scoreRed);
        components.add(scoreOrange);
        components.add(scoreGreen);
        components.add(scoreBlue);

        JPanel mainPanel = new JPanel(new GridLayout(HEIGHT, WIDTH));
        mainPanel.setPreferredSize(new Dimension(PREF_WIDTH, PREF_HEIGHT));

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == 0 || i == HEIGHT - 1 || j == 0 || j == HEIGHT - 1 || (i % 2) == 0 && (j % 2) == 0) {
                    String text = String.format("");
                    JLabel label = new JLabel(text, SwingConstants.CENTER);
                    label.setBackground(Color.gray);
                    label.setOpaque(true);
                    mainPanel.add(label);
                } else {
                    String text = String.format("");
                    JLabel label = new JLabel(text, SwingConstants.CENTER);
                    label.setBackground(Color.green);
                    label.setOpaque(true);
                    mainPanel.add(label);
                }
            }
        }
        JOptionPane.showMessageDialog(null, mainPanel, "Bomberman", JOptionPane.PLAIN_MESSAGE);

    }

    private void finish() {
    }

}
