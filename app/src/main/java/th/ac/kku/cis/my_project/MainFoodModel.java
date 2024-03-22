package th.ac.kku.cis.my_project;

public class MainFoodModel {
    String name,details,location,foodurl;

    MainFoodModel(){

    }
    public MainFoodModel(String name, String details, String location, String foodurl) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.foodurl = foodurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoodurl() {
        return foodurl;
    }

    public void setFoodurl(String foodurl) {
        this.foodurl = foodurl;
    }
}
