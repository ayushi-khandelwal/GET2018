package inheritance_and_composition.implementation;

import inheritance_and_composition.structure.Animal;
import inheritance_and_composition.structure.Cage;
import inheritance_and_composition.structure.Zone;

import java.util.ArrayList;
import java.util.List;

public class ZooManagement {
    int capacity;
    List<Zone> listOfZones = new ArrayList<Zone>();

    public ZooManagement(int capacity) {
    	listOfZones.clear();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean addZone(Zone zone) {
        if (listOfZones.size() < capacity) {
            listOfZones.add(zone);
            return true;
        } else {
            System.out.println("Zoo has reached its limit. Cannot add zone.");
            return false;
        }
    }

    public boolean addCage(Cage cage) {
        for (Zone zone : listOfZones){
            if (cage.getCategoryOfZone() == zone.getCategoryOfZone()) {
                if (zone.addCage(cage)) {
                    return true;
                } 
            } 
        }
        return false;
    }

    public boolean addAnimal(Animal animal) {
        for (Zone zone : listOfZones) {
            if (zone.getCategoryOfZone() == animal.getCategory()) {
                if (zone.addAnimal(animal, listOfZones.indexOf(zone))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean removeAnimal(String animalName) {
        for (Zone zone : listOfZones) {
            if (zone.removeAnimal(animalName)) {
                return true;
            }
        }
        return false;
    }
}
