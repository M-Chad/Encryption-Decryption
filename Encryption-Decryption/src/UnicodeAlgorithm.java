import java.io.File;
import java.io.PrintWriter;

public class UnicodeAlgorithm implements EncryptionAlgorithm {

	@Override
	public String encrypt(String data, int key) {
		String ans = "";
        char[] chars = data.toCharArray();
        int[] pos = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            pos[i] = Integer.valueOf(chars[i]) + key;
        }
        for (int i = 0; i < pos.length; i++) {
            ans += ((char)pos[i]);
        }
        return ans;
    }

	@Override
	public String decrypt(String data, int key) {
		String ans = "";
        char[] chars = data.toCharArray();
        int[] pos = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            pos[i] = Integer.valueOf(chars[i]) - key;
        }
        for (int i = 0; i < pos.length; i++) {
            ans += ((char)pos[i]);
        }
        return ans;
    }

	@Override
	public void encToFile(String data, int key, String output) {
        try {
            File file = new File(output);
            if(!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(encrypt(data,key));
            pw.close();
        }
        catch(Exception e) {
            System.out.printf("Error: %s",e.getMessage());
        }
    }

	@Override
    public void decToFile(String data, int key, String output) {
        try {
            File file = new File(output);
            if(!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(decrypt(data,key));
            pw.close();
        }
        catch(Exception e) {
            System.out.printf("Error: %s",e.getMessage());
        }
    }

}
