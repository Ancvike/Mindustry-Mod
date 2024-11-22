package Code;

import arc.Core;
import arc.scene.style.BaseDrawable;
import arc.scene.ui.Button;
import arc.scene.ui.Slider;
import arc.scene.ui.layout.Table;
import mindustry.ui.dialogs.BaseDialog;

public class ui extends BaseDialog {
    public ui() {
        super("调试页面");
        BaseDialog dialog = new BaseDialog("frog");
        dialog.cont.add("behold").row();
        //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
        dialog.cont.image(Core.atlas.find("Code-java-mod-frog")).pad(20f).row();
        dialog.cont.button("I see", dialog::hide).size(100f, 50f);
        dialog.show();
    }
}
