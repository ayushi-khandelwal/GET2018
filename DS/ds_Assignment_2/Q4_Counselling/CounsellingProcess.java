package ds_Assignment_2.Q4_Counselling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Ayushi
 *
 */
public class CounsellingProcess {
    ArrayList<Program> programList = new ArrayList<Program>();
    CircularQueue queueOfStudents = new CircularQueue(100);
    int noOfStudents = 0;

    /**
     * @param fileName
     * @throws IOException
     * 
     * adds program excel file in ProgramList
     */
    public void addProgram(String fileName) throws IOException {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
           
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Program program = new Program();
                
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                    case 0:
                        program.setName((String) nextCell.getStringCellValue());
                        break;
                        
                    case 1:
                        program.setCapacity((int) nextCell.getNumericCellValue());
                        break;
                    }
                }
                programList.add(program);
            }
            workbook.close();
            inputStream.close();
        } catch (IOException ex) {
            throw new IOException("File Not Found while adding Programs");
        }
    }

    /**
     * @param fileName
     * @throws IOException
     * 
     * adds Student excel file in queue
     */
    public void addStudent(String fileName) throws IOException {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Student student = new Student();
                
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    
                    switch (columnIndex) {
                    case 0:
                        student.setName((String) nextCell.getStringCellValue());
                        break;
                        
                    default:
                        student.setInterestedProgram((String) nextCell.getStringCellValue());
                        break;
                    }
                }
                queueOfStudents.enQueue(student);
                noOfStudents++;
            }
            workbook.close();
            inputStream.close();
        } catch (IOException ex) {
            throw new IOException("File Not Found while adding Students");
        }
    }

    /**
     * @throws FileNotFoundException
     * @throws IOException
     * 
     * 
     */
    public void allotPrograms() throws FileNotFoundException, IOException {
        ArrayList<AllocatedPrograms> selectedProgramList = new ArrayList<>();
        
        for (int i = 0; i < noOfStudents; i++) {
            Student student = queueOfStudents.deQueue();
            
            for (int j = 0, k = 0; j < 5;) {
                if (k == programList.size()) {
                    j++;
                    k = 0;
                } 
                else if (student.getInterestedProgram().get(j).equals(programList.get(k).getName())
                        && programList.get(k).getCapacity() > 0) {
                    selectedProgramList.add(new AllocatedPrograms(student.getName(), programList.get(k).getName()));
                    programList.get(k).setCapacity(programList.get(k).getCapacity() - 1);
                    break;
                } 
                else {
                    k++;
                }
            }
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("List of Students");
        int rowCount = 0;
        
        for (AllocatedPrograms sp : selectedProgramList) {
            Row row = sheet.createRow(rowCount);
            writeBook(sp, row);
            rowCount++;
        }

        try (FileOutputStream outputStream = new FileOutputStream(new File("SelectedPrograms.xlsx"))) {
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();
        }
    }

    private void writeBook(AllocatedPrograms sp, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(sp.getStudentName());

        cell = row.createCell(2);
        cell.setCellValue(sp.getSelectedProgram());
    }
}
