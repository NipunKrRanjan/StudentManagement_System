import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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

    StudentInfo(String SName, Date dob, String FatherName, String Address,
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

}

class Student {
    public static ArrayList<StudentInfo> studentList = new ArrayList<>();

    public static void addStudent() {
        try {
            Scanner read = new Scanner(new File("DemoData.txt"));

            while (read.hasNextLine()) {

                String studentLine = read.nextLine().trim();
                if (studentLine.isEmpty())
                    continue;

                String[] pairs = studentLine.split(",");

                String Sid = "", Sname = "", FatherName = "", Address = "", Degree = "", Subject = "", password = "";
                float cgpa = 0.0f;
                double ContactNo = 0.0;
                Date dob = null;

                for (int i = 0; i < pairs.length; i++) {
                    String[] keyValue = pairs[i].split(":", 2);
                    if (keyValue.length < 2)
                        continue;
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    switch (key) {
                        case "Sid":
                            Sid = value;
                            break;
                        case "SName":
                            Sname = value;
                            break;
                        case "FatherName":
                            FatherName = value;
                            break;
                        case "Address":
                            Address = value;
                            break;
                        case "Degree":
                            Degree = value;
                            break;
                        case "Subject":
                            Subject = value;
                            break;
                        case "Password":
                            password = value;
                            break;
                        case "CGPA":
                            cgpa = Float.parseFloat(value);
                            break;
                        case "ContactNo":
                            ContactNo = Double.parseDouble(value);
                            break;
                        case "dob":
                            try {
                                dob = new SimpleDateFormat("dd-mm-yyyy").parse(value);
                            } catch (Exception e) {
                                System.out.println("Error getting the data");
                            }
                            break;
                    }
                }
                StudentInfo student = new StudentInfo(Sname, dob, FatherName, Address, Degree, Subject, null);
                studentList.add(student);
                // read.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("The File cant be Found Please check again");
        }

    }

    public static void updateStudent() {
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

            StudentInfo stud1 = new StudentInfo(name, dob, fname, address, degree, subject, contact);
            studentList.add(stud1);
            System.out.println("Student created: " + stud1.SName + ", DOB: " + stud1.dob);

        } catch (Exception e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        sc.close();
    }

    public static void searchStudent() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Unique ID of the student to be searched:");
        String id=sc.next();
        boolean re=check.che(id);
        if(re==false)
        {
            System.out.println("Student not found:\nPlease add new student:");
            addStudent();
        }
        else
        {
            System.out.println("The details of student to be viewed is as follows");
            view.vw(check.a);
        }
    }

    public static void deleteStudent(String Sid) {
        if (studentList.isEmpty()) {
            System.out.println("The List is Empty");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).Sid.equals(Sid)) {
                    studentList.remove(i);
                }

            }
        }

    }

    public static void sortStudent() {
        if (studentList.isEmpty()) {
            System.out.println("The List is Empty");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                StudentInfo s = studentList.get(i);
                System.out.println(s);
            }
        }
    }

    public static void exportCSV() throws IOException {
        try {
            FileWriter expFile = new FileWriter("export.csv");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println(studentList.get(i));
            }
            expFile.write("SID,Sname,FatherName,Address,Degree,Subject,password,cgpa,ContactNo,dob\n");
            for (StudentInfo student : studentList) {
                String line = student.Sid + "," + student.SName + "," + student.FatherName + "," + student.Address + ","
                        + student.Degree + "," + student.Subject + "," + student.Password + "," + student.CGPA + ","
                        + student.ContactNo + "," +
                        new SimpleDateFormat("dd-MM-yyyy").format(student.dob);
                expFile.write(line);
            }
            expFile.close();
            System.out.println("Successfully Exported");

        } catch (IOException e) {
            System.out.println("Can not write into the file properly");
        }

    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("---------------------------------------------------\nEnter the Operation you wanna perform on Student Files\n---------------------------------------------------");
            System.out.println(
                    "\nAdd : add the student info \nView : View the complete info of the perticular student \nSearch : Searches for a student\nUpdate : student details\nDelete : Delete the student info \nSort : Sort the students based on criteria \nExportCSV : Exports the data in the form of csv of note\nCalcCGPA : calculates the cgpa of a perticular student \nShowall : Show the details of all students\nExit:To Terminate the program\n---------------------------------------------------");

            String operation = sc.next();
            switch (operation.toLowerCase()) {
                case "add":
                    try{
                    addStudent();
                    System.out.println("data added");
                    }catch(Exception e){
                        System.out.println("Some Error had occured in the function ");
                    }
                    break;
                case "view":
                    try{
                    // view
                    view.main(args);
                    break;
                    }catch(Exception e){
                        System.out.println("Some Error had occured in the function ");
                    }
                case "search":
                    try{
                    // search
                    searchStudent();
                    break;
                    }catch(Exception e){
                        System.out.println("Some Error had occured in the function ");
                    }
                case "showAll":
                    try{
                    // show All
                    if(studentList.isEmpty()){
                        System.out.println("No Data Found");
                    }else{
                        for(int i =0;i<studentList.size();i++){
                            view.vw(i);                        
                        }
                    }
                        }catch(Exception e){
                            System.out.println("Some Error had occured in the function ");
                        }
                    break;
                case "sort":
                    try{
                    //sort
                    sortStudent();
                    break;
                    }catch(Exception e){
                        System.out.println("Some Error had occured in the function ");
                    }
                case "update":
                    try{
                    // update
                    update.main(args);
                    break;
                    }catch(Exception e){
                        System.out.println("Some Error had occured in the function ");
                    }
                case "delete":
                    try{
                    // delete
                    System.out.println("Enter the Id to delete");
                    String id= sc.next();
                    deleteStudent(id);
                    }catch(Exception e){
                        System.out.println("Some Error had occured in the function ");
                     }
                case "export":
                    try{
                        exportCSV();
                        break;
                    }catch(Exception e){
                    System.out.println("ERROR!!");
                    }
                    
                case "calc CGPA":
                    try{
                    // cgpa semester 3 calculator
                    SGPA.main(args);
                    break;
                    }catch(Exception e){
                        System.out.println("Some Error had occured in the function ");
                    }
                case "exit":
                    try {
                        exit=true;
                        break;
                    } catch (Exception e) 
                    {
                    }

            }
            // sc.close();

        }
    }

}
