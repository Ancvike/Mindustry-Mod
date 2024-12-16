package FullResource.ui;

import FullResource.core.CoreWindow;
import arc.Core;
import arc.scene.ui.ImageButton;
import mindustry.Vars;

public class UI {
    public final ImageButton imageButton = new ImageButton(Core.atlas.find("full-resource-frog"));
    public CoreWindow coreWindow = new CoreWindow();
    public UI() {
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(70, 70);
            t.top();
            t.x = 300;
        });
        Vars.ui.hudGroup.fill(t -> {
            t.name = "Windows";
            coreWindow.build();
            t.add(coreWindow);
        });
    }
}