package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestClient implements KeyListener
{
    private static final int HEIGHT = 19;
    private static final int WIDTH = 19;
    private static final int PREF_WIDTH = 600;
    private static final int PREF_HEIGHT = 600;

    private static void createAndShowGui() {

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

    public void player(){

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });


    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 37: // Left
                System.out.println("redrawing? Left");
                break;
            case 38: // Up
                System.out.println("redrawing? Up");
                break;
            case 39: // Right
                System.out.println("redrawing? Right");
                break;
            case 40: // Down
                System.out.println("redrawing? Down");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
