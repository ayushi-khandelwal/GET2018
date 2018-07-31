package inheritance_and_composition.animal_type;

import inheritance_and_composition.structure.Animal;

public class Reptile extends Animal {
    int legs;

    public Reptile(String name, int age, String sound) {
        super(name, age, sound);
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }
    
    public String getInfo() {
        return  "\nDetails of the animal : " +
                "\nName       : " + getName() +
                "\nAge        : " + getAge() +  " years" +
                "\nCategory   : " + getCategory() +
                "\nType       : " + getType() + 
                "\nSound      : " + getSound() +
                "\nNo of Legs : " + getLegs();
    }
}