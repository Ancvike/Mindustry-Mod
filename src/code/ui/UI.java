package code.ui;

import arc.Core;
import arc.scene.ui.ImageButton;
import mindustry.Vars;

public class UI {
    ImageButton imageButton = new ImageButton(Core.atlas.find("code-java-mod-frog"));

    public UI() {
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(100,100);
            t.top();
            t.x = 300;
        });
    }

    public void onClick() {

    }
}