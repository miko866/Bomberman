package client.gui;

import client.interact.Interactor;

import java.awt.*;

public class GUIMainMenuButton extends GUIButton implements Interactor {

    private final Color buttonColor = new Color(50, 50, 255);
    private final Color hoverColor = new Color(80, 80, 255);
    private final Color clickColor = new Color(80, 50, 200);

    /**
     * Create buttons in menu
     * @param label
     */
    public GUIMainMenuButton( String label) {
        super(200, 40,label);
        setBackground(buttonColor);
        setHorizontalAlign(GUIComponent.CENTER);
        setVerticalAlign(GUIComponent.CENTER);
    }

    /**
     * Hover button color
     */
    @Override
    public void hover() {
        setBackground(hoverColor);
        setScale(1.2);
    }

    /**
     * Normal bg color
     */
    @Override
    public void unhover() {
        setBackground(buttonColor);
        setScale(1);
    }

    /**
     * After pressed change button scale
     */
    @Override
    public void press() {
        setBackground(clickColor);
        setScale(1.1);
    }

    /**
     * With hover on button add listener too
     */
    @Override
    public void click() {
        hover();
        getOnClickListener().run();
    }
}
