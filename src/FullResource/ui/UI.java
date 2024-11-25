package FullResource.ui;

import arc.Core;
import arc.Events;
import arc.scene.ui.ImageButton;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.ui.dialogs.BaseDialog;

import static mindustry.Vars.state;
import static mindustry.Vars.world;

public class UI {
    private final ImageButton imageButton = new ImageButton(Core.atlas.find("full-resource-frog"));
    BaseDialog dialog = new BaseDialog("测试");

    public UI() {
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(70, 70);
            t.top();
            t.x = 300;
        });
        Events.on(EventType.WorldLoadEndEvent.class, e -> {
            dialog_show();
        });
        imageButton.clicked(() -> dialog.show());
    }

    public void dialog_show() {
        if (!(!state.rules.waves && state.isCampaign())) {//区块是否占领
            dialog.cont.add("区块未占领,无法使用该功能").row();
            dialog.cont.image(Core.atlas.find("full-resource-frog")).pad(20f).row();
            dialog.cont.button("了解", dialog::hide).size(100f, 50f);
        }
    }
}