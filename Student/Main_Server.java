import java.util.*;
public class Main_Server
{
    public static void main(String[] args) 
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
                try{
                    Student.main(args);
                    break;
                }catch(Exception e){
                    System.out.println("Error Occured");
                }
                case 2:
                try{
                    login.main(args);
                    break;
                }catch(Exception e){
                    System.out.println("Error Occured");
                }
                case 3:
                try{
                    System.out.println("Thank you. Have a nice day ahead");
                    break;
                }catch(Exception e){
                    System.out.println("Error Occured");
                }
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

