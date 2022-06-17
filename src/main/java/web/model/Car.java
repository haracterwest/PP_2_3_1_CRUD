package web.model;

import java.util.List;


public class Car {

    private String model;
    private int maxSpeed;
    private int yearOfIssue;
    List<Car> cars;



    public Car(String model, int maxSpeed, int yearOfIssue) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.yearOfIssue = yearOfIssue;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", yearOfIssue=" + yearOfIssue +
                '}';
    }
}



