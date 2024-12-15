package FullResource;

import FullResource.core.Core;
import FullResource.core.DialogManager;
import FullResource.core.SidebarSwitcher;
import FullResource.core.WindowManager;
import arc.Events;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class FullResource extends Mod {
    public static SidebarSwitcher sidebarSwitcherFragment;
    public FullResource() {
        Events.on(EventType.ClientLoadEvent.class, e -> {
            new Core();
            WindowManager.init();
            sidebarSwitcherFragment = new SidebarSwitcher(
                    WindowManager.body,
                    DialogManager.body
            );
        });
    }
}
