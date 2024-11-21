package Code.ui;

import mindustry.gen.Icon;

public class Window1 extends Window{
    public Window1() {
        super(Icon.edit, "tool");
        disableRootScroll = true;
        height = 300;
        width = 300;
    }
}
