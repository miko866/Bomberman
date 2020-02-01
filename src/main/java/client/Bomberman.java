package client;

import client.interact.Mouse;

import javax.swing.*;

public class Bomberman {

    private static final int WIDTH = 1000, HEIGHT = 650;

    private JFrame frame;
    private BombermanPanel panel;
    private BombermanThread thread;
    private Mouse mouse;

    public static void main(String[] args) {
        new Bomberman();
    }

    public Bomberman() {
        frame = new JFrame("Bomberman");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new BombermanPanel(this);
        mouse = new Mouse(this);
        frame.addMouseListener(mouse);
        frame.addMouseMotionListener(mouse);
        frame.setContentPane(panel);

        thread = new BombermanThread(panel);
        thread.start();

        frame.setVisible(true);


    }

    public JFrame getFrame() {
        return frame;
    }

    public BombermanThread getThread() {
        return thread;
    }

    public Mouse getMouse() {
        return mouse;
    }
}
