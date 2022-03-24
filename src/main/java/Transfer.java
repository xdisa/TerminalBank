import javax.security.auth.login.AccountLockedException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Transfer {

    private int numberOfTransfer;
    private int amount;
    private String date;
    private Person sender;
    private Person recipient;
    public static int counter;
    public static int pinCounter = 0;
    private static final long INPUT_BLOCKING_TIME_MILLIS = 5000L;

    public static Transfer getForAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException {
        Transfer obj = new Transfer(0,amount," ",sender,recipient);
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
                    TerminalServer.checkPin(pin);
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


        while(true) {
            System.out.println("enter amount :");
            obj.amount = scanner.nextInt();

            if (obj.amount % 100 != 0) {
                System.out.println("Не кратно 100");
            }

            if (obj.amount % 100 == 0) {
                System.out.println("Кратно 100");
                break;
            }
        }
        System.out.println(obj.amount);
        System.out.println(obj.sender.getAccs().get(1));
        System.out.println(obj.getSender().getAccs().get(1));

        if(obj.sender.getAccs().get(1)>= obj.amount){
            Double buff = obj.sender.getAccs().get(1) - obj.amount;
            obj.sender.getAccs().put(1,buff);
            Double buff1 = obj.recipient.getAccs().get(1) + obj.amount;
            obj.recipient.getAccs().put(1,buff1);

        } else{
            System.out.println("no money!");
        }
        obj.numberOfTransfer = Transfer.counter;
        System.out.println("transaction number :" + obj.numberOfTransfer);
        Transfer.counter++;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat =null;
        dateFormat = new SimpleDateFormat();

        obj.date = dateFormat.format(currentDate);

        System.out.println("date transaction :" + obj.date);

        return obj;
    }


    public static Transfer getForMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException{
        Transfer obj = new Transfer(0,amount," ",sender);
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
                    TerminalServer.checkPin(pin);
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


        while(true) {
            System.out.println("enter amount :");
            obj.amount = scanner.nextInt();

            if (obj.amount % 100 != 0) {
                System.out.println("Не кратно 100");
            }

            if (obj.amount % 100 == 0) {
                System.out.println("Кратно 100");
                break;
            }
        }


        if(obj.getSender().getAccs().get(1)>= obj.amount){
            Double buff = obj.getSender().getAccs().get(1) - obj.amount;


            obj.getSender().getAccs().put(1,buff);
            System.out.println("Choice accs number(1-3)");
            int choice = scanner.nextInt();

            Double buff1 = obj.getSender().getAccs().get(choice) + obj.amount;
            obj.getSender().getAccs().put(choice,buff+obj.amount);

        } else{
            System.out.println("no money!");
        }
        obj.numberOfTransfer = Transfer.counter;
        System.out.println("transaction number :" + obj.numberOfTransfer);
        Transfer.counter++;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat =null;
        dateFormat = new SimpleDateFormat();

        obj.date = dateFormat.format(currentDate);

        System.out.println("date transaction :" + obj.date);


        return obj;

    }
    public Transfer(int numberOfTransfer, int amount, String date, Person sender, Person recipient) {
        this.numberOfTransfer = numberOfTransfer;
        this.amount = amount;
        this.date = date;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Transfer(int numberOfTransfer, int amount, String date, Person sender) {
        this.numberOfTransfer = numberOfTransfer;
        this.amount = amount;
        this.date = date;
        this.sender = sender;
    }

    public int getNumberOfTransfer() {
        return numberOfTransfer;
    }

    public void setNumberOfTransfer(int numberOfTransfer) {
        this.numberOfTransfer = numberOfTransfer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Transfer.counter = counter;
    }

    public static int getPinCounter() {
        return pinCounter;
    }

    public static void setPinCounter(int pinCounter) {
        Transfer.pinCounter = pinCounter;
    }

    @Override
    public String toString() {
        return "Transfer{" +
            "numberOfTransfer=" + numberOfTransfer +
            ", amount=" + amount +
            ", date='" + date + '\'' +
            ", sender=" + sender +
            ", recipient=" + recipient +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return numberOfTransfer == transfer.numberOfTransfer && amount == transfer.amount && Objects.equals(date, transfer.date) && Objects.equals(sender, transfer.sender) && Objects.equals(recipient, transfer.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTransfer, amount, date, sender, recipient);
    }


}
