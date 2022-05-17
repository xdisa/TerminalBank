package services;

import exceptions.DontCorrentPinCodeExeption;
import models.Person;
import models.Transfer;

public interface TransferService {
    Transfer getForAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException;

    Transfer getForMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException;
}
