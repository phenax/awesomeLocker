/**
 * Locker test class
 *
 * @author Akshay Nair <phenax5@gmail.com>
 */
public class AwesomeLockerTest {

    public static void main(String[] args) {

        if(args.length != 4) {
            System.out.println("\n# Invalid arguements error #\n");
            System.out.println("Basic Usage:");
            System.out.println("   java AwesomeLockerTest <e_or_d> <encryption_type> <inputfile> <password>\n");
            System.exit(1);
        }


        // The type of operation (e for encryption, d for decryption)
        String operation= args[0];

        // The type of encryption
        String typeInput= args[1];

        String inputFileName= args[2];
        String password= args[3];

        int type= -1;

        if(typeInput.equals("XOR")) {
            type= AwesomeLocker.XOR;
        } else if(typeInput.equals("CAESAR")) {
            type= AwesomeLocker.CAESAR;
        } else {
            System.out.println("Wrong type of encryption : "+ typeInput);
            System.exit(1);
        }

        // Create a locker for `type` cipher
        AwesomeLocker locker= new AwesomeLocker(type);

        if(operation.equals("d"))
            locker.encryptFile(inputFileName, inputFileName+".dec", password);
        else
            locker.decryptFile(inputFileName, inputFileName+".enc", password);

    }
}
