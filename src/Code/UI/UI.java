package Code.UI;

import arc.util.Time;
import mindustry.Vars;
import mindustry.ui.dialogs.BaseDialog;

public class UI {
    public UI() {
        Vars.ui.menuGroup.fill(c -> {
            c.bottom().right();
            c.button("点我", () -> {
                Vars.ui.loadfrag.show();
                Time.runTask(10f, () -> {
                    Vars.ui.loadfrag.hide();
                });
                BaseDialog baseDialog = new BaseDialog("按钮测试页");
                baseDialog.addCloseButton();
                baseDialog.show();
            }).size(200, 60).padBottom(45);
        });
    }
}