package application;

import model.entities.Account;
import model.exception.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Holder: ");
        String holder = sc.next();
        System.out.print("Initial Balance: ");
        Double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        Double withDraw = sc.nextDouble();

        Account account = new Account(number, holder, balance, withDraw);

        try {
            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();
            account.WithDraw(amount);
            System.out.print(account.toString());
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }

}