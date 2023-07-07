import java.util.HashMap;
import java.util.Map;

public class UserAccount {
    //En samling av BankAccounts. Börjar med ett. Användaren kan sen skapa fler.
    private Map<Integer,BankAccount> bankAccounts;
    private String firstName, surName, accountName;
    private Password password;

    public UserAccount(String firstName, String surName, String accountName, String passwordInput) {
        this.firstName = firstName;
        this.surName = surName;
        this.accountName = accountName;
        password = new Password(passwordInput);
        bankAccounts = new HashMap();
        BankAccount firstBankAccount = new BankAccount("Main");
        bankAccounts.put(firstBankAccount.getId(), firstBankAccount);
    }

    public void createBankAccount(String name) {
        BankAccount bankAccount = new BankAccount(name);
        bankAccounts.put(bankAccount.getId(), bankAccount);
    }

    public BankAccount getBankAccount(int id) {
        if(bankAccounts.containsKey(id))
            return bankAccounts.get(id);
        else
            return null;
    }

    public boolean hasId(int id) {
        if(bankAccounts.containsKey(id))
            return true;

        return false;
    }

    public void deposit(int amount, int bankAccountId) {
        try {
            BankAccount bankAccount = bankAccounts.get(bankAccountId);
            bankAccount.deposit(amount);
        }
        catch(Exception e) {
            System.out.println("Deposit error");
        }
    }

    public int withdraw(int amount, int bankAccountId) {
        try {
            BankAccount bankAccount = bankAccounts.get(bankAccountId);
            bankAccount.withdraw(amount);
        }
        catch(Exception e) {
            System.out.println("withdraw error");
        }
        return 0;
    }

    public void printBankAccountsInfo() {
        bankAccounts.forEach((bankId, bankAccount) -> System.out.println("Name:" + bankAccount.getName() + ", ID:" + bankId + ", Salary:" + bankAccount.getSalary()));
    }

    public boolean passwordMatches(String inputPassword) {
       return password.matches(inputPassword);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "bankAccounts=" + bankAccounts +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
