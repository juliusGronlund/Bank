import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private UserAccount userAccount = new UserAccount("Julius", "Grönlund");
    public static void main(String[] args) {
        Main main = new Main();
        main.setup();
        main.run();
        main.exit();
    }

    private void setup() {
        System.out.println("SETUP");
        //Ladda in filer och starta upp.
    }

    private void run() {
        boolean running = true;
        System.out.println("RUN");
        System.out.println("Welcome to JB. Julle-Bank at your service");
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
        System.out.println("EXIT");
    }

    private void printMenu() {
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Create new account");
        System.out.println("4. Exit");
    }

    private void deposit() {
        System.out.println("From what account do you want to deposit?");
        userAccount.printBankAccountsInfo();
    }

    private void withdraw() {
    }

    private void createNewBankAccount() {
    }
}
