package code.ui;

import arc.Core;
import arc.Events;
import arc.scene.ui.ImageButton;
import mindustry.Vars;
import mindustry.content.SectorPresets;
import mindustry.game.EventType;
import mindustry.ui.dialogs.BaseDialog;

public class UI {
    private final ImageButton imageButton = new ImageButton(Core.atlas.find("full-resource-frog"));
    private boolean isUnlocked = false;

    public UI() {
        Events.on(EventType.SectorCaptureEvent.class, e -> {
            isUnlocked = true;
        });
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(70, 70);
            t.top();
            t.x = 300;
            imageButton.clicked(this::fullResource);
        });
    }

    public void fullResource() {
        if (isUnlocked) {
            BaseDialog dialog = new BaseDialog("frog");
            dialog.cont.add("behold").row();
            //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
//        mod名不能有大写字母
            dialog.cont.image(Core.atlas.find("full-resource-frog")).pad(20f).row();
            dialog.cont.button("I see", dialog::hide).size(100f, 50f);
            dialog.show();
        } else {
            BaseDialog dialog1 = new BaseDialog("frog");
            dialog1.cont.add("失败,未成功").row();
            //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
//        mod名不能有大写字母
            dialog1.cont.image(Core.atlas.find("full-resource-frog")).pad(20f).row();
            dialog1.cont.button("I see", dialog1::hide).size(100f, 50f);
            dialog1.show();
        }
    }
}