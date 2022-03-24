import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws DontCorrentPinCodeExeption, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Person p1 = Person.get(scanner);

        Person p2 = Person.get(scanner);

        TerminalImpl terminalImpl = new TerminalImpl( p1,p2);
         terminalImpl.transferToMySelf(p1);
         terminalImpl.transferToAnother(p1,p2);
    }
}
