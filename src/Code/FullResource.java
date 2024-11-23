package Code;

import Code.UI.UI;
import arc.Events;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class FullResource extends Mod {
    public FullResource() {
        Events.on(EventType.WorldLoadEndEvent.class, e -> {
            new UI();
        });
    }
}
