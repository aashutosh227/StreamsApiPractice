package practice.streamApi;

//Print unique same characters from both the string S1=ababcd S2=abcefgh Output = a,b
public class UniqueChars {

    public static void main(String[] args) {
        String s1 = "ababcd";
        String s2 = "abcefgh";

        System.out.println("Common unique chars: ");
        s1.chars().distinct().filter(c->s2.indexOf(c)>=0)
                .forEach(c->System.out.print(" "+(char)c));
    }

}
