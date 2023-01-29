package practice.streamApi;

//Print characters which are repeated 2times from both the string S1=ababcd S2=aabbdd Output = a
public class RepeatedChars {
    public static void main(String[] args) {
        String s1="ababcd";
        String s2="aabbdd";

        System.out.println("Repeated chars in both strings");
        s1.chars().distinct().filter(c->(count(s1,(char)c)>=2) && (count(s2, (char)c)>=2))
                .forEach(c-> System.out.print(" "+(char)c));

    }

    public static long count(String s, char c){
        return s.chars().filter(ch->c==ch).count();
    }
}
