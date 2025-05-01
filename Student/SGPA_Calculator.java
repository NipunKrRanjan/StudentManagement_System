
import java.io.IOException;
import java.util.Scanner;

public class SGPA_Calculator 
{
    static int marks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of Sub 1:");
        int ps = sc.nextInt();
        if (ps == 100.0) {
            ps = 10 * 4; 
        }else {
            ps = ((ps / 10) + 1) * 4;
        }
        System.out.println("Enter the marks of Sub 2:");
        int ds = sc.nextInt();
        if (ds == 100.0) {
            ds = 10 * 4; 
        }else {
            ds = ((ds / 10) + 1) * 4;
        }
        System.out.println("Enter the marks of Sub 3:");
        int afl = sc.nextInt();
        if (afl == 100.0) {
            afl = 10 * 4; 
        }else {
            afl = ((afl / 10) + 1) * 4;
        }
        System.out.println("Enter the marks of Sub 4:");
        int dsd = sc.nextInt();
        if (dsd == 100.0) {
            dsd = 30; 
        }else {
            dsd = ((dsd / 10) + 1) * 3;
        }
        System.out.println("Enter marks of Sub 5:");
        int stw = sc.nextInt();
        if (stw == 100.0) {
            stw = 20; 
        }else {
            stw = ((stw / 10) + 1) * 2;
        }
        System.out.println("Enter marks of Sub 6");
        int ind = sc.nextInt();
        if (ind == 100.0) {
            ind = 20; 
        }else {
            ind = ((ind / 10) + 1) * 2;
        }
        System.out.println("Enter marks of Sub 7:");
        int dsl = sc.nextInt();
        if (dsl == 100.0) {
            dsl = 10; 
        }else {
            dsl = ((dsl / 10) + 1);
        }
        System.out.println("Enter marks of Sub 8:");
        int dsdl = sc.nextInt();
        if (dsdl == 100.0) {
            dsdl = 10; 
        }else {
            dsdl = ((dsdl / 10) + 1);
        }
        int sgpa = (ps + ds + dsd + ind + stw + dsdl + dsl + afl);
        sc.close();
        return sgpa;
    }

    static int gradecalculate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter pointer obtained in Sub 1:");
        int ps = sc.nextInt();
        System.out.println("Enter pointer obtained in Sub 2:");
        int ds = sc.nextInt();
        System.out.println("Enter pointer obtained in Sub 3:");
        int afl = sc.nextInt();
        System.out.println("Enter pointer obtained in DSD:");
        int dsd = sc.nextInt();
        System.out.println("Enter pointer obtained in Sub 5:");
        int stw = sc.nextInt();
        System.out.println("Enter pointer obtained in Sub 6:");
        int ind = sc.nextInt();
        System.out.println("Enter pointer obtained in Sub 7:");
        int dsdl = sc.nextInt();
        System.out.println("Enter pointer obtained in Sub 8:");
        int dsl = sc.nextInt();
        int sgpa = (ps * 4) + (ds * 4) + (afl * 4) + (dsd * 3) + (ind * 2) + (stw * 2) + (dsdl + dsl);
        sc.close();
        return sgpa;
    }

    public static void main(String[] args) throws IOException {
        int sgpa = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i >= 0; i++) {
            System.out.println("Enter 1: for SGPA calculation using marks \n      2:To calculate SGPA using pointer obtained in subject \n      3:To exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 ->
                    sgpa = marks();
                case 2 ->
                    sgpa = gradecalculate();
                case 3 -> {
                }
                default -> {
                }
            }
            if (ch == 3) {
                System.out.println("Exiting the program.");
                break;
            }
            System.out.println("Enter spga for 1st sem:");
            double frst=sc.nextDouble();
            System.out.println("Enter spga for 2nd sem:");
            double scnd=sc.nextDouble();
            double res=sgpa/21.0;
            System.out.println("Your SGPA for 3rd sem:"+res);
            System.out.println("Your Final CGPA is:"+(frst+scnd+res)/3.0);
            //sc.close();
        }
    }
}
