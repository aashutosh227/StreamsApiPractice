package practice.streamApi;

import java.io.*;

public class FileComparer {

    public static void main(String[] args) {

        String cmd = "powershell.exe get-process -name \"notepad*\"";
        try {
            Process process = Runtime.getRuntime().exec(cmd);
//            process.getOutputStream().close();

            BufferedReader br1 = new BufferedReader(new InputStreamReader(process.getInputStream()));

            System.out.println("Process execution done!");
            String l;
            while ((l=br1.readLine())!=null){
                System.out.println(l);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try {
//            BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
//            BufferedReader br2 = new BufferedReader(new FileReader(args[0]));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }



    }
}
