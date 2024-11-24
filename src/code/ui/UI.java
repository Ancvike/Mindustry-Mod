package code.ui;

import arc.Core;
import arc.scene.ui.ImageButton;
import mindustry.Vars;
import mindustry.ui.dialogs.BaseDialog;

public class UI {
    private final ImageButton imageButton = new ImageButton(Core.atlas.find("full-resource-frog"));

    public UI() {
        Vars.ui.hudGroup.fill(t -> {
            t.add(imageButton).size(70, 70);
            t.top();
            t.x = 300;
            imageButton.clicked(this::fullResource);
        });
    }
    public void fullResource() {
        BaseDialog dialog = new BaseDialog("frog");
            dialog.cont.add("behold").row();
            //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
//        mod名不能有大写字母
            dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
            dialog.cont.button("I see", dialog::hide).size(100f, 50f);
            dialog.show();
    }
}