package cubes.vaktmester.stanisic.data;

public class Building {

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
    }


}
