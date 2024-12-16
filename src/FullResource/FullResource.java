package FullResource;

import FullResource.core.Core;
import FullResource.ui.UI;
import arc.Events;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class FullResource extends Mod {
    public FullResource() {
        Events.on(EventType.ClientLoadEvent.class, e -> {
//            new Core();
            new UI();
        });
    }
}
