package inheritance_and_composition.structure;

import inheritance_and_composition.implementation.Category;
import inheritance_and_composition.implementation.TypeOfAnimal;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    int capacity;
    TypeOfAnimal typeOfAnimal;
    Category categoryOfZone;
    List<Animal> listOfAnimals = new ArrayList<Animal>();

    public Cage(int capacity, Category category, TypeOfAnimal animalType) {
        this.capacity = capacity;
        this.categoryOfZone = category;
        switch (animalType) {
        case Crocodile : 
            this.typeOfAnimal = TypeOfAnimal.Crocodile;
            break;
        case Tiger : 
            this.typeOfAnimal = TypeOfAnimal.Tiger;
            break;
        case Peacock : 
            this.typeOfAnimal = TypeOfAnimal.Peacock;
            break;
        default:
            break;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public Category getCategoryOfZone() {
        return categoryOfZone;
    }

    public TypeOfAnimal getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public boolean addAnimal(Animal animal, int zone, int i) {
        if (typeOfAnimal == animal.getType()) {
            if (listOfAnimals.size() < capacity) {
                listOfAnimals.add(animal);
                return true;
            } else {
                System.out.println("Cage has reached it's limit. Can not add animal.");
                return false;
            }

        } else {
            System.out.println("Can not add the animal to this category of cage.");
            return false;
        }
    }

    public String getInfo() {  
        String animals = "";
        for (Animal animal : listOfAnimals) {
            int index = 1;
            animals = "\n" + index + ". " + animal.getType();
        }
        return "\nType of animal contained : " + getTypeOfAnimal() +
                "\nCapacity of the cage : " + getCapacity() + 
                "\nList of animals : " +  animals + "\n";
    }

    public boolean removeAnimal(String animalName) {
        for (Animal animal : listOfAnimals) {
            if (animal.getName() == animalName) {
                listOfAnimals.remove(animal);
                System.out.println("\nAnimal removed successfully.\n");
                return true;
            }
        }
        return false;
    }
}
