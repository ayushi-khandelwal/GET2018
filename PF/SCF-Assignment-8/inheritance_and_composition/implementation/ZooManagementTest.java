package inheritance_and_composition.implementation;

import static org.junit.Assert.*;
import inheritance_and_composition.animals.*;
import inheritance_and_composition.structure.*;

import org.junit.Before;
import org.junit.Test;

public class ZooManagementTest {
    
    ZooManagement zoo = new ZooManagement(3);
    
    @Before
    public void init() {

        Zone zoneMammal = new Zone(3, Category.Mammal, true, true);
        zoo.addZone(zoneMammal);

        Zone zoneBird = new Zone(2, Category.Bird, true, true);
        zoo.addZone(zoneBird);

        Zone zoneReptile = new Zone(1, Category.Reptile, true, true);
        zoo.addZone(zoneReptile);
    }

    @Test
    public void test1() {

        Cage cageMammal = new Cage(1, Category.Mammal, TypeOfAnimal.Tiger);
        zoo.addCage(cageMammal);
        
        Animal tiger = new Tiger("Shera", 5, "MEOW");
        
        assertEquals(true, zoo.addAnimal(tiger));

        System.out.print(cageMammal.getInfo());
        System.out.print(tiger.getInfo());
        
        assertEquals(true, zoo.removeAnimal("Shera"));
        System.out.print(cageMammal.getInfo());
        System.out.print(tiger.getInfo());
    }

    

    @Test
    public void test2() {

        Cage cageBird = new Cage(1, Category.Bird, TypeOfAnimal.Peacock);

        zoo.addCage(cageBird);
        
        Animal peacock = new Peacock("Peacock", 2, "Cookdookoo", 20);
        
        assertEquals(true, zoo.addAnimal(peacock));

    }


    @Test
    public void test3() {
        Category categoryReptile = Category.Reptile;
        TypeOfAnimal animalType = TypeOfAnimal.Lizard;

        
        Cage cageReptile = new Cage(1, categoryReptile, animalType);

        zoo.addCage(cageReptile);
        
        Animal crocodile = new Crocodile("Chitti", 2, "Cookdookoo", 20);
        
        assertEquals(false, zoo.addAnimal(crocodile));

    }

/*
    @Test
    public void test4() {
        
        assertEquals(true, zoo.removeAnimal("Peacock"));

    }*/

}
