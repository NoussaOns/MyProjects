import java.util.Scanner;
import java.io.IOException;

public class BankAccount {
    private int accountNumber;
    private double balance;


    public BankAccount() {
        accountNumber = 0;
        balance = 0;
    }


    public BankAccount(int acctNumber, double initialBalance) {
        accountNumber = acctNumber;
        balance = initialBalance;
    }


    public void read(Scanner in) throws IOException {
        accountNumber = in.nextInt();
        balance = in.nextDouble();
    }


    public int getAccountNumber() {
        return accountNumber;
    }


    public double getBalance() {
        return balance;
    }


    public void deposit(double amountIn) {
        balance = balance + amountIn;
    }


    public void withdraw(double amountIn) {
        balance = balance - amountIn;
    }
}