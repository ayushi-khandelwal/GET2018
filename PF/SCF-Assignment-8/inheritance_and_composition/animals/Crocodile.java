package inheritance_and_composition.animals;

import inheritance_and_composition.animal_type.Reptile;

public class Crocodile extends Reptile{
    
    public Crocodile(String name, int age, String sound, int legs) {
        super(name, age, sound);
        setLegs(legs);
    }
    
}
