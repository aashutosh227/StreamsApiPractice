package practice.streamApi;

import java.util.Arrays;
import java.util.Scanner;

//Print spiral version of an array {{1,2,3},{4,5,6},{7,8,9}} Output 1,2,3,6,9,8,7,4,5
public class SpiralArrayRecursive {
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

        traverse(arr, rs, 0, visited, arr.length);
        Arrays.stream(rs).forEach(n->System.out.print(n+" "));
    }

    public static void traverse(int[][] arr, int rs[], int rsIdx, boolean[][] visited, int lvl){

        if(rsIdx==rs.length){
            return;
        }
        int[] crow = {0,1,0,-1};
        int[] ccol = {1,0,-1,0};
        int ri = 0;
        int ci = 0;

        int total = 4*(lvl-1);
        int r = arr.length-lvl;
        int c = arr.length-lvl;

        for(int i=0;i<total;i++){
            if(!visited[r][c]){
                rs[rsIdx++]=arr[r][c];
                visited[r][c]=true;
            }
            if(r+crow[ri]<lvl && r+crow[ri]>=(arr.length-lvl)
            && c+ccol[ci]<lvl && c+ccol[ci]>=(arr.length-lvl)) {
                r += crow[ri];
                c += ccol[ci];
            }
            else{
                if(ri==3 || ci==3){
                    ri=0;
                    ci=0;
                }
                else{
                    ri++;
                    ci++;
                }
                r += crow[ri];
                c += ccol[ci];
            }
        }

        traverse(arr, rs, rsIdx,visited, lvl-1 );
    }
}
