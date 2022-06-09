package groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.remove(this.data.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null));
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return " The grooming salon has the following clients:" + System.lineSeparator() +
                this.data.stream().map(pet -> pet.getName() + " " + pet.getOwner()).collect(Collectors.joining(System.lineSeparator()));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(s -> s.getName().equals(name) && s.getOwner().equals(owner)).findFirst().orElse(null);
    }
}
