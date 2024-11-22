package Code;

import arc.scene.style.BaseDrawable;
import arc.scene.ui.Button;
import arc.scene.ui.Slider;
import arc.scene.ui.layout.Table;
import mindustry.ui.dialogs.BaseDialog;

public class ui extends BaseDialog {
    public ui() {
        super("调试页面");
        Table table = new Table();
        Slider speedSlider = new Slider(1, 10, 1, false);
        Button applyButton = new Button();
        applyButton.addListener(event -> {
            float selectedSpeed = speedSlider.getValue();
            // 处理选中速度
            return true;
        });

        table.add(speedSlider).fillX().pad(10);
        table.row();
        table.add(applyButton).pad(10);
        add(table).pad(10);
        pack();
        setSize(200,100);
    }
}
