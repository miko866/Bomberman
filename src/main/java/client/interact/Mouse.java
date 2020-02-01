package client.interact;

import client.Bomberman;
import client.activity.Activity;
import client.gui.GUIComponent;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class Mouse implements MouseListener, MouseMotionListener {

    private Bomberman bomberman;
    private List<GUIComponent> interactors = new ArrayList<>();
    private List<GUIComponent> hovered =  new ArrayList<>();
    private List<GUIComponent> clicked = new ArrayList<>();

    public Mouse(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    /**
     * Connect activity with interactors
     * @param activity
     */
    public void load(Activity activity) {
        for(GUIComponent component : activity.getComponents())
            if(component instanceof Interactor)
                interactors.add(component);
    }

    /**
     * Mouse event in swing window
     * In menu find mouse enter
     * @param e
     */
    private void move(MouseEvent e) {
        for(GUIComponent component : interactors)  {
            Interactor iact  = (Interactor)  component;
            if (component.getRenderX() <= e.getX() && component.getRenderY() <= e.getY() &&
                component.getRenderX() + component.getRenderedWidth() > e.getX()  &&
                component.getRenderY() + component.getRenderedHeight() > e.getY()) {
                // Menu button not hovered
                if (!hovered.contains(component)) {
                    iact.hover();
                    hovered.add(component);
                }
            } else
                // Menu button hovered
                if(hovered.contains(component)) {
                    iact.unhover();
                    hovered.remove(component);
                }
        }
        // Change size for hovered menu button
        if(hovered.size() > 0) {
            bomberman.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else
            bomberman.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Clicked on menu button
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        for(GUIComponent component : hovered) {
            clicked.add(component);
            ((Interactor) component).press();
        }

    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        for(GUIComponent component : hovered) {
            if(clicked.contains(component))
                ((Interactor) component).click();
        }
        clicked.clear();
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        move(e);
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        move(e);
    }
}
