import java.io.*;

/**
 * Locker for encrypting or decrypting files
 *
 * @author Akshay Nair <phenax5@gmail.com>
 */
public class AwesomeLocker {

    // Encryption type constants
    public static int XOR= 0;
    public static int CAESAR= 1;

    // Type of encryption(default= CAESAR)
    private int type= XOR;

    // Constructor
    AwesomeLocker(int type) {

        if(type != XOR && type != CAESAR) {
            System.out.println("Wrong encryption type specified");
            System.exit(1);
        }

        this.type= type;
    }


    /**
     * Encrypt file
     *
     * @param  The name of the input file
     * @param  The name of the file to dump the output into
     * @param  The encryption password
     */
    public void encryptFile(String fileName, String outputFileName, String password) {

        if(this.type == XOR) {
            this.encryptFileXOR(fileName, outputFileName, password);
        } else {
            this.encryptFileCaesar(fileName, outputFileName, password);
        }
    }


    /**
     * Decrypt file
     */
    public void decryptFile(String fileName, String outputFileName, String password) {

        if(this.type == XOR) {
            this.decryptFileXOR(fileName, outputFileName, password);
        } else {
            this.decryptFileCaesar(fileName, outputFileName, password);
        }
    }


    /**
     * Encrypt file with XOR cipher
     */
    public void encryptFileXOR(String fileName, String outputFileName, String password) {

        String inputString= _readFile(fileName);

        String encryptedString= LockerHelper.encryptXOR(inputString, password);

        _writeFile(outputFileName, encryptedString);
    }

    /**
     * Decrypt file with XOR cipher
     */
    public void decryptFileXOR(String fileName, String outputFileName, String password) {

        String inputString= _readFile(fileName);

        String decryptedString= LockerHelper.decryptXOR(inputString, password);

        _writeFile(outputFileName, decryptedString);
    }


    /**
     * Encrypt file with Caesar cipher
     */
    public void encryptFileCaesar(String fileName, String outputFileName, String password) {

        int key= _getIntKeyFromString(password);

        encryptFileCaesarWithIntKey(fileName, outputFileName, key);
    }


    /**
     * Decrypt file with Caesar cipher
     */
    public void decryptFileCaesar(String fileName, String outputFileName, String password) {

        int key= _getIntKeyFromString(password);

        decryptFileCaesarWithIntKey(fileName, outputFileName, key);
    }



    /**
     * Encrypt file with Caesar cipher with an integer as the key
     */
    public void encryptFileCaesarWithIntKey(String fileName, String outputFileName, int pass) {

        String inputString= _readFile(fileName);

        String encryptedString= LockerHelper.encryptCaesarCipher(inputString, pass);

        _writeFile(outputFileName, encryptedString);
    }



    /**
     * Decrypt file with Caesar cipher with an integer as the key
     */
    public void decryptFileCaesarWithIntKey(String fileName, String outputFileName, int pass) {

        String inputString= _readFile(fileName);

        String decryptedString= LockerHelper.encryptCaesarCipher(inputString, -pass);

        _writeFile(outputFileName, decryptedString);
    }


    /**
     * Convert a string to an integer key
     *
     * @param  password  Encryption password as string
     * @return           Integer key for encryption
     */
    private int _getIntKeyFromString(String password) {
        int key= 0;

        for(int i= 0; i< password.length(); i++) {
            key+= password.charAt(0)*i;
        }

        return key%512;
    }



    /**
     * Dump a string into a file
     *
     * @param  The name of the file to dump contents into
     * @param  The string to dump
     */
    private void _writeFile(String fileName, String writeStr) {

        FileWriter output = null;

        try {
            output = new FileWriter(fileName);

            for(int i= 0; i< writeStr.length(); i++) {
                output.write(writeStr.charAt(i));
            }
        } catch(IOException e) {
            System.out.println(" -- IOERR while writing --");
            e.printStackTrace();
        } finally {
            try {
                if (output != null)
                    output.close();
            } catch(IOException e) {
                System.out.println(" -- IOERR on closing stream --");
                e.printStackTrace();
            }
        }
    }



    /**
     * Read a file and return it as a string
     *
     * @param  fileName  The name of the file to read
     *
     * @return           The contents of the file as a string
     */
    public String _readFile(String fileName) {
        StringBuilder str= new StringBuilder();

        FileReader input = null;

        try {
            input = new FileReader(fileName);

            int c;
            while ((c = input.read()) != -1) {
                str.append((char) c);
            }
        } catch(IOException e) {
            System.out.println(" -- IOERR while reading --");
            e.printStackTrace();
        } finally {
            try {
                if (input != null)
                    input.close();
            } catch(IOException e) {
                System.out.println(" -- IOERR on closing stream --");
                e.printStackTrace();
            }
        }

        return str.toString();
    }
}
