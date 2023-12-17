package lab1.bankingApp;

public interface AmountConverter {
    static double stringToDouble(String str) {
        return Double.parseDouble(str.substring(0, str.length() - 1));
    }

    static String doubleToString(double amount) {
        return String.format("%.2f$", amount);
    }
}
