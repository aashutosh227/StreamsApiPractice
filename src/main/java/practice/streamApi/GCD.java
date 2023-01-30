package practice.streamApi;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GCD {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int a = sn.nextInt();
        int b = sn.nextInt();

        int min = Math.min(a,b);

        int rs = IntStream.range(1,min+1)
                .filter(f->(a%f==0)&&(b%f==0))
                .boxed()
                .sorted(Collections.reverseOrder())
                .findFirst()
                .get();

        System.out.println("GCD: "+rs);
    }
}
