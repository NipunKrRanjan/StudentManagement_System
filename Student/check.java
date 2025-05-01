import java.util.Scanner;

public class check 
{
    static int a;
    static boolean check(String id)
    {
        Scanner sc=new Scanner(System.in);
       
        boolean found=false;
        for(int i=0;i<Student.studentList.size();i++)
        {
            if((Student.studentList.get(i).Sid).equals(id))
            {
                found=true;
                check c=new check();
                c.a=i;
                break;
            }
        }
        return found;
    }
}
