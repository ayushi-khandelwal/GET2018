package ds_Assignment_2.CounsellingProcess;

import java.util.List;

public class Student {
    String name;
    List<String> listOfChoices;

    public Student(String name, List<String> list) {
        this.name = name;
        listOfChoices = list;
    }

    public String getName() {
        return name;
    }

    public List<String> getListOfChoices() {
        return listOfChoices;
    }
}
