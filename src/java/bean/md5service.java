/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Tech
 */
public class md5service {
    public String newPsd;
    public String getMD5(String input) {
        try {
            byte[] buffer = input.getBytes();
            byte[] result = null;
            StringBuffer buf = null;
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //allocate room for the hash
            result = new byte[md5.getDigestLength()];
            //calculate hash    md5.reset();
            md5.update(buffer);
            result = md5.digest();
            System.out.println(result);
            //create hex string from the 16-byte hash
            buf = new StringBuffer(result.length * 2);
            for (int i = 0; i < result.length; i++) {
                int intVal = result[i] & 0xff;
                if (intVal < 0x10) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(intVal).toUpperCase());
            }
            newPsd = buf.toString();
            return (buf.toString());
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
