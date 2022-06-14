package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
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

    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparing(Pet::getAge)).orElse(null);
    }

    public String getStatistics() {
        return " The clinic has the following patients:" + System.lineSeparator() +
                this.data.stream().map(pet -> pet.getName() + " " + pet.getOwner()).collect(Collectors.joining(System.lineSeparator()));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(s -> s.getName().equals(name) && s.getOwner().equals(owner)).findFirst().orElse(null);
    }
}
