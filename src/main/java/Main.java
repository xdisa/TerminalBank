import exceptions.DontCorrentPinCodeExeption;
import models.Person;
import services.PersonService;
import services.PersonServiceImpl;
import services.Terminal;
import services.TerminalImpl;
import services.TransferService;
import services.TransferServiceImpl;

public class Main {

    public static void main(String[] args) throws DontCorrentPinCodeExeption, InterruptedException {

        PersonService personService = new PersonServiceImpl();
        TransferService transferService = new TransferServiceImpl();
        Terminal terminal = new TerminalImpl(transferService);

        Person p1 = personService.getPerson();
        Person p2 = personService.getPerson();

        terminal.transferToMySelf(p1);
        terminal.transferToAnother(p1, p2);
    }
}
