package Code.FullResource;

import arc.Core;
import mindustry.Vars;
import mindustry.ui.dialogs.BaseDialog;

public class FullResource {
    public FullResource() {
        BaseDialog dialog = new BaseDialog("frog");
        dialog.cont.add("behold").row();
        dialog.cont.image(Core.atlas.find("Code-java-mod-frog")).pad(20f).row();
        dialog.cont.button("I see", dialog::hide).size(100f, 50f);
        dialog.show();
    }
}