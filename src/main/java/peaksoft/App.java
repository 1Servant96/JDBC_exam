package peaksoft;

import peaksoft.dao.DAO;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Scanner scannerS = new Scanner(System.in);
    static Scanner scannerN = new Scanner(System.in);
    static DAO dao = new DAO();

    public static void main(String[] args) {
        while (true) {
            queries();
            String button = scannerS.nextLine();
            switch (button) {
                case "1" -> dao.create();
                case "2" -> dao.read(scannerN.nextLong());
                case "3" -> {
                    System.out.println("Enter the id of the person which want you to update");
                    dao.update(scannerN.nextLong(), scannerS.nextLine(), scannerN.nextByte());
                }
                case "4" -> {
                    System.out.println("Enter the id of person");
                    dao.deleteStudentById(scannerN.nextLong());
                }
                case "5" -> {
                    System.out.println("Enter the name and age of student");
                    dao.insert(scannerS.nextLine(), scannerN.nextByte());
                }
            }
        }
    }

    public static void queries() {
        System.out.println("Press 1 to create the table\n" +
                "Press 2 to read the person by id\n" +
                "Press 3 to update the table\n" +
                "Press 4 to delete the table\n" +
                "Press 5 to insert into the table students\n"
        );

    }
}
