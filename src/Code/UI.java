package Code;

import arc.scene.ui.Slider;
import arc.scene.ui.TextButton;
import arc.scene.ui.layout.Table;
import mindustry.ui.dialogs.BaseDialog;

public class UI {
    BaseDialog baseDialog = new BaseDialog("测试页");
    Table table = new Table();  // 创建一个表格用于布局
    Slider speedSlider = new Slider(1, 10, 1, false);  // 创建滑块，范围从1到10，步长为1
    TextButton exitButton = new TextButton("退出测试");

    public UI() {
        table.add(speedSlider).fillX().pad(10);  // 将滑块添加到表格，填充宽度并加一些边距
        baseDialog.add(table);
        baseDialog.addCloseButton();  // 添加关闭按钮
        // 显示对话框
        baseDialog.show();
        exitButton.clicked(baseDialog::hide);
//        BaseDialog baseDialog = new BaseDialog("测试页");
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                baseDialog.show();
//            }
//        };
//        Table table = new Table();  // 创建一个表格用于布局
//        Slider speedSlider = new Slider(1, 10, 1, false);  // 创建滑块，范围从1到10，步长为1
//        // 将滑块和按钮添加到表格
//        table.add(speedSlider).fillX().pad(10);  // 添加滑块，填充宽度并加一些边距
//        // 创建 "退出测试" 按钮
//        TextButton exitButton = new TextButton("退出测试");
//        baseDialog.cont.add(exitButton).pad(10); // 添加退出按钮到对话框
//        baseDialog.show();
    }
}