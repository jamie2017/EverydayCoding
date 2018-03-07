package JavaEssentials;

/**
 * Created by JMYE on 3/15/17.
 */

import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encription {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Read and save the input String */
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();

        /* Encode the String using MD5 */
        MessageDigest md = MessageDigest.getInstance("MD5"); //"SHA-256"
        md.update(str.getBytes());
        byte[] digest = md.digest();

        /* Print the encoded value in hexadecimal */
        for (byte b : digest) {
            System.out.format("%02x", b);
        }
    }
}