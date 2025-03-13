
//import Package.Student;
import java.util.Date;
import java.util.*;

abstract class StudentMain {
    Double Sid;
    String SName;
    Date dob;
    String FatherName;
    String Password;

    StudentMain(Double Sid, String SName, Date dob, String FatherName) {
        this.Sid = Sid;
        this.SName = SName;
        this.dob = dob;
        this.FatherName = FatherName;
        this.Password = generatePassword();
    }

    private String generatePassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

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
    Date yearOfJoiningDate;

    StudentInfo(Double Sid, String SName, Date dob, String FatherName, String Address, String Degree, String Subject, Double ContactNo, Date yearOfJoiningDate) {
        super(Sid, SName, dob, FatherName);
        this.Address = Address;
        this.Degree = Degree;
        this.Subject = Subject;
        this.ContactNo = ContactNo;
        this.CGPA = 0.0f; 
        this.yearOfJoiningDate = yearOfJoiningDate;
    }
}

class Student{
    public static void main(String[] args) {
        
    }
}
