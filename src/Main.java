public class Main {
    public static void main(String[] args) {
        UserAccount userAccount1 = new UserAccount("Julius", "Grönlund");
        userAccount1.createBankAccount();
        BankAccount bankAccount = userAccount1.getBankAccount(0);

        System.out.println(bankAccount.getId() + bankAccount.getSalary());
    }
}
