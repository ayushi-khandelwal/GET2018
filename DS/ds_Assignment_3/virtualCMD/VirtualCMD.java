package ds_Assignment_3.virtualCMD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class VirtualCMD {
    static Directory root;
    static Directory currentDir;

    public static void main(String[] args) {
        String command;

        root = new Directory("R:", null);
        currentDir = root;

        while (true) {
            
            System.out.print(getFullPath(currentDir) + "> ");
            Scanner scan = new Scanner(System.in);
            command = scan.nextLine().trim();
             
            /*String prompt = currentDir.getName();

            Directory temp = currentDir;
            while (temp.getParent() != null) {
                prompt = temp.getParent().getName() + "/" + prompt + "";
                temp = temp.getParent();
            }
            System.out.print(prompt + "> ");*/

            switch (command.split(" ")[0]) {
            case "mkdir":
                makeDirectory(command.replace("mkdir ", ""), currentDir);
                break;
            case "cd":
                if (!changeDirectory(command.replace("cd ", ""))) {
                    System.out.println("No such Directory found!");
                    // System.out.println(currentDir.getName()+ " " +
                    // currentDir.getParent().getName() + " " +
                    // currentDir.getTimeStamp() + " ");
                }
                break;
            case "bk":
                if (!backDir()) {
                    System.out.println("Already on root!");
                }
                break;
            case "ls":
                System.out.println(listDirectories());
                break;
            case "find":
                String findData = findDirectory(currentDir, command.replace("find ", ""));
                if ("".equals(findData)) {
                    System.out.println("Directory not found!");
                } else {
                    System.out.println(findData.replaceAll("R:", "."));
                }
                break;
            case "tree":
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Unknown command");
            }
        }
    }
    
    public static String getFullPath(Directory dir) {
        String prompt = dir.getName();
        while (dir.getParent() != null) {
            prompt = dir.getParent().getName() + "/" + prompt + "";
            dir = dir.getParent();
        }
        return (prompt);
    }

    public static void makeDirectory(String name, Directory parent) {
        Directory newDir = new Directory(name, parent);
        parent.addItem(newDir);
    }

    public static boolean changeDirectory(String name) {
        for (Directory dir : currentDir.getListOfSubDirectories()) {
            if (name.equals(dir.getName())) {
                currentDir = dir;
                return true;
            }
        }
        return false;
    }

    public static boolean backDir() {
        if (currentDir.getParent() != null) {
            currentDir = currentDir.getParent();
            return true;
        }
        return false;
    }

    public static String listDirectories() {
        String details = "";
        for (Directory dir : currentDir.getListOfSubDirectories()) {
            details += dir.getTimeStamp() + "\t" + dir.getName() + "\n";
        }
        details += "\t" + currentDir.getListOfSubDirectories().size()
                + " folder(s)";
        return details;
    }
    
    public static String findDirectory(Directory curDir, String name) {
        String findResult = "";
        if (name.equals(curDir.getName())) {
            findResult += getFullPath(curDir) + "\n";
        }
        
        for (Directory dir : curDir.getListOfSubDirectories()) {
            findResult += findDirectory(dir,name);
        }
        return findResult;
    }
}

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