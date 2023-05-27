import java.io.File;
import java.io.FileFilter;
import java.util.Objects;

public class MINDER {
    static int deepestLvl = 0;
    static String deepestItem = "";
    public static void main(String[] args) {

        File directory = new File("basedir\\dir0");
        String dir = "/Users/macbook/Documents/Javacourse/LAB03/src/basedir";
        File all = new File (dir);

        try {
            int fileCounter = 0, dirsCount = 0,txtCounter = 0, nontxt = 0;
            File[] files = directory.listFiles();
            File[] allFiles = all.listFiles();
            File[] driver = all.listRoots();


            System.out.println("deepest file: " + findDeepest(all));
            freeDiskSpace(all);
            countDisks(driver);
            System.out.println();
            long max = 0;
            assert allFiles != null;
            for (File m: allFiles) {
                if (m.length() > max) {
                    max = m.length();
                }
            }
            System.out.println("The maximum directory length is: " + max);
            assert files != null;
            for (File f : files) {
                if (f.isFile()) fileCounter++;

                if (f.getName().endsWith(".txt"))  {
                    System.out.println(f.getAbsolutePath());
                    txtCounter++;
                } else {
                    nontxt ++;
                }
                if (f.isDirectory()) System.out.println("Directory: " + f.getName());

            }
            System.out.println();
            System.out.println("The total number of files and directories: " + (fileCounter + (files.length - fileCounter)));
            System.out.println("Number of files: " + fileCounter);
            System.out.println("Number of dirs: " + (files.length - fileCounter));
            System.out.println("Number of .txt files: " + txtCounter);
            System.out.println("Non .txt files: " + nontxt);
            System.out.println("Absolute path of tree.txt: ");
            System.out.println();

            directory = new File("tree.txt");
            absolutePath(directory);
            System.out.println();

            File dire = new File(dir);
            if (dire.exists() && dire.isDirectory()) {
                File arr[] = dire.listFiles();
                System.out.println("***********************************************");
                System.out.println("      Files from main directory: " + dire);
                System.out.println("***********************************************");
                nestedFiles(arr, 0);
            }
            System.out.println();
            FileFilter fileFilter = pathname -> {
                if (pathname.isDirectory() && Objects.requireNonNull(pathname.list()).length == 0) {
                    return true;
                } else {
                    return false;
                }
            };

            File[] list = dire.listFiles(fileFilter);
            System.out.println("List of empty files: ");
            for (File fileName : list) {
                System.out.println(fileName.getName());
                System.out.println(fileName);
            }

        }
        catch (NullPointerException e) {
            System.out.println("No files in directory");
        }
        catch (Exception e) {
            System.out.println("Unknown error");
        }
    }

    public static void absolutePath (File file) {
        System.out.println("The absolute path: " + file.getAbsolutePath());
    }

    public static void nestedFiles (File[] arr, int level) {

        for (File f:  arr) {
            for (int i = 0; i < level; i ++) {
                System.out.println("\t");
            }
            if (f.isFile()) {
                System.out.println(f.getName());
            } else if (f.isDirectory()) {
                System.out.println("[" + f.getName() + "]");

                nestedFiles(f.listFiles(), level + 1);

            }
        }
    }

    public static String findDeepest (File folder) {
        int currentLvl = 0;
        String res = "";
        File[] folderEntries = folder.listFiles();

        for (File entry: folderEntries) {
            currentLvl = countMatches(entry.getPath(), "\\");
            if (entry.isDirectory()) {
                findDeepest(entry);
                if (deepestLvl < currentLvl) {
                    deepestLvl = currentLvl;
                    deepestItem = entry.getPath();
                }
                continue;
            } else  {
                if (deepestLvl < currentLvl) {
                    deepestLvl = currentLvl;
                    deepestItem = entry.getPath();
                }
            }
        }
        res = String.valueOf(deepestLvl) + " " + deepestItem;
        return res;

    }
    public static int countMatches (String path, String str) {
        int num = 0;
        String[] array = path.split("");
        for (int i = 0; i < path.length(); i ++) {
            if (str.contentEquals(array[i])) {
                num ++;
            }
        }
        return num;
    }

    public static void freeDiskSpace (File any) {
        double size = any.getFreeSpace() / (1024.0 * 1024 * 1024);
        System.out.printf("%.3f GB\n", size);
    }

    public static void countDisks (File[] drive) {
        int counter = 0;
        if (drive != null && drive.length > 0) {
            for (File aDriver : drive) {
                counter ++;
                System.out.println(aDriver);
            }
        }
        System.out.println("Number of drivers: " + counter);
    }

}
