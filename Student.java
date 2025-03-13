
//import Package.Student;
import java.util.Date;
import java.util.*;
import java.time.ZoneId;
import java.time.LocalDate;

abstract class StudentMain {
    String Sid;
    String SName;
    Date dob;
    String FatherName;
    String Password;
    LocalDate yearOfJoiningDate;

    private static int count = 0;

    StudentMain(String Sid, String SName, Date dob, String FatherName) {
        this.Sid = generateSid();
        this.SName = SName;
        this.dob = dob;
        this.FatherName = FatherName;
        this.yearOfJoiningDate = getDate();
        this.Password = generatePassword();
    }

    protected static void total() {
        count++;
    }

    public static int getTotal() {
        return count;
    }

    private String generatePassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private LocalDate getDate() {
        Date currDate = new Date();
        LocalDate localDate = currDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    private String generateSid() {
        String date = getDate().toString();
        String[] year = date.split("-");
        String id = (year[0] + (Math.floor(Math.random() * 9) + 1) + count).toString();
        return id;

    };

}

interface StudOperation {
    abstract void addStudent();

    abstract void viewStudents();

    abstract void searchStudent();

    abstract void updateStudent();

    abstract void deleteStudent();

    abstract void sortStudent();

    abstract void exportCSV();

    abstract void cgpaCalc();
}

class StudentInfo extends StudentMain {

    String Address;
    String Degree;
    String Subject;
    Double ContactNo;
    Float CGPA;

    StudentInfo(String Sid, String SName, Date dob, String FatherName, String Address, String Degree, String Subject,Double ContactNo) {
        super(Sid, SName, dob, FatherName);
        this.Address = Address;
        this.Degree = Degree;
        this.Subject = Subject;
        this.ContactNo = ContactNo;
        this.CGPA = 0.0f;

    }
}

class Student {
    public static void main(String[] args) {

    }
}
