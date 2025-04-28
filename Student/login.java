import java.util.*;
public class login
{
    boolean r=false;
    boolean check()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your UID:");
        String uid=sc.next();
        for(int i=0;i<Student.studentList.size();i++)
        {
            if((Student.studentList.get(i).Sid).equals(uid))
            {
                int ps=1,at=0;
                while(ps<=3)
                {
                    System.out.println("Please enter your password");
                    String pass=sc.next();
                    if((Student.studentList.get(i).Password).equalsIgnoreCase(pass))
                    {
                        System.out.println("Welcome, "+Student.studentList.get(i).SName);
                        
                    }
                }
            }
        }
        return r;
    }
}
