package ds_Assignment_2.CounsellingProcess;

public class StudyProgram {
    String programName;
    int capacity;

    public StudyProgram(String programName, int capacity) {
        this.programName = programName;
        this.capacity = capacity;
    }

    public String getProgramName() {
        return programName;
    }

    public int getCapacity() {
        return capacity;
    }
}
