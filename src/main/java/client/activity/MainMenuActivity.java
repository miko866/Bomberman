package client.activity;

import client.BombermanPanel;
import client.gui.GUIButton;
import client.gui.GUIComponent;
import client.gui.GUIMainMenuButton;

import java.awt.*;

public class MainMenuActivity extends Activity {

    public MainMenuActivity() {
        GUIMainMenuButton start = new GUIMainMenuButton("Start Game");
        start.setY(-110);
        start.setOnClickListener(new Runnable() {
            @Override
            public void run() {
                MainMenuActivity.this.finish = true;
                BombermanPanel.startActivity(GameActivity.class);
            }
        });

        GUIButton multi = new GUIMainMenuButton("Multi Players");
        multi.setY(-50);

        GUIButton options = new GUIMainMenuButton( "Options");
        options.setY(10);

        GUIButton leave = new GUIMainMenuButton("Quit Game");
        leave.setY(70);

        components.add(start);
        components.add(multi);
        components.add(options);
        components.add(leave);

    }
}
