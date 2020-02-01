package client;

import client.activity.Activity;
import client.activity.GameActivity;
import client.activity.MainMenuActivity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BombermanPanel extends Container {

    // My ID for game
    private static final long serialVersionUID =  4161752677750100437L;

    // Default game font
    public static final Font DEFAULT_FONT = new Font("Calibry", 1, 25);
    // Define Activity
    private static final List<Activity> ACTIVITIES = new ArrayList<>();
    static {
        ACTIVITIES.add(new MainMenuActivity());
        ACTIVITIES.add(new GameActivity());
    }

    private Bomberman bomberman;
    private static Activity running, start = getActivity(MainMenuActivity.class);

    private double x = Math.PI, duration = 1D, time;
    private int size = 8, space = 8, amount = 14;

    // Constructor
    public BombermanPanel(Bomberman bomberman){
        this.bomberman = bomberman;
    }

    /**
     * Add class into Activity
     * @param clazz
     */
    public static void startActivity(Class<? extends Activity> clazz) {
        start = getActivity(clazz);
    }

    /**
     * Loop all activity and added then class
     * @param clazz
     * @return
     */
    public static Activity getActivity(Class<? extends Activity> clazz) {
        for (Activity activity : ACTIVITIES) {
            if (activity.getClass() == clazz)
                return activity;
        }
        return null;
    }

    /**
     * Create swing graphic
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Render for OS Toolikit into swing
        g2d.addRenderingHints((Map<?, ?>) Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints"));

        // Check if app is !running or loaded, then generate canvas
        if (running != null && running.isLoaded()) {
            running.update(getWidth(), getHeight());
            running.render(g2d);
        }

        // Condition for render game
        if ((running == null && start != null) || (start != null && start == running) || (running != null && running.isFinish())) {
            if(x < Math.PI || start.isLoaded())
                x += bomberman.getThread().getDeltaInS() * Math.PI / duration;

            int a = (int) ((Math.sin(x -  Math.PI / 2)  + 1) / 2 * 255);

            if(x >= Math.PI && !start.isLoaded()) {
                a =  255;
                x = Math.PI;
                running =start;
                start.load();
                bomberman.getMouse().load(start);
            }

            if (x >= Math.PI*2) {
                a = 0;
                x = 0;
                start = null;
            }

            g2d.setColor(new Color(0,0,0, a));
            g2d.fillRect(0, 0, getWidth(), getHeight());

            Color highColor = new Color(255, 255, 255, a), backColor = new Color(180,180, 180, a);
            time += bomberman.getThread().getDeltaInS();
            for(int i = 0; i < amount; i++){
                if (Math.floor(time * amount) % amount  == i) {
                    g2d.setColor(highColor);
                } else
                    g2d.setColor(backColor);
                g2d.fillRect((getWidth() - amount*size -  (amount-1)*space) / 2 + i*space + i*size, getHeight() - 120,  size, size);

            }


            g2d.setFont(DEFAULT_FONT);
            g2d.setColor(highColor);
            g2d.drawString("Loading new Game", getWidth() / 2 -g2d.getFontMetrics(DEFAULT_FONT).stringWidth("Loading new Game") / 2, getHeight() - 90 + DEFAULT_FONT.getSize());
        }
        bomberman.getThread().nowait();
    }
}
