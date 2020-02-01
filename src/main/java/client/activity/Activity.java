package client.activity;

import client.gui.GUIComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Activity {

    private boolean loaded;
    protected boolean loadAsync,  finish;
    protected List<GUIComponent> components = new ArrayList<>();


    public final void load() {
        loaded = false;
        if (loadAsync) {
           new Thread() {
               @Override
               public void run() {
                   onLoad();
                   loaded = true;
               }
            }.start();
        }else {
            onLoad();
            loaded = true;
        }
    }

    protected void onLoad() { }

    public boolean isLoaded() {
        return loaded;
    }

    public boolean isFinish() {
        return finish;
    }

    public void update(int screenWidth, int screenHeight) {
        for (GUIComponent component : components)
            component.revalidate(screenWidth, screenHeight

            );
    }

    public void render(Graphics2D g) {
        for (GUIComponent component : components)
            component.render(g);
    }

    public List<GUIComponent> getComponents() {
        return components;
    }
}
