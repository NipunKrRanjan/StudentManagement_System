
import java.util.*;

public class login 
{
    static int f=0;
    void  check() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your UID:");
        String uid = sc.next();
        int ch;
        boolean found = check.che(uid);
        int ps = 0;
        if (found == true) 
        {
            while (ps < 3) 
            {
                f=1;
                System.out.println("Please enter your password");
                String pass = sc.next();
                ps++;
                if ((Student.studentList.get(check.a).Password).equals(pass)) 
                {
                    System.out.println("Welcome, " + (Student.studentList.get(check.a).SName).toUpperCase());
                    while (true) 
                    {
                        System.out.println("What's in your mind today?\nENTER\n1 : To view your details\n2 : To Update your details\n3 : Logout");
                        ch = sc.nextInt();
                        switch (ch) 
                        {
                            case 1:
                                view.vw(check.a);
                                break;
                            case 2:
                                update.indexassiging(check.a);
                                //update.main(args);
                                break;
                            case 3:
                                System.out.println("Thank you.Have a nice day");
                                break;
                            default:
                                System.out.println("Invlaid choice entered");
                        }
                        if (ch == 3) 
                        {
                            break;
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("Student not found");
        }
        if (ps == 3) {
            System.out.println("Too many incorrect password attempts. Please try again later");
        }
    }

    public static void main(String[] args) 
    {
        login l = new login();
        l.check();
    }
}
