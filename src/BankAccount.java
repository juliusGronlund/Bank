public class BankAccount {

    private static int idCounter = 0;
    private int id;
    private int salary;

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public BankAccount() {
        salary = 0;
        id = setBankAccountId();
    }

    private int setBankAccountId() {
        idCounter++;
        return idCounter;
    }
}
