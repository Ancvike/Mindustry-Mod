package code.ui;

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
            imageButton.clicked(this::fullResource);
        });
    }

    public void fullResource() {
        if(!state.rules.waves && state.isCampaign()){

        }else {
            dialog.cont.add("false").row();
            //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
            //mod名不能有大写字母
            dialog.cont.image(Core.atlas.find("full-resource-frog")).pad(20f).row();
            dialog.cont.button("error", dialog::hide).size(100f, 50f);
            dialog.show();
        }
    }
}