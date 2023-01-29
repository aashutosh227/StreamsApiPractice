package practice.streamApi;

import java.util.Arrays;
import java.util.Scanner;

//Print spiral version of an array {{1,2,3},{4,5,6},{7,8,9}} Output 1,2,3,6,9,8,7,4,5
public class SpiralArray {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("No of rows: ");
        int r = sn.nextInt();

        System.out.println("No of columns: ");
        int c = sn.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Enter elements: ");

        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                arr[i][j]=sn.nextInt();

        int[] arr1= Arrays.stream(arr)
                .flatMapToInt(e->Arrays.stream(e))
                .toArray();

        System.out.println("Spiral Array: ");
        for(int n: arr1)
            System.out.print(" "+n);
    }
}
