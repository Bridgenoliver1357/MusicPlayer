package musicPlayer.backEnd.security;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	//encrypts the given string using the given key and using AES encryption 
	public static byte[] encrypt(String password, byte[] keyBytes) {
		SecretKeySpec key = new SecretKeySpec(Arrays.copyOfRange(keyBytes, 0, 32), "AES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encrypted = new byte[cipher.getOutputSize(password.length())];
			encrypted = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
			return encrypted;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//decrypts the given byte array using the given key and using AES encryption
	public static String decrypt(byte[] encrypted, byte[] keyBytes) {
		SecretKeySpec key = new SecretKeySpec(Arrays.copyOfRange(keyBytes, 0, 32), "AES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] password = new byte[cipher.getOutputSize(encrypted.length)];
			password = cipher.doFinal(encrypted);
			return new String(password, StandardCharsets.UTF_8);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	//generates a secure byte array to be used as a key salt
	public static byte[] generateKeySalt() {
		Random random = new SecureRandom();
		byte[] keySalt = new byte[32];
		random.nextBytes(keySalt);
		return keySalt;
	}
}
