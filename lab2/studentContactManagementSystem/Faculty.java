package lab2.studentContactManagementSystem;

import java.util.Arrays;

public class Faculty {

    private String name;
    private Student[] students;

    public Faculty(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public int countStudentsFromCity(String cityName){
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i].getCity().equals(cityName)){
                count++;
            }
        }
        return count;
    }

    public Student getStudent(long index){
        for (int i = 0; i < students.length; i++) {
            if(students[i].getIndex() == index){
                return students[i];
            }
        }
        return null;
    }

    public double getAverageNumberOfContacts(){
        double count = 0.0;
        double sum = 0.0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getEmailContacts().length + students[i].getPhoneContacts().length;
            count++;
        }
        return sum / count;
    }

    public Student getStudentWithMostContacts(){
        Student studentWithTheMostContacts = null;
        int theMostContacts = 0 ;
        for (int i = 0; i < students.length; i++) {
            int numOfContacts = students[i].getEmailContacts().length + students[i].getPhoneContacts().length;
            if(numOfContacts > theMostContacts){
                theMostContacts = numOfContacts;
                studentWithTheMostContacts = students[i];
            } else if (numOfContacts == theMostContacts && students[i].getIndex() > studentWithTheMostContacts.getIndex()){
                theMostContacts = numOfContacts;
                studentWithTheMostContacts = students[i];
            }
        }
        return studentWithTheMostContacts;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{");
        string.append("\"fakultet\":\"").append(name).append("\", ");
        string.append("\"studenti\":[");
        for (int i = 0; i < students.length; i++) {
            string.append(students[i]);
            if (i < students.length - 1) {
                string.append(", ");
            }
        }
        string.append("]}");
        return string.toString();
    }
}
