package code.ui;

import arc.Core;
import arc.scene.ui.ImageButton;
import mindustry.Vars;

public class UI {
    private final ImageButton imageButton = new ImageButton(Core.atlas.find("full-resource-frog"));

    public UI() {
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(70, 70);
            t.top();
            t.x = 300;
            imageButton.clicked(this::fullResource);
        });
    }

    public void fullResource() {

    }
}