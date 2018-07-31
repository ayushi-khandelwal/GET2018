package inheritance_and_composition.animals;

import inheritance_and_composition.animal_type.Reptile;

public class Lizard extends Reptile{
    
    public Lizard(String name, int age, String sound, int legs) {
        super(name, age, sound);
        setLegs(legs);
    }
}
