package lab2.studentContactManagementSystem;

import java.util.Arrays;

public class Student {

    private Contact[] contacts;
    private  int n;
    private String firstName;
    private String lastName;
    private String city;
    private int age;
    private long index;

    public Student(String firstName, String lastName, String city, int age, long index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.index = index;
        this.contacts = new Contact[0];
        this.n = 0;
    }

    public void addEmailContact(String date, String email) {
        Contact newContact = new EmailContact(date, email);
        contacts = Arrays.copyOf(contacts, n + 1);
        contacts[n++] = newContact;
    }

    public void addPhoneContact(String date, String phone) {
        Contact newContact = new PhoneContact(date, phone);
        contacts = Arrays.copyOf(contacts, n + 1);
        contacts[n++] = newContact;
    }

    public Contact[] getEmailContacts() {
        int ct = 0;

        for(int i = 0; i < contacts.length; i++) {
            if(contacts[i].getType().equals("Email")) {
                ct++;
            }
        }

        Contact [] emailContacts = new Contact[ct];
        int idx = 0;
        for(int i = 0; i < contacts.length; i++) {
            if(contacts[i].getType().equals("Email")) {
                emailContacts[idx++] = contacts[i];
            }
        }
        return emailContacts;
    }

    public Contact[] getPhoneContacts() {
        int ct = 0;

        for(int i = 0; i < contacts.length; i++) {
            if(contacts[i].getType().equals("Phone")) {
                ct++;
            }
        }

        Contact [] phoneContacts = new Contact[ct];
        int idx = 0;
        for(int i = 0; i < contacts.length; i++) {
            if(contacts[i].getType().equals("Phone")) {
                phoneContacts[idx++] = contacts[i];
            }
        }
        return phoneContacts;
    }

    public String getCity(){
        return city;
    }

    public String getFullName(){
        return String.format(firstName + " " + lastName);
    }

    public long getIndex(){
        return index;
    }

    public Contact getLatestContact() {
        Contact contact = contacts[0];

        for (Contact c : contacts) {
            if (c.isNewerThan(contact)) {
                contact = c;
            }
        }

        return contact;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{");
        string.append("\"ime\":\"").append(firstName).append("\", ");
        string.append("\"prezime\":\"").append(lastName).append("\", ");
        string.append("\"vozrast\":").append(age).append(", ");
        string.append("\"grad\":\"").append(city).append("\", ");
        string.append("\"indeks\":").append(index).append(", ");

        string.append("\"telefonskiKontakti\":[");
        Contact[] phoneContacts = getPhoneContacts();
        for (int i = 0; i < phoneContacts.length; i++) {
            string.append(phoneContacts[i]);
            if (i < phoneContacts.length - 1) {
                string.append(", ");
            }
        }
        string.append("], ");

        string.append("\"emailKontakti\":[");
        Contact[] emailContacts = getEmailContacts();
        for (int i = 0; i < emailContacts.length; i++) {
            string.append(emailContacts[i]);
            if (i < emailContacts.length - 1) {
                string.append(", ");
            }
        }
        string.append("]}");

        return string.toString();
    }

}












