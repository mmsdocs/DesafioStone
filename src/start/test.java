/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;


import java.util.Formatter;
import com.theromus.sha.Keccak;


public class test {

    public static void main(String[] args) {
        byte[] b = getByteArray("0");
        String s = getHexStringByByteArray(b);
        Keccak keccak = new Keccak(1600);

        System.out.println("sha-224 = " + keccak.getHash(s, 1152, 28));
        System.out.println("sha-256 = " + keccak.getHash(s, 1088, 32));
        System.out.println("sha-384 = " + keccak.getHash(s, 832, 48));
        System.out.println("sha-512 = " + keccak.getHash(s, 576, 64));
    }

    public static byte[] getByteArray(String s) {
        return (s != null) ? s.getBytes(): null;
    }
    
    /**
     * Convert the byte array to a hex-string.
     *
     * @param array  byte array
     * @return  hex string
     */
    public static String getHexStringByByteArray(byte[] array) {
        if (array == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder(array.length * 2);
        @SuppressWarnings("resource")
        Formatter formatter = new Formatter(stringBuilder);
        for (byte tempByte : array)
            formatter.format("%02x", tempByte);

        return stringBuilder.toString();
    }

}
