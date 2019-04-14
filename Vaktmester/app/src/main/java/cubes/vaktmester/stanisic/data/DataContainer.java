package cubes.vaktmester.stanisic.data;

import java.util.ArrayList;

public class DataContainer {

    public static ArrayList<Building> buildings;
    public static ArrayList<Ticket> tickets;

    public static ArrayList<SettingsItem> status;
    public static ArrayList<SettingsItem> priority;
    public static ArrayList<SettingsItem> category;

    public static boolean [] checked;

    public static boolean isChecked(int j){

        if(j == 0){
            for (int i = 0; i<DataContainer.status.size(); i++){
                SettingsItem pom = DataContainer.status.get(i);

                if(pom.isSelected){
                    return true;
                }
            }
        }

        if(j == 1){
            for (int i = 0; i<DataContainer.priority.size(); i++){
                SettingsItem pom = DataContainer.priority.get(i);

                if(pom.isSelected){
                    return true;
                }
            }
        }

        if(j == 2){
            for (int i = 0; i<DataContainer.category.size(); i++){
                SettingsItem pom = DataContainer.category.get(i);

                if(pom.isSelected){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean [] checkedList(){
        checked = new boolean[3];

        for(int i = 0; i < checked.length; i++){
            checked[i] = isChecked(i);
        }
        return checked;
    }

}
