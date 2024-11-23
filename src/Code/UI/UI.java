package Code.UI;

import arc.Core;
import arc.scene.ui.ImageButton;
import mindustry.Vars;

public class UI {
    ImageButton imageButton = new ImageButton(Core.atlas.find("Code-java-mod-frog"));

    public UI() {
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(100,100);
            t.top();
            t.originX = 300;
        });
    }

    public void onClick() {

    }
}