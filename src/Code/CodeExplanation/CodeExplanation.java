package Code.CodeExplanation;

public class CodeExplanation {
    //原作者示例代码
//        Log.info("Loaded ExampleJavaMod constructor.");
//            //listen for game load event
//        Events.on(EventType.ClientLoadEvent .class, e -> {
//        //show dialog upon startup
//        Time.runTask(10f, () -> {
//            BaseDialog dialog = new BaseDialog("frog");
//            dialog.cont.add("behold").row();
//            //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
//            dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
//            dialog.cont.button("I see", dialog::hide).size(100f, 50f);
//            dialog.show();
//        });
//    });
//    @Override
//    public void loadContent(){
//        Log.info("Loading some example content.");
//    }
    //我的UI测试代码
//    BaseDialog baseDialog = new BaseDialog("测试页");
//    Table table = new Table();  // 创建一个表格用于布局
//    Slider speedSlider = new Slider(1, 10, 1, false);  // 创建滑块，范围从1到10，步长为1
//    TextButton exitButton = new TextButton("退出测试");
//
//    public UI() {
//        table.add(speedSlider).fillX().pad(10);
//        baseDialog.cont.add(exitButton).pad(10);// 将滑块添加到表格，填充宽度并加一些边距
//        baseDialog.add(table);
//        baseDialog.addCloseButton();  // 添加关闭按钮
//        // 显示对话框
//        baseDialog.show();
//        exitButton.clicked(baseDialog::hide);
//  }

}