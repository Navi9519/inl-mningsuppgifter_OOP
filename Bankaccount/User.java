package Bankaccount;

public class User extends BankAccount {
    String email;
    String passWord;

    public User(String accountHolder, int accountNumber, String email, String passWord) {
        super(accountHolder, accountNumber);
        this.email = email;
        this.passWord = passWord;

    }

}
