package ds_Assignment_2.Q4_Counselling;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
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

    @Test
    public void programFileNotExistTest() {
        try {
            cp.addProgram("Programs.xlsx");
        } catch (IOException ex) {
            assertEquals("File Not Found while adding Programs", ex.getMessage());
        }
    }

    @Test
    public void studentFileNotExistTest() {
        try {
            cp.addStudent("Student.xlsx");
        } catch (IOException ex) {
            assertEquals("File Not Found while adding Students", ex.getMessage());
        }
    }
}
