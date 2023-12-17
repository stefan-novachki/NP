package lab2.studentContactManagementSystem;

public class PhoneContact extends Contact{

    private String phone;
    private Operator operator;

    public PhoneContact(String date, String phone) {
        super(date);
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public Operator getOperator() {
        char thirdDigit = phone.charAt(2);

        if(thirdDigit == '0' || thirdDigit == '1' || thirdDigit == '2') {
            operator = Operator.TMOBILE;
        } else if(thirdDigit == '5' || thirdDigit == '6') {
            operator = Operator.ONE;
        } else {
            operator = Operator.VIP;
        }
        return operator;
    }

    public String getType(){
        return "Phone";
    }

    @Override
    public String toString() {
        return "\"" + phone + "\"";
    }
}