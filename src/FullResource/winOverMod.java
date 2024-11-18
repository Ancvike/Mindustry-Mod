package FullResource;

import arc.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class winOverMod extends Mod {
    public winOverMod() {
        //Events.on侦听事件是否触发,e为事件触发后进行动作
        //SectorCaptureEvent为区域占领后触发事件
        Events.on(ClientLoadEvent.class, e -> {
            BaseDialog dialog = new BaseDialog("frog");
            dialog.cont.add("su").row();
            dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
            dialog.cont.button("Mod", dialog::hide).size(100f, 50f);
            dialog.show();
        });
    }
}