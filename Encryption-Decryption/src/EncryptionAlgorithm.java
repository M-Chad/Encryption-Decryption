
public interface EncryptionAlgorithm {
    public String encrypt(String data, int key);
    public String decrypt(String data, int key);
    public void encToFile(String data, int key, String output);
    public void decToFile(String data, int key, String output);
}
