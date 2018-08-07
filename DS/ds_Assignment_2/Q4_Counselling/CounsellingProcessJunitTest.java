package ds_Assignment_2.Q4_Counselling;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CounsellingProcessJunitTest {

    CounsellingProcess cp;

    @Before
    public void init() {
        cp = new CounsellingProcess();
    }

    @Test
    public void testCounsellingProgram() throws IOException {
        cp.addProgram("Programs.xlsx");
        cp.addStudent("Student.xlsx");
        cp.allotPrograms();
    }

    @Test(expected = IOException.class)
    public void programFileNotExistTest() throws IOException {
            cp.addProgram("Programsss.xlsx");
    }

    @Test(expected = IOException.class)
    public void studentFileNotExistTest() throws IOException {
            cp.addStudent("Studentsss.xlsx");
    }
}
