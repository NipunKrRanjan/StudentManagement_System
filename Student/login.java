
import java.util.*;

public class login 
{

    boolean r = false;

    boolean check() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your UID:");
        String uid = sc.next();
        int ch;
        for (int i = 0; i < Student.studentList.size(); i++) 
        {
            if ((Student.studentList.get(i).Sid).equals(uid))
            {
                int ps = 0;
                while (ps < 3) 
                {
                    System.out.println("Please enter your password");
                    String pass = sc.next();
                    ps++;
                    if ((Student.studentList.get(i).Password).equals(pass)) 
                    {
                        System.out.println("Welcome, " + (Student.studentList.get(i).SName).toUpperCase());
                        while (true) 
                        {
                            System.out.println("What's in your mind today?\nENTER\n1 : To view your details\n2 : To Update your details\n3 : Logout");
                            ch = sc.nextInt();
                            switch (ch) 
                            {
                                case 1:
                                    view.vw(i);
                                    break;
                                case 2:
                                    //Update student info
                                    break;
                                case 3:
                                    System.out.println("Thank you.Have a nice day");
                                    break;
                                default:
                                    System.out.println("Invlaid choice entered");
                            }
                            if(ch==3)
                             break;
                        }
                        return true;
                    }

                }
                if(ps==3)
                {
                    System.out.println("Too many incorrect password attempts. Please try again later");
                    break;
                }
            }
        }
        return r;
    }
    public static void main(String[] args) 
    {
        login l=new login();
        l.check();
    }
}
