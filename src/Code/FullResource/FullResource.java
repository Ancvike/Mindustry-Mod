package Code.FullResource;

import arc.Events;
import mindustry.content.SectorPresets;
import mindustry.game.EventType;

public class FullResource extends SectorPresets {
    public FullResource() {
        Events.on(EventType.ClientLoadEvent.class, e ->{
            groundZero.captureWave = 1;
            System.out.println("123123");
        });

    }
}