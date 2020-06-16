
public class Encryptor {
	private EncryptionAlgorithm algorithm;

	public void setAlgorithm(EncryptionAlgorithm algorithm) {
		this.algorithm = algorithm;
	}
	
	public String encrypt(String data, int key) {
		return this.algorithm.encrypt(data, key);
	}
	
	public String decrypt(String data, int key) {
		return this.algorithm.decrypt(data, key);
	}
	
	public void decToFile(String data, int key, String output) {
		this.algorithm.decToFile(data, key, output);
	}
	
	public void encToFile(String data, int key, String output) {
		this.algorithm.encToFile(data, key, output);
	}
	
}