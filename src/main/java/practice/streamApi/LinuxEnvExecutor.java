package practice.streamApi;

import java.io.*;
import java.util.stream.Collectors;

public class LinuxEnvExecutor {

    public static void main(String[] args) {

        //Read the input file
        try {
            BufferedReader br;
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"Utf-16"));

            br = new BufferedReader(new FileReader(args[0]));
            String os = System.getProperty("os.name");
            System.out.println("OS: "+os);
            br.lines().forEach(l-> {
                try {
                    System.out.println(l);
                    Process p;
                    if(os.startsWith("Windows") || os.startsWith("windows"))
//                        p= Runtime.getRuntime().exec("cmd.exe /c set "+l);
                        p= Runtime.getRuntime().exec("powershell.exe get-process -name \"notepad*\"");
                    else
                        p= Runtime.getRuntime().exec("/bin/sh -c export "+l);
                    p.waitFor();
                    new BufferedReader(new InputStreamReader(p.getInputStream()))
                            .lines().forEach(l1->System.out.println(l1));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                    });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
