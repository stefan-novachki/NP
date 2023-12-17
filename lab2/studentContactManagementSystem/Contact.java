package lab2.studentContactManagementSystem;

public abstract class Contact {

    private String date;

    public Contact(String date){
        this.date = date;
    }

    private int[] getDateParts() {
        String[] datePartsString = date.split("-");
        int[] datePartsInt = new int[3];
        for (int i = 0; i < 3; i++) {
            datePartsInt[i] = Integer.parseInt(datePartsString[i]);
        }
        return datePartsInt;
    }

    public boolean isNewerThan(Contact c) {
        int[] dateParts = getDateParts();
        int[] contactDateParts = c.getDateParts();

        for (int i = 0; i < 3; i++) {
            if (dateParts[i] > contactDateParts[i]) {
                return true;
            } else if (dateParts[i] < contactDateParts[i]) {
                return false;
            }
        }

        return true;
    }


    public abstract String getType();
}

