package FullResource.core;

import arc.scene.ui.layout.Table;
import arc.struct.*;
import mindustry.*;
import mindustry.ui.*;

public class CoreManager {
    public static final Seq<BaseCore1> windows = new Seq<>();
    public static Table body;

    public static void init(){
        windows.addAll(
            new Core1()
        );

        // windows place for dragging
        Vars.ui.hudGroup.fill(t -> {
            t.name = "Windows";
            for(BaseCore1 window : windows) {
                window.build();
                t.add(window).height(window.getHeight()).width(window.getWidth());
            }
        });

        body = new Table(t -> {
            t.name = "Window Buttons";
            t.left();

            for(BaseCore1 window : windows){
                t.button(window.icon, Styles.emptyi, () -> {
                    window.parent.setLayoutEnabled(false);
                    window.toggle();
                    for (BaseCore1 w : windows) {
                        w.setLayoutEnabled(true);
                    }
                }).size(40f).tooltip(tt -> tt.setBackground(Styles.black6));
                t.row();
            }
        }).left();
    }
}
