public class Password {
    String encryptedPassword;
    private static final int SHIFT = 3;
    public Password(String passwordInput) {
        encryptedPassword = encrypt(passwordInput);
    }

    private String encrypt(String passwordInput) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < passwordInput.length(); i++) {
            char ch = passwordInput.charAt(i);

            if (Character.isLetter(ch)) {
                char shifted = (char) (ch + SHIFT);
                if ((Character.isLowerCase(ch) && shifted > 'z') || (Character.isUpperCase(ch) && shifted > 'Z')) {
                    shifted = (char) (ch - (26 - SHIFT));
                }
                ciphertext.append(shifted);
            } else {
                ciphertext.append(ch);
            }
        }
        return ciphertext.toString();
    }

    public boolean matches(String inputPassword) {
        if(encrypt(inputPassword).equals(encryptedPassword))
            return true;

        return false;
    }

    /*
    // Dekrypterar en sträng. Denna kod kanske kan raderas bara.
    public static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);

            if (Character.isLetter(ch)) {
                char shifted = (char) (ch - SHIFT);
                if ((Character.isLowerCase(ch) && shifted < 'a') || (Character.isUpperCase(ch) && shifted < 'A')) {
                    shifted = (char) (ch + (26 - SHIFT));
                }
                plaintext.append(shifted);
            } else {
                plaintext.append(ch);
            }
        }

        return plaintext.toString();
    }

     */

}
