import java.io.Serializable;

public class Dog implements Serializable {
    private String name;
    private String breed;
    private String gender;

    public Dog(String name, String breed, String gender) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + " raza: " + breed + " sexo: " + gender;
    }

}