package com.application.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Base32;
import java.security.SecureRandom;

@UtilityClass
public class TotpUtils {

  private static final int SECRET_KEY_LENGTH = 20;

  public static String generateSecretKey() {
    SecureRandom random = new SecureRandom();
    byte[] secretKey = new byte[SECRET_KEY_LENGTH];
    random.nextBytes(secretKey);
    Base32 base32 = new Base32();
    return base32.encodeAsString(secretKey);
  }

  // Pending
  public static boolean validateSecretCode(String secretKey, String totpCode) {
    return true;
  }
}
