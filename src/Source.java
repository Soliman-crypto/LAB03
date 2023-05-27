import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        Scanner radka = new Scanner (System.in);
        File dirP = new File("basedir\\Picture");

        File dirH = new File("basedir\\Texts\\History");

        File dirF = new File("basedir\\Texts\\Horror\\First");



        if (!dirP.exists()) {
            dirP.mkdir();
        }
        System.out.println("Picture: " + dirP.exists()); //true

        if (!dirH.exists()) {
            dirH.mkdirs();
        }
        System.out.println("Texts: " + dirH.exists());

        if (!dirF.exists()) {
            dirF.mkdirs();
        }
        System.out.println("Texts: " + dirF.exists());



        for (int i = 1; i < 7; i ++) {
            String filename = "basedir\\Picture\\" + i + ".txt";
            dirP = new File(filename);

            if (!dirP.exists()) {
                try {
                    dirP.createNewFile();
                } catch (IOException e) {
                    System.out.println("File " + filename + "can't be created");
                }
            }
        }
        File file = new File ("/Users/macbook/Documents/Javacourse/LAB03/LAB03.iml");
        File rename = new File ("/Users/macbook/Documents/Javacourse/LAB03/src/5000.txt");

        boolean flag = file.renameTo(rename);

        if (flag == true) {
            System.out.println("File Renamed  :)");
        } else {
            System.out.println("Rename Failed :(");
        }
        //------------------DELETING FILE---------------------
        String user;
        System.out.println("Which file do you wish to delete ?");
        user = radka.nextLine();
        File file1 = new File ("/Users/macbook/Documents/Javacourse/LAB03/src/6.txt");
        File file2 = new File ("C/Users/macbook/Documents/Javacourse/LAB03/src" + user);

        if (file1.delete()) {
            System.out.println("File DELETED :)");
        } else {
            System.out.println("FAILED to delete :(");
        }

        if (file2.delete()) {
            System.out.println("Your file was DELETED :)");
        } else {
            System.out.println("FAILED to delete :(");
        }

        File remove = new File ("/Users/macbook/Documents/Javacourse/LAB03/src/Horror");
        File remove1 = new File("/Users/macbook/Documents/Javacourse/LAB03/src/Picture");
        deleteDirectory(remove1);
        deleteDirectory(remove);

        if (remove1.delete() && remove.delete()) {
            System.out.println("Directory deleted :)");
        } else {
            System.out.println("Failed to Delete :(");
        }

    }

    public static void deleteDirectory(File file) {
        for (File subfile: file.listFiles()) {
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }
            subfile.delete();
        }
    }
}
