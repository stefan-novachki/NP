package lab1.bankingApp;

import java.util.Objects;

public class FlatPercentProvisionTransaction extends Transaction implements AmountConverter {

    private int centsPerDollar;

    public FlatPercentProvisionTransaction (long fromId, long toId, String amount, int centsPerDollar) {
        super(fromId, toId, "FlatPercent", amount);
        this.centsPerDollar = centsPerDollar;
    }

    public int getPercent() {
        return centsPerDollar;
    }

    @Override
    public double getProvision() {
        return (int) AmountConverter.stringToDouble(getAmount()) * centsPerDollar / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return centsPerDollar == that.centsPerDollar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(centsPerDollar);
    }
}
