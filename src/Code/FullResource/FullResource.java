package Code.FullResource;

import arc.Core;
import arc.Events;
import arc.util.Time;
import mindustry.game.EventType;
import mindustry.ui.dialogs.BaseDialog;

public class FullResource {
    public FullResource() {
        Events.on(EventType.ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("Code-java-mod-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }
}
