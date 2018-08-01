package inheritance_and_composition.animal_type;

import inheritance_and_composition.structure.Animal;

public class Mammal extends Animal {

    public Mammal(String name, int age, String sound) {
        super(name, age, sound);
    }

    public String getInfo() { 
        return  "\nDetails of the animal : " +
                "\nName     : " + getName() +
                "\nAge      : " + getAge() + " years" +
                "\nCategory : " + getCategory() +
                "\nType     : " + getType() + 
                "\nSound    : " + getSound();
    }

}