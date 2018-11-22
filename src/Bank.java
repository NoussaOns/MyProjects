import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> bankAccounts;


    public Bank() {
        bankAccounts = new ArrayList<BankAccount>();
    }


    public void readFile(Scanner infile) throws IOException {
        int i = 0;
        while (infile.hasNext()) {
            bankAccounts.add(new BankAccount());
            bankAccounts.get(i).read(infile);
            i++;
        }
    }


    public void printAllAccounts() {
        int num;
        double bal;

        System.out.println("\nDetails of all accounts...");
        System.out.printf("%-10s%10s\n", "Account", "Balance($)");
        for (int i = 1; i < bankAccounts.size(); i++) {
            num = bankAccounts.get(i).getAccountNumber();
            bal = bankAccounts.get(i).getBalance();
            System.out.printf("%-10d%10.2f\n", num, bal);
        }
    }


    public void printHighestBalance() {
        double highBal = bankAccounts.get(0).getBalance();
        int accNum = bankAccounts.get(0).getAccountNumber();

        for (int i = 1; i < bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getBalance() > highBal) {
                highBal = bankAccounts.get(i).getBalance();
                accNum = bankAccounts.get(i).getAccountNumber();
            }
        }

        System.out.println("\nDetails of highest balance...");
        System.out.println("Account Number: " + accNum);
        System.out.printf("%-18s%9.2f\n", "Highest Balance: $", highBal);
    }
}