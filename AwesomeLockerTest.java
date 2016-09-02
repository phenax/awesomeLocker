/**
 *	This class does some awesome shit. Explain here.
 *
 * @author Akshay Nair <phenax5@gmail.com>
 */
public class AwesomeLockerTest {

    public static void main(String[] args) {

        AwesomeLocker locker= new AwesomeLocker();

        String password= "my_password";

        locker.encryptFile("testinput", "testoutput", password);

        locker.decryptFile("testoutput", "testDecrypt", password);

    }
}
