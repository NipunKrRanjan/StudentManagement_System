import java.util.*;
public class view 
{
    boolean found=false;
    static void vw(int i)
    
    {
        System.out.println("Name:"+Student.studentList.get(i).SName);
        System.out.println("Father name:"+Student.studentList.get(i).FatherName);
        System.out.println("Contact Number:"+Student.studentList.get(i).ContactNo);
        System.out.println("Address:"+Student.studentList.get(i).Address);
        System.out.println("Degree Pursuing:"+Student.studentList.get(i).Degree);
        System.out.println("Date of Birth:"+Student.studentList.get(i).dob);
        System.out.println("Year of Joining:"+Student.studentList.get(i).yearOfJoiningDate);
    }
    static boolean check()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the Unique ID of the student to be searched:");
        String id=sc.next();
        boolean found=false;
        for(int i=0;i<Student.studentList.size();i++)
        {
            if((Student.studentList.get(i).Sid).equals(id))
            {
                found=true;
                System.out.println("Student Found!\nThe details of the student is as follows:\n");
                vw(i);
            }
        }
        return found;
    }
    public static void main(String[] args) 
    {
        check();
    }
}
