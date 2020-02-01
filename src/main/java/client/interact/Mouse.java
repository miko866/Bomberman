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

    public void load(Activity activity) {
        for(GUIComponent component : activity.getComponents())
            if(component instanceof Interactor)
                interactors.add(component);
    }

    private void move(MouseEvent e) {
        for(GUIComponent component : interactors)  {
            Interactor iact  = (Interactor)  component;
            if (component.getRenderX() <= e.getX() && component.getRenderY() <= e.getY() &&
                component.getRenderX() + component.getRenderedWidth() > e.getX()  &&
                component.getRenderY() + component.getRenderedHeight() > e.getY()) {
                if (!hovered.contains(component)) {
                    iact.hover();
                    hovered.add(component);
                }
            } else
                if(hovered.contains(component)) {
                    iact.unhover();
                    hovered.remove(component);
                }
        }
        if(hovered.size() > 0) {
            bomberman.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else
            bomberman.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(GUIComponent component : hovered) {
            clicked.add(component);
            ((Interactor) component).press();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(GUIComponent component : hovered) {
            if(clicked.contains(component))
                ((Interactor) component).click();
        }
        clicked.clear();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        move(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        move(e);
    }
}
