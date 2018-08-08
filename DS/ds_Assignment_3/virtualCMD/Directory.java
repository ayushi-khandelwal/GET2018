package ds_Assignment_3.virtualCMD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Directory {
    private String name;
    private Directory parent;
    private String timeStamp;
    private List<Directory> listOfSubDirectories;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        timeStamp = Calendar.getInstance().getTime().toString();
        listOfSubDirectories = new ArrayList<Directory>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the parent
     */
    public Directory getParent() {
        return parent;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @return the listOfSubDirectories
     */
    public List<Directory> getListOfSubDirectories() {
        return listOfSubDirectories;
    }

    public void addItem(Directory item) {
        listOfSubDirectories.add(item);
    }

}
