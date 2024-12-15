package FullResource;

import FullResource.core.Core;
import FullResource.core.FragmentManager;
import FullResource.core.WindowManager;
import arc.Events;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class FullResource extends Mod {
    public FullResource() {
        Events.on(EventType.ClientLoadEvent.class, e -> {
            new Core();
            WindowManager.init();
            FragmentManager.init();
        });
    }
}
