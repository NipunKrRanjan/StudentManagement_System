
//import Package.Student;
import java.util.*;
import java.time.ZoneId;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

abstract class StudentMain {
    String Sid = generateSid();
    String SName;
    Date dob;
    String FatherName;
    String Password = generatePassword();
    LocalDate yearOfJoiningDate = getDate();

    private static int count = 0;

    /*
     * StudentMain(String Sid, String SName, Date dob, String FatherName) {
     * this.Sid
     * this.SName = SName;
     * this.dob = dob;
     * this.FatherName = FatherName;
     * this.yearOfJoiningDate = getDate();
     * this.Password
     * }
     */

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

    StudentInfo( String SName, String fname,Date dob, String FatherName, String Address,
    String Degree, String Subject,Double ContactNo) {
    //super(Sid, SName, dob, FatherName);
    //this.Sid=Sid;
    this.SName=SName;
    this.dob=dob;
    this.FatherName=FatherName;
    this.Address = Address;
    this.Degree = Degree;
    this.Subject = Subject;
    this.ContactNo = ContactNo;
    this.CGPA = 0.0f;
    }
    

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of the student");

        System.out.println("Enter student name:");
        String name = sc.nextLine();

        System.out.println("Enter father's name:");
        String fname = sc.nextLine();

        System.out.println("Enter date of birth (dd-MM-yyyy):");
        String dobStr = sc.nextLine();

        System.out.println("Enter address:");
        String address = sc.nextLine();
        
        System.out.println("Enter degree:");
        String degree = sc.nextLine();
    
        System.out.println("Enter subject:");
        String subject = sc.nextLine();
    
        System.out.println("Enter contact number:");
        Double contact = sc.nextDouble();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = sdf.parse(dobStr);

                StudentInfo stud1 =new StudentInfo("NA", name, dob, fname, address, degree, subject, contact);
            System.out.println("Student created: " + stud1.SName + ", DOB: " + stud1.dob);

        } catch (Exception e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }

    public void viewStudent() {
        System.out.println("add Student");
    }

    public void searchStudent() {
        System.out.println("add Student");
    }

    public void updateStudent() {
        System.out.println("add Student");
    }

    public void deleteStudent() {
        System.out.println("add Student");
    }

    public void sortStudent() {
        System.out.println("add Student");
    }

    public void exportCSV() {
        System.out.println("add Student");
    }

    public void cgpaCalc() {
        System.out.println("add Student");
    }
}

class Student implements StudOperation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentInfo newStud = new StudentInfo("NA", "", new Date(), "", "", "", "", 0.0d);

        System.out.println("Enter the Operation you wanna perform on Student Files");
        System.out.println(
                "Menu Program \n add:add the student info \n view:view the complete info of the perticular student \n search:Searches for a student\n update :student details\n delete:delete the student info \n sort:Sort the students based on criteria \n exportCSV: Exports the data in the form of csv of note\n calcCGPA: calculates the cgpa of a perticular student");

        String operation = sc.next();
        switch (operation) {
            case "add":
                newStud.addStudent();
                break;
            case "view":
                // view
                break;
            case "search":
                // search
                break;
            case "update":
                // update
                break;
            case "delete":
                // delete
            case "export":
                // export
                break;
            case "calc CGPA":
                // update
                break;

        }
    }

}
