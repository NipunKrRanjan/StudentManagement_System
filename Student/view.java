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
    public static void main(String[] args) 
    {

    }
}
