package informatis.ui.fragments;

import informatis.ui.fragments.sidebar.dialogs.DialogManager;
import informatis.ui.fragments.sidebar.TroopingFragment;
import informatis.ui.fragments.sidebar.windows.WindowManager;

public class FragmentManager {
    public static QuickSchemFragment quickSchemFragment;
    public static SidebarSwitcher sidebarSwitcherFragment;

    public static void init() {

        quickSchemFragment = new QuickSchemFragment();
        sidebarSwitcherFragment = new SidebarSwitcher(
                    WindowManager.body,
                    DialogManager.body,
                    new TroopingFragment() // cache later?
            );
    }
}
