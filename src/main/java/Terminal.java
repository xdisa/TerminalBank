public interface Terminal {

    public  void transferToMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException;
    public  void transferToAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException;
}
