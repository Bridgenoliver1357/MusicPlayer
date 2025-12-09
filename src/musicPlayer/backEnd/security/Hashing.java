package musicPlayer.backEnd.security;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Hashing {
	//hashes the given string using SHA-512 and returns the hash plus the generated salt in one byte array
	public static byte[] getHashWithoutSalt(String password) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.update(salt);
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			byte[] hashSalt = new byte[salt.length + hash.length];
			ByteBuffer buffer = ByteBuffer.wrap(hashSalt);
			buffer.put(hash);
			buffer.put(salt);
			hashSalt = buffer.array();
			return hashSalt;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//hashes the given string using the given salt byte array
	public static byte[] getHashWithSalt(String password, byte[] salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.update(salt);
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public static byte[] getSaltFromHashSalt(byte[] hashSalt) {
//		
//	}
	
	//generates an encryption key based on the password hash of the user and the key salt
	public static byte[] getEncryptionKey(byte[] hash, byte[] keySalt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.update(keySalt);
			byte[] encryptKey = digest.digest(hash);
			return encryptKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
