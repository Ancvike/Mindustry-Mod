package informatis;

import informatis.core.setting.SharSettingUI;
import informatis.ui.fragments.sidebar.dialogs.DialogManager;
import informatis.ui.fragments.sidebar.windows.*;
import informatis.ui.fragments.FragmentManager;

import informatis.ui.fragments.sidebar.windows.tools.draws.OverDrawManager;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import arc.*;

public class Informatis extends Mod {
    @Override
    public void init(){
        Events.on(ClientLoadEvent.class, e -> {
            SharSettingUI.init();
            WindowManager.init();
            DialogManager.init();
            FragmentManager.init();
            OverDrawManager.init();
            SVars.init();
        });
    }
}
