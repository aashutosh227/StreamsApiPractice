package practice.streamApi;

import java.util.Arrays;
import java.util.List;
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
        boolean[][] visited = new boolean[r][c];

        System.out.println("Enter elements: ");

        for(int i=0;i<r;i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sn.nextInt();
                visited[i][j]=false;
            }
        }

        int[] crow = {0,1,0,-1};
        int[] ccol = {1,0,-1,0};

        int[] rs = new int[r*c];

        int ri=0,ci=0;
        int k=0,l=0;
        int j=0;

        for(int i=0;i<r*c;i++){
//            System.out.println(ri+" "+ci);
            if(!visited[ri][ci]) {
                rs[j++] = arr[ri][ci];
                Arrays.stream(rs).forEach(n->System.out.print(n+" "));
                System.out.println();
                visited[ri][ci]=true;
            }
            //line 44 - 63 -> for dropping one level down in spiral.
            else{
                if(ri==ci){
                    ri++;
                    ci++;
                    if(ri<r && ci<c) {
                        rs[j++] = arr[ri][ci];
                        visited[ri][ci] = true;
                    }
                    k++;
                    l++;
                    if(l==4 && k==4){
                        k=0;
                        l=0;
                    }
                    ci+=ccol[l];
                    ri+=crow[k];
                }
            }

//            if(!(ri+crow[k]<r && ri+crow[k]>0)){
//                k++;
//                l++;
//            }

            //Line 70 -80 -> to handle edge turning
            if(l<=3 && k<=3) {
                if (!(ci + ccol[l] < c && ci + ccol[l] >= 0)
                || !(ri+crow[k]<r && ri+crow[k]>=0)) {
                    k++;
                    l++;
                }
            }
            else{
                l=0;
                k=0;
            }
            ci+=ccol[l];
            ri+=crow[k];
        }

        Arrays.stream(rs).forEach(n->System.out.print(n+" "));
    }
}
