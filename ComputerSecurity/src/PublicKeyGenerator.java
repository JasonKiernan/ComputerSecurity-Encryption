import java.math.BigInteger;

public class PublicKeyGenerator {

	public static void main(String[] args) {
		
		BigInteger alicePublicKey = getPublicKey(BigInteger.valueOf(2685735182053607L), BigInteger.valueOf(5L), BigInteger.valueOf(3628350683L));
		BigInteger bobPublicKey = getPublicKey(BigInteger.valueOf(2685735182053607L), BigInteger.valueOf(5L), BigInteger.valueOf(5915597903L));

		System.out.println("Alice's public key is: "+ getPublicKey(BigInteger.valueOf(2685735182053607L), BigInteger.valueOf(5L), BigInteger.valueOf(3628350683L)));
		System.out.println("Bob's public key is: "+ getPublicKey(BigInteger.valueOf(2685735182053607L), BigInteger.valueOf(5L), BigInteger.valueOf(5915597903L)));

		System.out.println();
		System.out.println("Shared Key computed by Alice is: "+ getSharedKey(BigInteger.valueOf(2685735182053607L), bobPublicKey, BigInteger.valueOf(3628350683L)));
		System.out.println("Shared Key computed by Bob is: "+ getSharedKey(BigInteger.valueOf(2685735182053607L), alicePublicKey, BigInteger.valueOf(5915597903L)));

		
//		BigInteger alicePublicKey2 = getPublicKey(BigInteger.valueOf(2685735182215187L), BigInteger.valueOf(2L), BigInteger.valueOf(3628281929L));
//		BigInteger bobPublicKey2 = getPublicKey(BigInteger.valueOf(2685735182215187L), BigInteger.valueOf(2L), BigInteger.valueOf(5915661551L));
//
//		System.out.println("Alice's2 public key is: "+ getPublicKey(BigInteger.valueOf(2685735182215187L), BigInteger.valueOf(2L), BigInteger.valueOf(3628281929L)));
//		System.out.println("Bob's2 public key is: "+ getPublicKey(BigInteger.valueOf(2685735182215187L), BigInteger.valueOf(2L), BigInteger.valueOf(5915661551L)));
//		System.out.println("Shared Key2 computed by Alice is: "+ getSharedKey(BigInteger.valueOf(2685735182215187L), bobPublicKey2, BigInteger.valueOf(3628281929L)));
//		System.out.println("Shared Key2 computed by Bob is: "+ getSharedKey(BigInteger.valueOf(2685735182215187L), alicePublicKey2, BigInteger.valueOf(5915661551L)));
//
//		
		
	}
	
	public static BigInteger getPublicKey(BigInteger prime, BigInteger generator, BigInteger privatekey ) {
		return generator.modPow(privatekey, prime);	
	}
	
	public static BigInteger getSharedKey(BigInteger prime, BigInteger publicKey, BigInteger privatekey ) {
		return publicKey.modPow(privatekey, prime);
	}

}
