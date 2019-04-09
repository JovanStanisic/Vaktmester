package cubes.vaktmester.stanisic.data;

public class SettingsItem {
    public String id;
    public String name;
    public boolean isSelected;

    public SettingsItem(String id, String name, boolean isSelected){
        this.id = id;
        this.name = name;
        this.isSelected = isSelected;
    }
}
