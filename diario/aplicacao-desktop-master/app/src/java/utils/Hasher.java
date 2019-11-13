package utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class Hasher {

	public static String hash(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return hash(str, getSalt(), 1000);
	}

	public static String hash(String str, byte[] salt, int iteracoes) throws NoSuchAlgorithmException, InvalidKeySpecException {
		char [] strChar = str.toCharArray();

		PBEKeySpec spec = new PBEKeySpec(strChar, salt, iteracoes, 64 * 8);
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = secretKeyFactory.generateSecret(spec).getEncoded();

		return iteracoes + ":" + toHex(salt) + ":" + toHex(hash);
	}

	public static boolean validar(String str, String hash) throws NoSuchAlgorithmException, InvalidKeySpecException{
		String[] parts = hash.split(":");
		int iteracoes = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);

		return hash(str, salt, iteracoes).equals(hash);
	}

	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		secureRandom.nextBytes(salt);
		return salt;
	}


	private static String toHex(byte[] bytes){
		BigInteger bi = new BigInteger(1, bytes);
		String hex = bi.toString(16);
		int pad = bytes.length * 2 - hex.length();
		if(pad > 0){
			return String.format("%0" + pad + "d", 0) + hex;
		}

		return hex;
	}

	private static byte[] fromHex(String str){
		byte[] bytes = new byte[str.length() / 2];
		for(int i = 0; i < bytes.length; i++){
			bytes[i] = (byte) Integer.parseInt(str.substring(2*i, 2*i + 2), 16);
		}
		return bytes;
	}


}
