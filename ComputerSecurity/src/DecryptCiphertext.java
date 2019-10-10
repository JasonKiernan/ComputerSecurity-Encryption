import java.math.*;


public class DecryptCiphertext {

	public static void main(String[] args) {
		
		//shared key
		BigInteger k = BigInteger.valueOf(1615075531926912L);
		//prime
		BigInteger p = BigInteger.valueOf(2685735182053607L);
		//ciphertext
		BigInteger cipher = BigInteger.valueOf(121467036523784L);
		
		//calculate the inverse of k mod p
		BigInteger kinverse = k.modInverse(p);
		//multiply the ciphertext by the inverse of k mod p and mod p once again
		BigInteger message = cipher.multiply(kinverse).mod(p);
		
		//This reveals the plaintext
		System.out.println("Message is "+message);
		//Uni of London API to convert numbers to hex and hex to plaintext
		System.out.println("http://foley.gold.ac.uk/cw19/api/cw2/toText?number=512852849765 converts the number to hex value d2hpdGU=");
		System.out.println("http://foley.gold.ac.uk/cw19/api/cw2/decode?base64=d2hpdGU= converts the hext value to plain text word 'white'");
		System.out.println("value of plaintext is white");

	}

	
}
