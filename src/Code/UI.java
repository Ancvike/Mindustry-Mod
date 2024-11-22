package Code;

import arc.scene.ui.Button;
import arc.scene.ui.Slider;
import arc.scene.ui.layout.Table;
import mindustry.ui.dialogs.BaseDialog;

public class UI {
    private final BaseDialog baseDialog;

    public UI() {
        baseDialog = new BaseDialog("测试页");

        Table table = new Table();  // 创建一个表格用于布局
        Slider speedSlider = new Slider(1, 10, 1, false);  // 创建滑块，范围从1到10，步长为1
        // 将滑块和按钮添加到表格
        table.add(speedSlider).fillX().pad(10);  // 添加滑块，填充宽度并加一些边距
        // 创建 "退出测试" 按钮
        Button exitButton = new Button();
        exitButton.addListener(event -> {
            baseDialog.hide(); // 关闭对话框
            return true; // 返回 true 表示事件已处理
        });
        baseDialog.cont.add(exitButton).pad(10); // 添加退出按钮到对话框
        baseDialog.show();
    }
}