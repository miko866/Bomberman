package server;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class JSONEntDecryption {

        private static SecretKeySpec secretKey;
        private static byte[] key;

        public static void setKey(String myKey)
        {

        }

        public static String encrypt(String strToEncrypt, String secret)
        {
            return null;
        }

        public static String decrypt(String strToDecrypt, String secret)
        {
            return null;
        }
    }
