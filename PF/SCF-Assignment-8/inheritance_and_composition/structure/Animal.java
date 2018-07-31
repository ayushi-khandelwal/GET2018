package inheritance_and_composition.structure;

import inheritance_and_composition.implementation.Category;
import inheritance_and_composition.implementation.TypeOfAnimal;

public class Animal {
    String name, sound;
    int age;
    TypeOfAnimal type;
    Category category;

    public Animal(String name, int age, String sound) {
        this.name = name;
        this.sound = sound;
        setAge(age);

        switch (this.getClass().getSuperclass().getSimpleName()) {
	        case "Mammal":
	            category = Category.Mammal;
	            break;
	            
	        case "Bird":
	            category = Category.Bird;
	            break;
	            
	        case "Reptile":
	            category = Category.Reptile;
	            break;
	            
	        default:
	            throw new AssertionError("No such animal category exists!");
        }

        switch (this.getClass().getSimpleName()) {
        case "Tiger":
            type = TypeOfAnimal.Tiger;
            break;
        case "Peacock":
            type = TypeOfAnimal.Peacock;
            break;
        case "Crocodile":
            type = TypeOfAnimal.Crocodile;
            break;
        default:
            throw new AssertionError("No such animal exists!");
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public TypeOfAnimal getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    public int getAge() {
        return age;
    }

    public String getInfo() {
        return "null";
    }

}
