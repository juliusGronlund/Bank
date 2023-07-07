import java.util.*;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    //Fixa inlogg med useraccount sen. skapa nya konton osv.
    private UserAccount currentUser;
    private Map<String, UserAccount> accounts = new HashMap();

    private boolean runningLogin = true;
    private boolean runningBank = true;
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
        logInSetup();
        runningBank = true;
        System.out.println("Welcome to JBB. Julle-Bulle-Bank at your service!");
        while(runningBank) {
            printMenu();
            int input;
            try {
                input = scanner.nextInt();
                scanner.nextLine();
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
                        //Logout istället för att exit programme
                        runningBank = false;
                        runningLogin = true;
                        logInSetup();
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

    private void logInSetup() {
        while(runningLogin) {
            printLogInMenu();
            try {
                int answer = scanner.nextInt();
                scanner.nextLine();

                switch (answer) {
                    case 1:
                        createNewBankUser();
                        break;
                    case 2:
                        logIn();
                        break;
                    case 3:
                        //Exit program
                        runningLogin = false;
                        runningBank = false;
                        break;
                    default:
                        System.out.println("Incorrect");
                }
            }
            catch (Exception e) {
                System.out.println("Log in ERROR");
            }
        }

    }

    private void logIn() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("\nPassword: ");
        String password = scanner.nextLine();

        if(accounts.containsKey(username) && accounts.get(username).passwordMatches(password)) {
            currentUser = accounts.get(username);
            System.out.println("Login success");
            runningLogin = false;
            runningBank = true;
        }
        else
            System.out.println("Login failed");
    }

    private void createNewBankUser() {
        System.out.println("What is your first name?");
        String firstName = scanner.nextLine();
        System.out.println("What is your surname?");
        String surname = scanner.nextLine();
        System.out.println("What username do you want?");
        String username = scanner.nextLine();
        System.out.println("What password do you want?");
        String password = scanner.nextLine();

        UserAccount newUserAccount = new UserAccount(firstName, surname, username, password);
        accounts.put(username, newUserAccount);
    }

    private void printLogInMenu() {
        System.out.println("LOG IN! LOG IN!");
        System.out.println("1. Create bank user");
        System.out.println("2. Log in");
        System.out.println("3. Leave the bank");
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
        currentUser.printBankAccountsInfo();
        System.out.println("Choose by writing account-ID");
        try { //Det är strul med inputs och grejer där det kan bli infinty-loop.
            answer = scanner.nextInt();
            scanner.nextLine();
            if(currentUser.hasId(answer)) {
                System.out.println("How much do you want to deposit?");
                amount = scanner.nextInt();
                scanner.nextLine();
                currentUser.deposit(amount, answer);
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
        currentUser.printBankAccountsInfo();
        System.out.println("Choose by writing account-ID");
        try {
            answer = scanner.nextInt();
            scanner.nextLine();
            if(currentUser.hasId(answer)) {
                System.out.println("How much do you want to withdraw?");
                amount = scanner.nextInt();
                scanner.nextLine();
                if(amount > currentUser.getBankAccount(answer).getSalary())
                    System.out.println("Requested withdrawal exceeds current account-salary");
                else
                    currentUser.withdraw(amount, answer);
            }
            else
                System.out.println("ID does not exist here.");

        }
        catch(Exception e) {
            System.out.println("Withdraw ERROR");
        }
    }

    private void createNewBankAccount() {
        //Fråga vilket namn det nya bankkonto ska ha
        System.out.println("I'm delighted that you're interested in setting up a new bank account. What name would you like to give to your account?");
        String answer = scanner.nextLine(); //Den tar inte upp namnet.
        currentUser.createBankAccount(answer);
        System.out.println("The account " + answer + " has been created.");
    }
}
