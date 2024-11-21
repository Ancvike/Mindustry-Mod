package Code.ui.fragments.sidebar.windows;

public interface ToolConfigable {
    String getName();
    void setEnabled(boolean value);
    boolean isEnabled();
    ToolConfigable[] getSubConfigs();
}
