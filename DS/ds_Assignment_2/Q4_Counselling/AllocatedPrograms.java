package ds_Assignment_2.Q4_Counselling;

public class AllocatedPrograms {
    String studentName;
    String selectedProgram;

    public AllocatedPrograms(String studentName, String selectedProgram) {
        this.studentName = studentName;
        this.selectedProgram = selectedProgram;
    }

    public String getSelectedProgram() {
        return selectedProgram;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setSelectedProgram(String selectedProgram) {
        this.selectedProgram = selectedProgram;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
