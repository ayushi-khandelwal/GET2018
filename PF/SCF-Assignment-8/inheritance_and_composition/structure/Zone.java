package inheritance_and_composition.structure;

import inheritance_and_composition.implementation.Category;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    int capacity;
    Category category;
    boolean hasPark, hasCanteen;
    List<Cage> listOfCages = new ArrayList<Cage>();
    
    public Zone(int capacity, Category category2, boolean hasPark, boolean hasCanteen) {
        this.capacity = capacity;
        this.category = category2;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
        listOfCages.clear();
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public Category getCategoryOfZone() {
        return category;
    }

    public boolean addCage(Cage cage) {
        if (category == cage.getCategoryOfZone()) {
            if (listOfCages.size() < capacity) {
                listOfCages.add(cage);
                return true;
            } else {
                System.out.println("Zone has reached it's limit. Can not add cage.");
                return false;
            }

        } else {
            System.out.println("Can not add the cage to this category of zone.");
            return false;
        }
    }

    public boolean addAnimal(Animal animal, int zone) {
        for (Cage cage : listOfCages) {
            if (cage.getTypeOfAnimal() == animal.getType()) {
                if (cage.addAnimal(animal, zone, listOfCages.indexOf(cage))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public String getInfo() {
        return "\nDetails of the zone : " + "\nCategory of animal contained : "
                + getCapacity() + "\nCapacity of the zone : " + getCapacity();
    }


    public boolean removeAnimal(String animalName) {
        for (Cage cage : listOfCages) {
            if (cage.removeAnimal(animalName)) {
                return true;
            }
        }
        return false;
    }
}
