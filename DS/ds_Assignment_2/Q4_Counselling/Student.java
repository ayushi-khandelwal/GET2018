package ds_Assignment_2.Q4_Counselling;

import java.util.ArrayList;

public class Student {
    String name;
    ArrayList<String> interestedProgram = new ArrayList<>();

    public ArrayList<String> getInterestedProgram() {
        return interestedProgram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterestedProgram(String program) {
        interestedProgram.add(program);
    }
}
