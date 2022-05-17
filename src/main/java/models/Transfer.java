package models;

import exceptions.BlockAccException;
import exceptions.DontCorrentPinCodeExeption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import javax.security.auth.login.AccountLockedException;
import services.PinValidator;
import services.TerminalServer;

public class Transfer {

    private int numberOfTransfer;
    private Date date;
    private Person sender;
    private Person recipient;
    private int amount;

    public Transfer(int numberOfTransfer, int amount, Date date, Person sender, Person recipient) {
        this.numberOfTransfer = numberOfTransfer;
        this.amount = amount;
        this.date = date;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Transfer(int numberOfTransfer, int amount, Date date, Person sender) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @Override
    public String toString() {
        return "models.Transfer{" +
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
