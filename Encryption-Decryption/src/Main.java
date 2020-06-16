import java.io.File;
import java.util.Scanner;

public class Main {



public static void main(String[] args) {
    String data = "";
    int key = 0;
    String mode = "enc";
    String input = "";
    String output = "";
    String algorithm = "shift";
    Encryptor e = new Encryptor();
    try {
        for (int i = 0; i < args.length; i++) {
            if(args[i].contentEquals("-mode")){
                mode = args[i+1];
            }
            
            if(args[i].contentEquals("-data")) {
                data = args[i+1];
            }
            
            if(args[i].contentEquals("-key")) {
                key = Integer.parseInt(args[i+1]);
            }
            
            if(args[i].contentEquals("-in")) {
                input = args[i+1];
            }
            
            if(args[i].contentEquals("-out")) {
                output = args[i+1];
            }
            
            if(args[i].contentEquals("-alg")) {
                algorithm = args[i+1];
            }
            

        }
        if(algorithm.contentEquals("shift")) {
        	e.setAlgorithm(new ShiftAlgorithm());
        }
        else {
        	e.setAlgorithm(new UnicodeAlgorithm());
        }
        if(input.length() > 0 && data.length() > 0) {
            input = "";
        }

        if(input.length() > 0) {
            File f = new File(input);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) {
                data += sc.nextLine();
            }
            if(output.length() > 0) {
                if(mode.contentEquals("enc")) {
                    e.encToFile(data,key,output);
                }
                else {
                    e.decToFile(data,key,output);
                }
            }
            else {
                if(mode.contentEquals("enc")) {
                    System.out.println(e.encrypt(data,key));
                }
                else {
                    System.out.println(e.decrypt(data,key));
                }
            }
        }
        else {
            if(output.length() > 0) {
                if(mode.contentEquals("enc")) {
                    e.encToFile(data,key,output);
                }
                else {
                    e.decToFile(data,key,output);
                }
            }
            else {
                if(mode.contentEquals("enc")) {
                    System.out.println(e.encrypt(data,key));
                }
                else {
                    System.out.println(e.decrypt(data,key));
                }
            }
        }


    }
    catch(Exception ex) {
        System.out.printf("Error: %s", ex.getMessage());
    }
}
}