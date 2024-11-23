package Code.UI;

import arc.util.Time;
import mindustry.Vars;
import mindustry.ui.dialogs.BaseDialog;

public class UI {
    BaseDialog baseDialog = new BaseDialog("测试页");

    public UI() {
        baseDialog.addCloseButton();
        Vars.ui.hudGroup.fill(t -> {
            t.button("点我", () -> {
                Vars.ui.loadfrag.show();
                Time.runTask(100f, () -> {//xx秒后运行下面代码
                    Vars.ui.loadfrag.hide();
                    baseDialog.show();
                });
            }).size(200, 60).padBottom(45);
        });
    }
}