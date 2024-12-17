package informatis;

import informatis.ui.fragments.sidebar.windows.tools.draws.OverDrawManager;
import informatis.ui.fragments.sidebar.windows.tools.tools.ToolManager;
import informatis.ui.fragments.sidebar.dialogs.DialogManager;
import informatis.ui.fragments.sidebar.windows.*;
import informatis.ui.fragments.FragmentManager;

import mindustry.game.EventType.*;
import mindustry.mod.*;
import arc.*;

public class Informatis extends Mod {
    @Override
    public void init(){
        Events.on(ClientLoadEvent.class, e -> {
            WindowManager.init();
            DialogManager.init();
            FragmentManager.init();
            OverDrawManager.init();
            ToolManager.init();
            SVars.init();
        });
    }
}
