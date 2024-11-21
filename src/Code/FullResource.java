package Code;

import Code.ui.fragments.sidebar.windows.tools.draws.OverDrawManager;
import Code.ui.fragments.sidebar.windows.tools.tools.ToolManager;
import Code.ui.fragments.sidebar.dialogs.DialogManager;
import Code.ui.fragments.sidebar.windows.*;
import Code.ui.fragments.FragmentManager;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import arc.*;

public class FullResource extends Mod {
    public void init() {
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