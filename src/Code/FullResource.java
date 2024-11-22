package Code;

import arc.Events;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class FullResource extends Mod {
    public FullResource() {
        Events.on(EventType.ClientLoadEvent.class, e -> {
            new UI();
        });
    }
}
