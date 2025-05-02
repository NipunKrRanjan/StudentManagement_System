
import java.util.Scanner;

public class update {

    static int i;
    static void indexassiging(int as)
    {
        i = as;
    }

    static void name(int i) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new name:");
        String na=sc.next();
        Student.studentList.get(i).SName=na;
        System.out.println("Name updated successfully");
    }

    static void password(int i) 
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        System.out.println("Enter your current password");
        String pass=sc.next();
        if((Student.studentList.get(i).Password).equals(pass))
        {
            break;
        }
        else
            System.out.println("Please enter the correct current password");
        }
        System.out.println("Enter your new password:");
        String npass=sc.next();
        while (true)
        { 
            System.out.println("Re-enter your new password:");
            String renpass=sc.next();
            if(renpass.equals(npass))
            {
                Student.studentList.get(i).Password=npass;
                System.out.println("Password changed successfully");
                break;
            }
            else
            {
                System.out.println("Pssword does not matches");
            }
        }
    }

    static void cno(int i)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new phone number:");
        double cn=sc.nextDouble();
        Student.studentList.get(i).ContactNo=cn;
        System.out.println("Contact number modified successfully.");
    }

    static void address(int i) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your new address");
        String add=sc.next();
        Student.studentList.get(i).Address=add;
        System.out.println("Address updated successfully");
    }

    static void subject(int i) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the updated subject");
        String sub=sc.next();
        Student.studentList.get(i).Subject=sub;
        System.out.println("Subject updated successfully");
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int ch;
        while (true) 
        {
            System.out.println("What would you like to update:(Enter)\n1 :For name change\n2 :For password change\n3 :For chaging the contact number\n4 :For changing the address\n5 :For changing the subject studying\n6 :For exit");
            ch = sc.nextInt();
            try 
            {
                switch (ch)
                {
                    case 1:
                        name(i);
                        break;
                    case 2:
                        password(i);
                        break;
                    case 3:
                        cno(i);
                        break;
                    case 4:
                        address(i);
                        break;
                    case 5:
                        subject(i);
                        break;
                    case 6:
                        System.out.println("Thank you!");
                        break;
                    default:
                        throw new AssertionError("INVLAID CHOICE");
                }   
            }
            catch(AssertionError e)
            {
                    System.err.println(e.getMessage());
            }
            if(ch==6)
            {
                break;
            }
        }    
    }
 }
