import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and initialize first array");
        int[] ar1 = initialize(new int[sc.nextInt()]);
        System.out.println("Enter length and initialize second array");
        int[] ar2 = initialize(new int[sc.nextInt()]);
        int[] res = new int[0];
        if (ar1.length < ar2.length)
            for (int i = 0; i < ar2.length; i++)
                if (search(ar2[i], ar1))
                    continue;
                else
                    res = addElement(res, ar2[i]);
        else
            for (int i = 0; i < ar1.length; i++)
                if (search(ar1[i], ar2))
                    continue;
                else
                    res = addElement(res, ar1[i]);
        printAr(res);
    }
    static int[] sort(int[] ar) {
        for (int i = 0; i < ar.length; i++)
            for (int j = 0; j < ar.length - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        return ar;
    }
    static int[] initialize(int[] ar) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ar.length; i++) {
            System.out.println("Enter a value");
            ar[i] = sc.nextInt();
        }
        return ar;
    }
    static void printAr(int[] ar) {
        for (int i = 0; i < ar.length; i++)
            System.out.println(ar[i]);
    }
    static int[] addElement(int[] ar, int a) {
        int[] br = new int[ar.length + 1];
        int i;
        for (i = 0; i < ar.length; i++)
            br[i] = ar[i];
        br[i] = a;
        return br;
    }
    static boolean search(int s, int[] ar) {
        ar = sort(ar);
        int l = 0, u = ar.length - 1, m = -1;
        while (l <= u) {
            m = (l + u) / 2;
            if (s > ar[m])
                l = m + 1;
            else if (s < ar[m])
                u = m - 1;
            else
                return true;
        }
        return false;
    }
}