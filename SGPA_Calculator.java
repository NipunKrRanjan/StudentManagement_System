import java.io.IOException;
import java.util.Scanner;
public class SGPA_Calculator
{
    static int marks()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter marks of PS:");
        int ps=sc.nextInt();
        if(ps==100.0)
            ps=10*4;
        else
            ps=((ps/10)+1)*4;
        System.out.println("Enter the marks of DS:");
        int ds=sc.nextInt();
        if(ds==100.0)
            ds=10*4;
        else
            ds=((ds/10)+1)*4;
        System.out.println("Enter the marks of AFL:");
        int afl=sc.nextInt();
        if(afl==100.0)
            afl=10*4;
        else
        afl=((afl/10)+1)*4;
        System.out.println("Enter the marks of DSD:");
        int dsd=sc.nextInt();
        if(dsd==100.0)
            dsd=30;
        else
            dsd=((dsd/10)+1)*3;
        System.out.println("Enter marks of STW:");
        int stw=sc.nextInt();
        if(stw==100.0)
        stw=20;
        else
        stw=((stw/10)+1)*2;
        System.out.println("Enter marks of IND");
        int ind=sc.nextInt();
        if(ind==100.0)
        ind=20;
        else
        ind=((ind/10)+1)*2;
        System.out.println("Enter marks of DS Lab:");
        int dsl=sc.nextInt();
        if(dsl==100.0)
         dsl=10;
        else
            dsl=((dsl/10)+1);
        System.out.println("Enter marks of DSD Lab:");
        int dsdl=sc.nextInt();
        if(dsdl==100.0)
        dsdl=10;
        else
        dsdl=((dsdl/10)+1);
        int sgpa=(ps+ds+dsd+ind+stw+dsdl+dsl+afl);
        sc.close();
        return sgpa;
    }
    static int gradecalculate()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter pointer obtained in PS:");
        int ps=sc.nextInt();
        System.out.println("Enter pointer obtained in DS:");
        int ds=sc.nextInt();
        System.out.println("Enter pointer obtained in AFL:");
        int afl=sc.nextInt();
        System.out.println("Enter pointer obtained in DSD:");
        int dsd=sc.nextInt();
        System.out.println("Enter pointer obtained in STW:");
        int stw=sc.nextInt();
        System.out.println("Enter pointer obtained in IND:");
        int ind=sc.nextInt();
        System.out.println("Enter pointer obtained in DSD Lab:");
        int dsdl=sc.nextInt();
        System.out.println("Enter pointer obtained in DS Lab:");
        int dsl=sc.nextInt();
        int sgpa=(ps*4)+(ds*4)+(afl*4)+(dsd*3)+(ind*2)+(stw*2)+(dsdl+dsl);
        return sgpa;
    }
    public static  void main(String[] args)throws IOException
    {
        int sgpa=0;
        Scanner sc=new Scanner(System.in);
        for (int i =0; i >= 0; i++)
        {
            System.out.println("Enter 1: for SGPA calculation using marks \n      2:To calculate SGPA using pointer obtained in subject \n      3:To exit");
            int ch=sc.nextInt();
            switch (ch) 
            {
                case 1 -> sgpa=marks();
                case 2 -> sgpa=gradecalculate();
                case 3 -> {
                }
                default -> {
                }
            }
            if(ch==3)
            {
                System.out.println("Exiting the program.");
                break;
            }
            System.out.println("Your required SGPA is:"+sgpa/21.0);
        }
    }  
}
