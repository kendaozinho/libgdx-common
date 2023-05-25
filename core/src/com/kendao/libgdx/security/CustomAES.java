package com.kendao.libgdx.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class CustomAES {
  private final SecretKeySpec key;

  public CustomAES(String secretKey) {
    try {
      byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
      this.key = new SecretKeySpec(Arrays.copyOf(sha.digest(key), 32), "AES");
      System.out.println("AES loaded successfully");
    } catch (Throwable t) {
      System.err.println("Unable to load AES: " + t);
      throw new RuntimeException(t);
    }
  }

  public String encrypt(String message) throws Throwable {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, this.key);
      return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes(StandardCharsets.UTF_8)));
    } catch (Throwable t) {
      System.err.println("Unable to encrypt message " + message + " using AES: " + t);
      throw t;
    }
  }

  public String decrypt(String message) throws Throwable {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, this.key);
      return new String(cipher.doFinal(Base64.getDecoder().decode(message)), StandardCharsets.UTF_8);
    } catch (Throwable t) {
      System.err.println("Unable to decrypt message " + message + " using AES: " + t);
      throw t;
    }
  }
}