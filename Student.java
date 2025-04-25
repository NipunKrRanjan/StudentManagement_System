import java.util.*;
import java.time.ZoneId;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import Student.*;

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

class StudentInfo extends StudentMain {

    String Address;
    String Degree;
    String Subject;
    Double ContactNo;
    Float CGPA;

    StudentInfo(String SName, String fname, Date dob, String FatherName, String Address,
            String Degree, String Subject, Double ContactNo) {
        // super(Sid, SName, dob, FatherName);
        // this.Sid=Sid;
        this.SName = SName;
        this.dob = dob;
        this.FatherName = FatherName;
        this.Address = Address;
        this.Degree = Degree;
        this.Subject = Subject;
        this.ContactNo = ContactNo;
        this.CGPA = 0.0f;
    }
    
    public static void viewStudent() {
        System.out.println("add Student");
    }

}

class Student {
    public static void addStudent() {
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

            StudentInfo stud1 = new StudentInfo("NA", name, dob, fname, address, degree, subject, contact);
            System.out.println("Student created: " + stud1.SName + ", DOB: " + stud1.dob);

        } catch (Exception e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        sc.close();
    }

    public static void searchStudent() {
        System.out.println("add Student");
    }

    public static void updateStudent() {
        System.out.println("add Student");
    }

    public static void deleteStudent() {
        System.out.println("add Student");
    }

    public static void sortStudent() {
        if(studentList.isEmpty()){
            System.out.println("The List is Empty");
        }else{
            for(int i=0;i<studentList.size();i++){
                StudentInfo s=studentList.get(i);
                System.out.println(s);
            }
        }
    }


    public static void exportCSV() {
        System.out.println("add Student");
    }

    public static void cgpaCalc() {
        System.out.println("add Student");
    }
    
    static ArrayList<StudentInfo> studentList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("---------------------------------------------------\nEnter the Operation you wanna perform on Student Files\n---------------------------------------------------");
            System.out.println(
                    "Menu Program \n add:add the student info \n view:view the complete info of the perticular student \n search:Searches for a student\n update :student details\n delete:delete the student info \n sort:Sort the students based on criteria \n exportCSV: Exports the data in the form of csv of note\n calcCGPA: calculates the cgpa of a perticular student \n showall:Show the details of all students\n---------------------------------------------------");

            String operation = sc.next();
            switch (operation) {
                case "add":
                    addStudent();
                    break;
                case "view":
                    // view
                    break;
                case "search":
                    // search
                    break;
                case "showAll":
                    // show All
                    if(studentList.isEmpty()){
                        System.out.println("No Data Found");
                    }else{
                        for(StudentInfo s: studentList){
                            s.viewStudent();                        
                        }
                    }
                    break;
                case "sort":
                    //sort
                    sortStudent();
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
                    // cgpa semester 3 calculator
                    
                    break;

            }

        }
    }

}
