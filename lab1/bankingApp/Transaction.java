package lab1.bankingApp;

public abstract class Transaction {
    private final long fromId;
    private final long toId;
    private final String description;
    private final String amount;

    public Transaction(long fromId, long toId, String description, String amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.description = description;
        this.amount = amount;
    }

    public abstract double getProvision();

    public long getFromId() { return fromId; }

    public long getToId() { return toId; }

    public String getDescription() { return description; }

    public String getAmount() { return amount; }
}