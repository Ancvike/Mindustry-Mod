package FullResource;

import FullResource.core.Core;
import FullResource.window.WindowManager;
import arc.Events;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class FullResource extends Mod {
    public FullResource() {
        Events.on(EventType.ClientLoadEvent.class, e -> {
            new Core();
            WindowManager.init();
        });
    }
}
