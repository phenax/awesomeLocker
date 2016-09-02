import java.io.*;

/**
 * Generates an encrypted file fo
 *
 * @author Akshay Nair <phenax5@gmail.com>
 */
public class AwesomeLocker {

    AwesomeLocker() {

        // String str= LockerHelper.encryptCaesarCipher("Hello", 3);
        //
        // System.out.println(str);
        // System.out.println(LockerHelper.decryptCaesarCipher(str, 3));

    }


    public void encryptFile(String fileName, String outputFileName, String password) {

        int key= _getIntKeyFromString(password);

        encryptFileWithIntKey(fileName, outputFileName, key);
    }


    public void decryptFile(String fileName, String outputFileName, String password) {

        int key= _getIntKeyFromString(password);

        decryptFileWithIntKey(fileName, outputFileName, key);
    }



    public void encryptFileWithIntKey(String fileName, String outputFileName, int pass) {

        String inputString= _readFile(fileName);

        String encryptedString= LockerHelper.encryptCaesarCipher(inputString, pass);

        _writeFile(outputFileName, encryptedString);
    }


    public void decryptFileWithIntKey(String fileName, String outputFileName, int pass) {

        String inputString= _readFile(fileName);

        String decryptedString= LockerHelper.encryptCaesarCipher(inputString, -pass);

        _writeFile(outputFileName, decryptedString);
    }


    private int _getIntKeyFromString(String password) {
        int key= 0;

        for(int i= 0; i< password.length(); i++) {
            key+= password.charAt(0)*i;
        }

        return key%512;
    }



    private void _writeFile(String fileName, String writeStr) {

        FileWriter out = null;

        try {
            out = new FileWriter(fileName);

            for(int i= 0; i< writeStr.length(); i++) {
                out.write(writeStr.charAt(i));
            }
        } catch(IOException e) {
            System.out.println("IOERR");
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch(IOException e) {
                System.out.println("IOERR on close");
            }
        }
    }


    public String _readFile(String fileName) {
        StringBuilder str= new StringBuilder();

        FileReader in = null;

        try {
            in = new FileReader(fileName);
            // out = new FileWriter(outputFileName);

            int c;
            while ((c = in.read()) != -1) {
                // out.write(c);
                str.append((char) c);
            }
        } catch(IOException e) {
            System.out.println("IOERR");
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch(IOException e) {
                System.out.println("IOERR on close");
            }
        }

        return str.toString();
    }


    public static void main(String[] args) {
        // Parse args
    }
}
