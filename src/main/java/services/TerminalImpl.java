package services;

import exceptions.DontCorrentPinCodeExeption;
import models.Person;

public class TerminalImpl implements Terminal {
    private final TransferService transferService;

    public TerminalImpl(TransferService transferService) {
        this.transferService = transferService;
    }

    @Override
    public void transferToMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException {
        transferService.getForMySelf(sender);

    }

    @Override
    public void transferToAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException {
        transferService.getForAnother(sender, recipient);
    }
}
