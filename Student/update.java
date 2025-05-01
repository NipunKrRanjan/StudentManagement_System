
import java.util.Scanner;

public class update 
{
    static int i;
    static void indexassiging(int as)
    {
        i=as;
        //return a;
    }
    static void name(int i)
    {

    }
    static void password(int i)
    {

    }
    static void doj(int i)
    {

    }
    static void cno(int i)
    {

    }
    static void address(int i)
    {

    }
    static void subject(int i)
    {

    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int ch;
        while(true)
        {
            System.out.println("What would you like to update:(Enter)\n1 :For name change\n2 :For password change\n3 :For changing the date of joining\n4 :For chaging the contact number\n5 :For changing the address\n6 :For changing the subject studying\n7 :For exit");
            ch=sc.nextInt();
            switch (ch) 
            {
                case 1:
                    name(i);
                    break;
                case 2:
                    password(i);
                    break;
                case 3:
                    doj(i);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
