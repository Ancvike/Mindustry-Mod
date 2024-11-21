package Code;

import Code.ui.Window;
import Code.ui.Window1;
import arc.Events;
import arc.struct.Seq;
import mindustry.game.EventType;
import mindustry.mod.*;

public class FullResource extends Mod {
    public static final Seq<Window> windows = new Seq<>();
    public FullResource() {
        Events.on(EventType.ClientLoadEvent.class, e -> {
            //
            windows.addAll(new Window1());
        });
    }
}