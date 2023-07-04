import java.util.HashMap;
import java.util.Map;

public class UserAccount {
    //En samling av BankAccounts. Börjar med ett. Användaren kan sen skapa fler.
    private Map<Integer,BankAccount> bankAccounts;
    private String firstName, surName;

    public UserAccount(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
        bankAccounts = new HashMap();
        BankAccount firstBankAccount = new BankAccount();
        bankAccounts.put(firstBankAccount.getId(), firstBankAccount);
    }

    public void createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccounts.put(bankAccount.getId(), bankAccount);
    }

    public BankAccount getBankAccount(int id) {
        if(bankAccounts.containsValue(id))
            return bankAccounts.get(id);
        else
            return null;
    }
}
