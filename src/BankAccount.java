public class BankAccount {

    private static int idCounter = 0;
    private int id;
    private String name;
    private int salary;

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public BankAccount(String name) {
        salary = 0;
        id = setBankAccountId();
        this.name = name;
    }

    private int setBankAccountId() {
        idCounter++;
        return idCounter;
    }

    public void deposit(int amount) {
        salary += amount;
    }

    public int withdraw(int amount) {
        if(amount > salary)
            return 0;

        salary -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", salary=" + salary +
                '}';
    }
}
