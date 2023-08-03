package digitalbank;

public class Main {

    public static void main(String[] args) {
        Client jose = new Client();
        jose.setName("Jose");

        Account cc = new CheckingAccount(jose);
        Account savings = new SavingsAccount(jose);

        cc.deposit(100);
        cc.transfer(100, savings);

        cc.printResume();
        savings.printResume();
    }
}
