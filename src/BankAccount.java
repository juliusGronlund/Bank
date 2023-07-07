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
        System.out.println("idCounter: " + idCounter);
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
