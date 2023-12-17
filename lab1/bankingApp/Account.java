package lab1.bankingApp;

import java.util.Objects;
import java.util.Random;

public class Account  implements AmountConverter{
    private String name;
    private long id;
    private String balance;
    private static Random RANDOM = new Random();

    public Account(String name, String balance) {
        this.name = name;
        this.balance = balance;
        id = RANDOM.nextLong();
    }

    public String getName() { return name; }

    public long getId() { return id; }

    public String getBalance() { return balance; }
    public void setBalance(String balance) { this.balance = balance; }

    @Override
    public String toString() {
        return String.format("Name: %s\nBalance: %s\n", name, balance);
    }


    public boolean hasEnoughMoney(double totalAmount) {
        return totalAmount <= AmountConverter.stringToDouble(balance);
    }
}

