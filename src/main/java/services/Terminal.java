package services;

import exceptions.DontCorrentPinCodeExeption;
import models.Person;

public interface Terminal {

    void transferToMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException;

    void transferToAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException;
}