package FullResource.ui;

import FullResource.test.SidebarSwitcher;
import arc.Core;
import arc.scene.ui.ImageButton;
import arc.scene.ui.layout.Table;
import mindustry.Vars;

public class UI {
    public final ImageButton imageButton = new ImageButton(Core.atlas.find("full-resource-frog"));
    public static SidebarSwitcher sidebarSwitcherFragment;
    Table table = new Table();
    public UI() {
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(70, 70);
            t.top();
            t.x = 300;
        });
        table.add(imageButton).size(70, 70);
        sidebarSwitcherFragment = new SidebarSwitcher(table);
    }
}