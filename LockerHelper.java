/**
 * Provides helper functions to perform locker operations
 */

public class LockerHelper {

    /**
     * Shifts a character `key` positions
     *
     * @param   The character to shift
     * @param   Number of positions to move
     *
     * @return  Shifted character
     */
    private static char _shiftChar(char c, int key) {
        return (char) (c + key);
    }


    /**
     * Shifts all characters of a string `key` positions
     *
     * @param   The string to shift
     * @param   Number of positions to shift
     *
     * @return  The shifted string
     */
    private static String _shiftString(String data, int key) {

        StringBuilder encryptedStr= new StringBuilder();

        for(int i= 0; i< data.length(); i++) {
            encryptedStr.append(_shiftChar(data.charAt(i), key));
        }

        return encryptedStr.toString();
    }


    /**
     * Encrypt input string using caesar cipher
     *
     * @param   Input string
     * @param   Pass key
     *
     * @return  Encrypted String
     */
    public static String encryptCaesarCipher(String data, int key) {

        return _shiftString(data, key);
    }


    /**
     * Decrypt input string using caesar cipher
     *
     * @param   Input String
     * @param   Pass key
     *
     * @return  Decrypted String
     */
    public static String decryptCaesarCipher(String data, int key) {

        return _shiftString(data, -key);
    }



    // public static String encryptXOR
}
