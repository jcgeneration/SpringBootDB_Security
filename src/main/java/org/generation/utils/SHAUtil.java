package org.generation.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtil {

        public static String createHash(String value) {
            String res=value;
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                //SHA-1 SHA-256 SHA-384 SHA-512
                md.update(value.getBytes());
                byte[] resultado = md.digest();
                res = (new String(resultado));
            } catch(NoSuchAlgorithmException e) {
                e.printStackTrace();
            }//catch
            return res;
        }// createHash

        public static  boolean verifyHash(String original, String hash) {
            boolean res = false;
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                //SHA-1 SHA-256 SHA-384 SHA-512
                md.update(original.getBytes());
                String resultado = new String(md.digest());
                res = resultado.equalsIgnoreCase(hash);
            } catch(NoSuchAlgorithmException e){
                e.printStackTrace();
            }//catch
            return res;
        }// verifyHash

    public static boolean verifyPasswd(String original, String newPasswd) {
        boolean res = false;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //SHA-1 SHA-256 SHA-384 SHA-512
            md.update(original.getBytes());
            String resultadoOriginal = new String(md.digest());
            md.update(newPasswd.getBytes());
            String resultadoNewPasswd = new String(md.digest());
            res = resultadoOriginal.equalsIgnoreCase(resultadoNewPasswd.toLowerCase());
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }//catch
        return res;
    }// verifyHash



}//class SHAUtil
