package inheritance_and_composition.animal_type;

import inheritance_and_composition.structure.Animal;

public class Bird extends Animal {
    public Bird(String name, int age, String sound) {
        super(name, age, sound);
    }

    int flightInMeters;
    
    public void setFlightInMeters(int flight) {
        this.flightInMeters = flight;
    }
    
    public int getFlightInMeters() {
        return flightInMeters;
    }
    
    public String getInfo() {
        return  "\nDetails of the animal : " +
                "\nName          : " + getName() +
                "\nAge           : " + getAge() + " years" +
                "\nCategory      : " + getCategory() +
                "\nType          : " + getType() + 
                "\nSound         : " + getSound() +
                "\nFlight(meter) : " + getFlightInMeters();
    }
}
