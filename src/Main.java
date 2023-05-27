import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static class Reader {

        public static void main(String[] args) {


            try ( Scanner amr = new Scanner(new File("basedir\\data\\dataset_1.txt"))){

                long a = amr.nextInt();
                long b = amr.nextInt();

                System.out.println(a + b);
                System.out.println(a * b);
                System.out.println(a + (b * b));


            }
            catch (FileNotFoundException e) {
                System.out.println("The file is not here");
            }
            catch (Exception e) {
                System.out.println("Unknown error");
            }

            try (Scanner amr = new Scanner(new File("basedir\\data\\dataset_2.txt"))) {
                File file = new File("basedir\\data\\dataset_2.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                int wordCount = 0;
                int paraCount = 0;

                while ((line = bufferedReader.readLine()) != null) {
                    if (line.equals("")) {
                        paraCount += 1;
                    } else {
                        String[] words = line.split("\\s+");
                        wordCount += words.length;
                    }
                }
                int n = wordCount;

                long [] a = new long[n];
                for (int i = 0; i < a.length; i ++ ) {
                    a[i] = amr.nextLong();
                }
                int counter = 0;
                for (long l : a) {
                    if (l % 2 == 0) {
                        counter++;
                    }
                }
                System.out.println("The number of even number is: " + counter);

            }
            catch (FileNotFoundException e) {
                System.out.println("The file is not here");
            }
            catch (Exception e) {
                System.out.println("Unknown error");
            }
            try (Scanner amr = new Scanner(new File("basedir\\data\\dataset_3.txt"))){

                File x = new File("basedir\\data\\dataset_3.txt");
                File y = new File("basedir\\data\\res_3.txt");

                copyToFile(x,y);

            }
            catch (FileNotFoundException e) {
                System.out.println("The file is not here");
            }
            catch (Exception e) {
                System.out.println("Unknown error");
            }
            try (Scanner amr = new Scanner(new File("basedir\\data\\dataset_4.txt"))){
                File file = new File("basedir\\data\\dataset_4.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                int wordCount = 0;
                int paraCount = 0;

                while ((line = bufferedReader.readLine()) != null) {
                    if (line.equals("")) {
                        paraCount += 1;
                    } else {
                        String[] words = line.split("\\s+");
                        wordCount += words.length;
                    }
                }
                int n = wordCount;

                long [] a = new long[n];
                for (int i = 0; i < a.length; i ++) {
                    a[i] = amr.nextLong();
                }
   
                System.out.println("Largest num " + largest(a));
                String intToStr = String.valueOf(largest(a));

                String fileName = "res_3.txt";
                appendFile(fileName,intToStr);


            }
            catch (FileNotFoundException e) {
                System.out.println("The file was not found");
            }
            catch (Exception e) {
                System.out.println("Unknown Error");
            }
            try (Scanner amr = new Scanner(new File("basedir\\data\\lobby"))) {
                File file = new File("/Users/macbook/Documents/Javacourse/LAB03/src/lobby");
                String line;
                String oldTxt = "";
                BufferedReader reader = null;
                FileWriter writer = null;

                reader = new BufferedReader(new FileReader(file));
                line = reader.readLine();
                while (line != null) {
                    oldTxt = oldTxt + line + System.lineSeparator();
                    line = reader.readLine();
                }

                String newTxt = oldTxt.toUpperCase();
                writer = new FileWriter(file);
                writer.write(newTxt);
                System.out.println("The new text : " + newTxt );

            }
            catch (FileNotFoundException e) {
                System.out.println("The file was not found");
            }
            catch (Exception e) {
                System.out.println("Unknown Error");
            }
        }
        public static void copyToFile(File a, File b) throws IOException {
            FileInputStream in = new FileInputStream(a);
            FileOutputStream out = new FileOutputStream(b);

            try {
                int n;

                while ((n = in.read()) != -1) {
                    out.write(n);
                }
            }
            finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            System.out.println("File Copied");
        }
        public static long largest (long[] arr) {
            long max = arr[0];
            for (long l : arr) {
                if (l > max) {
                    max = l;
                }
            }
            return max;
        }

        public static void appendFile(String filename, String str) {
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));

                out.write(str);
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred");
            }
        }
    }
}