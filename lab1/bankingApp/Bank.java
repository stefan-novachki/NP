package lab1.bankingApp;

import java.util.Arrays;
import java.util.Objects;

public class Bank implements AmountConverter {
    private final String name;
    private final Account[] accounts;
    private double totalTransferSum;
    private double totalProvisionCharged;

    public Bank(String name, Account[] accounts){
        this.name = name;
        this.accounts = new Account[accounts.length];
        System.arraycopy(accounts, 0, this.accounts, 0, accounts.length);
    }

    private Account findAccount(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public boolean makeTransaction(Transaction t) {
        Account fromAcc = findAccount(t.getFromId());
        Account toAcc = findAccount(t.getToId());

        if (fromAcc == null || toAcc == null) {
            return false;
        }

        double balanceFrom = AmountConverter.stringToDouble(fromAcc.getBalance());
        double transactionAmount = AmountConverter.stringToDouble(t.getAmount());

        if (balanceFrom < transactionAmount) {
            return false;
        }

        double balanceTo = AmountConverter.stringToDouble(toAcc.getBalance());
        double provisionAmount = t.getProvision();

        totalTransferSum += transactionAmount;
        totalProvisionCharged += provisionAmount;

        if (fromAcc.getId() == toAcc.getId()) {
            fromAcc.setBalance(String.format("%.2f$", balanceFrom - provisionAmount));
        } else {
            double newBalanceFrom = balanceFrom - provisionAmount - transactionAmount;
            double newBalanceTo = balanceTo + transactionAmount;

            fromAcc.setBalance(String.format("%.2f$", newBalanceFrom));
            toAcc.setBalance(String.format("%.2f$", newBalanceTo));
        }

        return true;
    }

    public String totalTransfers() {
        return AmountConverter.doubleToString(totalTransferSum);
    }

    public String totalProvision() {
        return AmountConverter.doubleToString(totalProvisionCharged);
    }

    public Account[] getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Double.compare(totalTransferSum, bank.totalTransferSum) == 0 && Double.compare(totalProvisionCharged, bank.totalProvisionCharged) == 0 && Objects.equals(name, bank.name) && Arrays.equals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, totalTransferSum, totalProvisionCharged);
        result = 31 * result + Arrays.hashCode(accounts);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s \n\n", name));
        for (Account acc : accounts) {
            sb.append(acc.toString());
        }

        return sb.toString();
    }
}
