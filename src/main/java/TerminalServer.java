import javax.security.auth.login.AccountLockedException;

public class TerminalServer {

    public static void showBlockingTimeLeft(PinValidator blocking) throws AccountLockedException {
        throw new AccountLockedException("доступ заблокирован на: " + blocking.getSecondsCountToEnd() + "s.");
    }

    static void checkPin(int pin) throws DontCorrentPinCodeExeption {
        if (pin != getCorrectPin()) {
            throw new DontCorrentPinCodeExeption("неверный пин код");
        } else {
            System.out.println("доступ разрешен");
        }
    }

    static void checkPinInputTryCount(int currentTry) {
        if (currentTry == 4) {
            throw new BlockAccException("доступ заблокирован");
        }
    }

    private static int getCorrectPin() {
        return Person.getPin();

    }
}
