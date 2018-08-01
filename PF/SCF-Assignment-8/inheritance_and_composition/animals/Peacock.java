package inheritance_and_composition.animals;

import inheritance_and_composition.animal_type.Bird;

public class Peacock extends Bird {
    
    public Peacock(String name, int age, String sound, int flight) {
        super(name, age, sound);
        setFlightInMeters(flight);
    }
    
}
