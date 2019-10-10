import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewPublicandPrivateKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SRN first converted to HEX and then converted to a number value that we use for encryption
		BigInteger SRN = new BigInteger("907578962923576570169");
		
		// Generate a random private key that is between 2 and p-2
		BigInteger alicePrivateKey = getRandomPrivateKey();
		BigInteger bobPrivateKey = getRandomPrivateKey();
		System.out.println("Alice's randomly generated private key is: "+alicePrivateKey);
		System.out.println("Bob's randomly generated private key is: "+bobPrivateKey);

		
		BigInteger alicePublicKey = getPublicKey(BigInteger.valueOf(15279714382582973L), BigInteger.valueOf(2L), alicePrivateKey);
		BigInteger bobPublicKey = getPublicKey(BigInteger.valueOf(15279714382582973L), BigInteger.valueOf(2L), bobPrivateKey);

		System.out.println("Alice's public key is: "+ alicePublicKey);
		System.out.println("Bob's public key is: "+ bobPublicKey);

		System.out.println();
		System.out.println("Shared Key computed by Alice is: "+ getSharedKey(BigInteger.valueOf(15279714382582973L), bobPublicKey, alicePrivateKey));
		System.out.println("Shared Key computed by Bob is: "+ getSharedKey(BigInteger.valueOf(15279714382582973L), alicePublicKey, bobPrivateKey));
	
		
		//create a list for encrypted values r and c
		List<BigInteger> listofencryptedvalues = encrypt(BigInteger.valueOf(15279714382582973L), BigInteger.valueOf(2L), alicePublicKey, bobPrivateKey, SRN );
		for(BigInteger x : listofencryptedvalues) {
			System.out.println("Encrypted values for r (first) and c (second) are: "+x);
		}
		
	}
	
	public static BigInteger getPublicKey(BigInteger prime, BigInteger generator, BigInteger privatekey ) {
		return generator.modPow(privatekey, prime);	
	}
	
	public static BigInteger getSharedKey(BigInteger prime, BigInteger publicKey, BigInteger privatekey ) {
		return publicKey.modPow(privatekey, prime);
	}
	
	public static BigInteger getRandomPrivateKey() {
		Random rand = new Random();
		BigInteger result = new BigInteger(25, rand);
		return result;
		}

	//method to create a list for encrypted values r and c
	public static List<BigInteger> encrypt(BigInteger p, BigInteger g, BigInteger alicepublickey, BigInteger bobprivatekey, BigInteger SRN) {
		List<BigInteger> list = new ArrayList();
		BigInteger r = g.modPow(bobprivatekey, p);
		BigInteger x = alicepublickey.modPow(bobprivatekey, p);
		BigInteger c = SRN.multiply(x);
		
		list.add(r);
		list.add(c);
		return list;
		
		
	}
}
