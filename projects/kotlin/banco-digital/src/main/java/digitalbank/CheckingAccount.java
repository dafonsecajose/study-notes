package digitalbank;

/**
 * Conta corrente
 */

public class CheckingAccount extends Account {


    public CheckingAccount(Client client) {
        super(client);
    }

    @Override
    public void printResume() {
        System.out.println("Extrado conta corrente ===");
        super.printInfo();
    }
}
