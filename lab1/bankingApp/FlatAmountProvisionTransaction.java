package lab1.bankingApp;

import java.util.Objects;

public class FlatAmountProvisionTransaction extends Transaction implements AmountConverter {

    private String flatProvision;

    public FlatAmountProvisionTransaction(long fromId, long toId, String amount, String flatProvision) {
        super(fromId, toId,"FlatAmount", amount);
        this.flatProvision = flatProvision;
    }

    public String getFlatProvision() {
        return flatProvision;
    }

    @Override
    public double getProvision() {
        return AmountConverter.stringToDouble(flatProvision);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;
        return Objects.equals(flatProvision, that.flatProvision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatProvision);
    }
}