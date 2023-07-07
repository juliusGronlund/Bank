import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    //Fixa inlogg med useraccount sen. skapa nya konton osv.
    private UserAccount userAccount = new UserAccount("Julius", "Grönlund");
    public static void main(String[] args) {
        Main main = new Main();
        main.setup();
        main.run();
        main.exit();
    }

    private void setup() {
        //Ladda in filer och starta upp.
    }

    private void run() {
        boolean running = true;
        System.out.println("Welcome to JBB. Julle-Bulle-Bank at your service!");
        while(running) {
            printMenu();
            int input;
            try {
                input = scanner.nextInt();
                switch(input) {
                    case 1:
                        //Metoder för kommandon
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        createNewBankAccount();
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Choose something from the list");
                }
            }
            catch (Exception e) {
                System.out.println("ERROR. The input has to be an integer.");
            }
        }
    }

    private void exit() {
    }

    private void printMenu() {
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Create new account");
        System.out.println("4. Exit");
    }

    //Ta in info om deposit och anropa metod
    private void deposit() {
        int answer, amount;
        System.out.println("To which account do you want to deposit?");
        userAccount.printBankAccountsInfo();
        System.out.println("Choose by writing account-ID");
        try {
            answer = scanner.nextInt();
            if(userAccount.hasId(answer)) {
                System.out.println("How much do you want to deposit?");
                amount = scanner.nextInt();
                userAccount.deposit(amount, answer);
            }
            else
                System.out.println("ID does not exist here.");

        }
        catch(Exception e) {
            System.out.println("Error. incorrect input.");
        }
    }

    private void withdraw() {
        int answer, amount;
        System.out.println("From which account do you want to withdraw?");
        userAccount.printBankAccountsInfo();
        System.out.println("Choose by writing account-ID");
        try {
            answer = scanner.nextInt();
            if(userAccount.hasId(answer)) {
                System.out.println("How much do you want to withdraw?");
                amount = scanner.nextInt();
                if(amount > userAccount.getBankAccount(answer).getSalary())
                    System.out.println("Requested withdrawal exceeds current account-salary");
                else
                    userAccount.withdraw(amount, answer);
            }
            else
                System.out.println("ID does not exist here.");

        }
        catch(Exception e) {
            System.out.println("Withdraw ERROR");
        }
    }

    private void createNewBankAccount() {
        scanner.nextLine();
        //Fråga vilket namn det nya bankkonto ska ha
        System.out.println("I'm delighted that you're interested in setting up a new bank account. What name would you like to give to your account?");
        String answer = scanner.nextLine(); //Den tar inte upp namnet.
        userAccount.createBankAccount(answer);
        System.out.println("The account " + answer + " has been created.");
    }
}
