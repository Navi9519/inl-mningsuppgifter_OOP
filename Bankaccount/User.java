package Bankaccount;

public class User {
    // String accountHolder;
    int accountNumber;
    // String email;
    // String passWord;

    public User(/* String accountHolder, */ int accountNumber /* String email, String passWord */) {
        // this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        // this.email = email;
        // this.passWord = passWord;

    }

    public String toString() {
        return "Accountnumber: " + this.accountNumber;
    }

    public void getAccountNumber(int accountNumber) {
        accountNumber = this.accountNumber;
    }

}
