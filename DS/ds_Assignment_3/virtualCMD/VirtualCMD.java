package ds_Assignment_3.virtualCMD;

import java.util.Scanner;

public class VirtualCMD {
    static Directory rootDirectory;
    static Directory currentDirectory;

    public static void main(String[] args) {
        System.out.println(": : : : Welcome to Metacube Virtual Command Prompt : : : :\n");

        String command;

        rootDirectory = new Directory("R:", null);
        currentDirectory = rootDirectory;

        while (true) {

            System.out.print(getFullPath(currentDirectory) + "/> ");
            Scanner scan = new Scanner(System.in);
            command = scan.nextLine().trim();

            /**
             * taking commands from virtual CMD and processing them accordingly
             */
            switch (command.split(" ")[0]) {
            case "mkdir":
                makeDirectory(command.replace("mkdir ", ""), currentDirectory);
                break;
                
            case "cd":
                if (!changeDirectory(command.replace("cd ", ""))) {
                    System.out.println("No such Directory found!");
                }
                break;
                
            case "bk":
                if (!backDirectory()) {
                    System.out.println("Already on root!");
                }
                break;
                
            case "ls":
                System.out.println(listDirectories());
                break;
                
            case "find":
                String findData = findDirectory(currentDirectory, command.replace("find ", ""));
                if ("".equals(findData)) {
                    System.out.println("Directory not found!");
                } else {
                    System.out.println(findData);
                }
                break;
                
            case "tree":
                System.out.println(getTree(currentDirectory, "", 0));
                break;
                
            case "exit":
                scan.close();
                System.exit(0);
                
            default:
                System.out.println("Unknown command");
            }
        }
    }

    /**
     * Get the full path of the given directory
     * 
     * @param directory
     * @return path of the given directory
     */
    public static String getFullPath(Directory directory) {
        String prompt = directory.getName();
        while (directory.getParent() != null) {
            prompt = directory.getParent().getName() + "/" + prompt + "";
            directory = directory.getParent();
        }
        return (prompt);
    }

    /**
     * Make a new directory with given name in the given parent directory
     * 
     * @param name
     * @param parent
     */
    public static void makeDirectory(String name, Directory parent) {
        Directory newDirectory = new Directory(name, parent);
        parent.addItem(newDirectory);
    }

    /**
     * Change current directory to given directory
     * 
     * @param name
     * @return true if directory changed successfully and false otherwise
     */
    public static boolean changeDirectory(String name) {
        for (Directory directory : currentDirectory.getListOfSubDirectories()) {
            if (name.equals(directory.getName())) {
                currentDirectory = directory;
                return true;
            }
        }
        return false;
    }

    /**
     * Go to the parent directory
     * 
     * @return true if successful and false if already on rootDirectory and cant go any back
     */
    public static boolean backDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
            return true;
        }
        return false;
    }

    /**
     * list all the sub directories of current directory
     */
    public static String listDirectories() {
        String details = "";
        for (Directory directory : currentDirectory.getListOfSubDirectories()) {
            details += directory.getTimeStamp() + "\t" + directory.getName() + "\n";
        }
        details += "\t" + currentDirectory.getListOfSubDirectories().size() + " folder(s)";
        return details;
    }

    public static String findDirectory(Directory curDirectory, String name) {
        String findResult = "";
        if (name.equals(curDirectory.getName())) {
            findResult += getFullPath(curDirectory) + "\n";
            if (curDirectory == currentDirectory) {
                findResult = findResult.replace(curDirectory.getName(), ".");
            }
        }

        for (Directory directory : curDirectory.getListOfSubDirectories()) {
            findResult += findDirectory(directory, name);
        }
        return findResult;
    }

    public static String getTree(Directory curDirectory, String result, int level) {
        if (curDirectory == currentDirectory) {
            result += ".\n";
        } else {
            result += curDirectory.getName() + "\n";
        }

        for (int loopIterator = 0; loopIterator < curDirectory.getListOfSubDirectories().size(); loopIterator++) {
            Directory directory = curDirectory.getListOfSubDirectories().get(loopIterator);
            for (int lvl = level; lvl > 0; lvl--) {
                result += "   ";
            }

            if (loopIterator != curDirectory.getListOfSubDirectories().size() - 1) {
                result += "\u251c\u2500\u2500";
            } else {
                result += "\u2514\u2500\u2500";
            }

            result = getTree(directory, result, level + 1);
        }
        return result;
    }
}