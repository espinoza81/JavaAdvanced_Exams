package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    public List<Car> data;
    public int capacity;
    public String name;

    public Dealership(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public String getStatistics() {
        return " The cars are in a car dealership " + this.name + ":" + System.lineSeparator() +
                this.data.stream().map(Car::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(s -> s.getManufacturer().equals(manufacturer) && s.getModel().equals(model)).findFirst().orElse(null);
    }

    public boolean buy(String manufacturer, String model) {
        Car carToRemove = this.data.stream().filter(s -> s.getManufacturer().equals(manufacturer) && s.getModel().equals(model)).findFirst().orElse(null);
        if(carToRemove != null) {
            return this.data.remove(carToRemove);
        }
        return false;
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
