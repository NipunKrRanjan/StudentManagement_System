import java.util.*;
public class Main_Server
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc=new Scanner(System.in);
        int ch;
        while(true)
        {
            System.out.println("Hello There, enter your role.\n1 : For server admin\n2 : For student login\n3 : To exit");
            ch=sc.nextInt();
            try
            {
            switch (ch) 
            {
                case 1:
                    Student.main(args);
                    break;
                case 2:
                    login.main(args);
                    break;
                case 3:
                    System.out.println("Thank you. Have a nice day ahead");
                    break;
                default:
                    throw new AssertionError();
            }
            }
            catch(AssertionError e)
            {
                System.err.println(e.getMessage());
            }
            if(ch==3)
                break;
        }
    }   
}

