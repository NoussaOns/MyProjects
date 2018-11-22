import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BankTest {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner infile = null;
        String fileName;

        System.out.print("Enter the file name of accounts: ");
        fileName = input.next();

        try {
            infile = new Scanner(new File(fileName));
        } catch (FileNotFoundException e1) {
            System.out.println(fileName + " is not a valid file name.");
            System.out.print("\nRe-Enter the file name of accounts: ");
            fileName = input.next();

            try {
                infile = new Scanner(new File(fileName));
            } catch (FileNotFoundException e2) {
                System.out.println(fileName + " is not a valid file name again.");
                System.exit(1);
            }
        }

        Bank bank = new Bank();
        bank.readFile(infile);
        bank.printAllAccounts();
        bank.printHighestBalance();
    }
}