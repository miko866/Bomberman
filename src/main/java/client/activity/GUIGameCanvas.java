package client.activity;

import client.gui.GUIComponent;

public class GUIGameCanvas extends GUIComponent {

    /**
     *
     * @param gameActivity
     * @param width
     * @param height
     */
    public GUIGameCanvas(GameActivity gameActivity, int width, int height) {
        super(0, 0, width, height);
        setHorizontalAlign(CENTER);
        setVerticalAlign(BOTTOM);
    }
}
