package cubes.vaktmester.stanisic.data;

import java.io.Serializable;

public class Building implements Serializable {

    public int id;
    public String adress;
    public double latitude;
    public double longitude;
    public int image;
    public String notes;
    public int tasksCount;
    public String contactName;
    public String contactPhone;
    public String borettslagName;
    public String buildingName;

    //konstruktor za listvju item

    public Building(String buildingName, String adress, int tasksCount, int image){
        this.adress = adress;
        this.buildingName = buildingName;
        this.image = image;
        this.tasksCount = tasksCount;
        notes = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using It is a long established fact that a reader will be distracted by the readable content established fact that a reader…";
        contactName = "Marko Markovic";
        contactPhone = "+381 011 2425 242";
        latitude = 59.4239768;
        longitude = 10.6860583;
    }


}
