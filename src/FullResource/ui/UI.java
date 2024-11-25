package FullResource.ui;

import arc.Core;
import arc.scene.ui.ImageButton;
import mindustry.Vars;
import mindustry.ui.dialogs.BaseDialog;

import static mindustry.Vars.state;

public class UI {
    private final ImageButton imageButton = new ImageButton(Core.atlas.find("full-resource-frog"));
    private BaseDialog dialog = new BaseDialog("测试");

    public UI() {
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(70, 70);
            t.top();
            t.x = 300;
            if (!state.rules.waves && state.isCampaign()) {

            } else {
                dialog.cont.add("区块未占领,无法使用该功能").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                //mod名不能有大写字母
                dialog.cont.image(Core.atlas.find("full-resource-frog")).pad(20f).row();
                dialog.cont.button("了解", dialog::hide).size(100f, 50f);
                dialog.show();
            }
            imageButton.clicked(() -> dialog.show());
        });
    }
}