package services;

import exceptions.BlockAccException;
import exceptions.DontCorrentPinCodeExeption;
import java.util.Date;
import java.util.Scanner;
import javax.security.auth.login.AccountLockedException;
import models.Person;
import models.Transfer;

public class TransferServiceImpl implements TransferService{
    private static final long INPUT_BLOCKING_TIME_MILLIS = 5000L;

    public static int counter = 0;

    @Override
    public Transfer getForAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        PinValidator blocking = new PinValidator(INPUT_BLOCKING_TIME_MILLIS);

        System.out.println("ENTER PIN CODE");
        int tryCounter = 0;
        while (true) {
            try {
                int pin = scanner.nextInt();
                if (blocking.checkBlocking()) {
                    try {
                        TerminalServer.showBlockingTimeLeft(blocking);
                    } catch (AccountLockedException accountLockedEx) {
                        System.out.println(accountLockedEx.getMessage());
                    }
                } else {
                    TerminalServer.checkPin(pin, sender);
                    break;
                }
            } catch (DontCorrentPinCodeExeption ex) {
                System.out.println(ex.getMessage());
                try {
                    TerminalServer.checkPinInputTryCount(++tryCounter);
                } catch (BlockAccException blockAcException) {
                    System.out.println(blockAcException.getMessage());
                    blocking.start();
                    tryCounter = 0;
                }
            }
        }

        int amount;
        while (true) {
            System.out.println("enter amount :");
            amount = scanner.nextInt();

            if (amount % 100 != 0) {
                System.out.println("Не кратно 100");
            }

            if (amount % 100 == 0) {
                System.out.println("Кратно 100");
                break;
            }
        }
        System.out.println(amount);
        System.out.println(sender.getAccs().get(1));

        if (sender.getAccs().get(1) >= amount) {
            Double buff = sender.getAccs().get(1) - amount;
            sender.getAccs().put(1, buff);
            Double buff1 = recipient.getAccs().get(1) + amount;
            recipient.getAccs().put(1, buff1);

        } else {
            System.out.println("no money!");
        }
        System.out.println("transaction number :" + counter);
        counter++;

        Date transferDate = new Date();
        System.out.println("date transaction :" + transferDate);

        return new Transfer(counter, amount, transferDate, sender, recipient);
    }

    @Override
    public Transfer getForMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        PinValidator blocking = new PinValidator(INPUT_BLOCKING_TIME_MILLIS);

        System.out.println("ENTER PIN CODE");
        int tryCounter = 0;
        while (true) {
            try {
                int pin = scanner.nextInt();
                if (blocking.checkBlocking()) {
                    try {
                        TerminalServer.showBlockingTimeLeft(blocking);
                    } catch (AccountLockedException accountLockedEx) {
                        System.out.println(accountLockedEx.getMessage());
                    }
                } else {
                    TerminalServer.checkPin(pin, sender);
                    break;
                }
            } catch (DontCorrentPinCodeExeption ex) {
                System.out.println(ex.getMessage());
                try {
                    TerminalServer.checkPinInputTryCount(++tryCounter);
                } catch (BlockAccException blockAcException) {
                    System.out.println(blockAcException.getMessage());
                    blocking.start();
                    tryCounter = 0;
                }
            }


            System.out.println("test");
        }

        int amount;
        while (true) {
            System.out.println("enter amount :");
            amount = scanner.nextInt();

            if (amount % 100 != 0) {
                System.out.println("Не кратно 100");
            }

            if (amount % 100 == 0) {
                System.out.println("Кратно 100");
                break;
            }
        }

        if (sender.getAccs().get(1) >= amount) {
            Double buff = sender.getAccs().get(1) - amount;


            sender.getAccs().put(1, buff);
            System.out.println("Choice accs number(1-3)");
            int choice = scanner.nextInt();

            Double buff1 = sender.getAccs().get(choice) + amount;
            sender.getAccs().put(choice, buff + amount);

        } else {
            System.out.println("no money!");
        }
        System.out.println("transaction number :" + counter++);

        Date transferDate = new Date();

        System.out.println("date transaction :" + transferDate);

        return new Transfer(counter, amount, transferDate, sender);
    }
}
