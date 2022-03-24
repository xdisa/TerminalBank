public class TerminalImpl implements Terminal{
    private Person sender;
    private Person recipient;

    @Override
    public void transferToMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException {
        TerminalImpl t = new TerminalImpl(sender);
        Transfer.getForMySelf(sender);

    }

    @Override
    public void transferToAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException {

        TerminalImpl t = new TerminalImpl(sender,recipient);
        Transfer.getForAnother(sender, recipient);

    }

    public TerminalImpl( Person sender) {

        this.sender = sender;
    }

    public TerminalImpl(Person sender, Person recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }




}
