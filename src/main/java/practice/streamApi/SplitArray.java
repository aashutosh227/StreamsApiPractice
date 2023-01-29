package practice.streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Split the array into custom size and print {1,2,3,4,5,6,7} size 3 Output {1,2,3}{4,5,6}{7}
public class SplitArray {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Scanner sn = new Scanner(System.in);

        System.out.println("Press 0 to exit. Enter values: ");
        int in;
        while(true){
            in = sn.nextInt();
            if(in==0)
                break;
            list.add(in);
        }

        list.forEach(e->System.out.println(e));

        System.out.println("Enter split size: ");
        int s = sn.nextInt();

        int c = (int)Math.ceil(list.size()/(double)s);

        System.out.println(c);
        List<List<Integer>> intList= IntStream.range(0,s)
                .mapToObj(e-> IntStream.range(0,c)
                        .map(i->{
                            if(c*e+i<list.size())
                                return list.get(c*e+i);
                            return 0;
                        })
                        .filter(n->n!=0)
                        .boxed())
                .map(e->e.collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println("Final Split Data");
        intList.forEach(e->{
            e.forEach(f->System.out.print(f+" "));
            System.out.println();
        });
    }
}
