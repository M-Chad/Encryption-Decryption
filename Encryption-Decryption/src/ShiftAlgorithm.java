import java.io.File;
import java.io.PrintWriter;

public class ShiftAlgorithm implements EncryptionAlgorithm {
	public void reverse(String [] arr, int start, int end) {
		while(start < end) {
			String temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	public void rotate(String[] arr, int key ) {
		reverse(arr,0,arr.length-1);
		reverse(arr,0,key-1);
		reverse(arr,key, arr.length-1);
	}
	

	@Override
	public String encrypt(String data, int key) {
		key = key % 26;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String[] letters = alphabet.split("");
		rotate(letters,key);
		String rotate = "";
		for (int i = 0; i < letters.length; i++) {
			rotate +=letters[i];
		}
		String ans ="";
		for (int i = 0; i < data.length(); i++) { 
				String a = Character.toString(data.charAt(i));
				int val = rotate.indexOf(a);
				if(a.matches("[a-z]")) {
					ans += alphabet.charAt(val);
				}
				else if(a.matches("[A-Z]")) {
					val = rotate.indexOf(a.toLowerCase());
					String temp = "" + alphabet.charAt(val);
					ans += temp.toUpperCase();
				}
				else {
					ans += data.charAt(i);
				}
		}
		return ans;
	}

	@Override
	public String decrypt(String data, int key) {
		key = 26-key;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String[] letters = alphabet.split("");
		rotate(letters,key);
		String rotate = "";
		for (int i = 0; i < letters.length; i++) {
			rotate +=letters[i];
		}
		String ans ="";
		for (int i = 0; i < data.length(); i++) { 
				String a = Character.toString(data.charAt(i));
				int val = rotate.indexOf(a);
				if(a.matches("[a-z]")) {
					ans += alphabet.charAt(val);
				}
				else if(a.matches("[A-Z]")) {
					val = rotate.indexOf(a.toLowerCase());
					String temp = "" + alphabet.charAt(val);
					ans += temp.toUpperCase();
				}
				else {
					ans += data.charAt(i);
				}
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
