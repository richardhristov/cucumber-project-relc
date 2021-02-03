package classes;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * 
 */
public class Person {

    /**
     * Default constructor
     */
    public Person() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String passwordHash;

    /**
     * 
     */
    private String name;

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 
     * @return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
     * @return
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    private static String hashCreate(String password) {
    	// Get a random salt using a PRNG
    	SecureRandom random = new SecureRandom();
    	byte[] saltBytes = new byte[16];
    	random.nextBytes(saltBytes);
    	// Init the message digest with sha-256
    	MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// Update the message digest with the salt, then hash the password
		md.update(saltBytes);
		byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
		// Encode the hash and salt bytes to base64, then return them concatenated
		byte[] hashEncoded = Base64.getEncoder().encode(hashBytes);
		byte[] saltEncoded = Base64.getEncoder().encode(saltBytes);
		try {
			return new String(hashEncoded, "UTF-8") + ":" + new String(saltEncoded, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    private static boolean hashVerify(String passwordHash, String password) {
    	// Decode the hash and salt into bytes
    	String[] hashAndSalt = passwordHash.split(":");
    	byte[] decodedHash = Base64.getDecoder().decode(hashAndSalt[0].getBytes(StandardCharsets.UTF_8));
    	byte[] decodedSalt = Base64.getDecoder().decode(hashAndSalt[1].getBytes(StandardCharsets.UTF_8));
    	// Init the message digest with sha-256
    	MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// Update the message digest with the salt, then hash the password to verify
		md.update(decodedSalt);
		byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
		// Do a byte by byte compare to avoid timing attacks
		boolean out = true;
		for(int i = 0; i < hashBytes.length; i++) {
			if (decodedHash[i] != hashBytes[i]) {
				out = false;
			}
		}
		return out;
    }


    /**
     * @param password 
     * @return
     */
    public void setPassword(String password) {
    	passwordHash = hashCreate(password);
    }

    /**
     * @param password 
     * @return
     */
    public boolean verifyPassword(String password) {
        return hashVerify(passwordHash, password);
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

}