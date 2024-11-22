package Code;

import arc.scene.ui.Button;
import arc.scene.ui.Slider;
import arc.scene.ui.TextButton;
import arc.scene.ui.layout.Table;
import mindustry.ui.dialogs.BaseDialog;

public class UI extends BaseDialog {

    public UI() {
        super("设置");  // 设置对话框的标题

        Table table = new Table();  // 创建一个表格用于布局
        Slider speedSlider = new Slider(1, 10, 1, false);  // 创建滑块，范围从1到10，步长为1
        Button applyButton = new TextButton("应用", new TextButton.TextButtonStyle());  // 创建应用按钮（可以添加样式）

        // 监听按钮点击事件
        applyButton.addListener(event -> {
            float selectedSpeed = speedSlider.getValue();  // 获取滑块当前值
            // 这里可以根据所选速度执行相应的操作
            System.out.println("选中的速度: " + selectedSpeed);
            return true;  // 表示事件处理完毕
        });

        // 将滑块和按钮添加到表格
        table.add(speedSlider).fillX().pad(10);  // 添加滑块，填充宽度并加一些边距
        table.row();  // 换行
        table.add(applyButton).pad(10);  // 添加按钮并加一些边距

        add(table).pad(10);  // 将表格添加到对话框并加一些外边距
        pack();  // 自动调整对话框大小以适应内容
    }
}