import java.util.ArrayList;

public class AnimalShelter {
    
    private ArrayList<Dog> dogs;

    public AnimalShelter() {
        dogs = new ArrayList<>();
    }

    public void registerNewDog(Dog dog) {
        dogs.add(dog);
    }

    @Override
    public String toString() {
        return dogs.toString();
    }
}
