package digitalbank;

/**
 * Conta Poupança
 */
public class SavingsAccount extends Account{

    public SavingsAccount(Client client) {
        super(client);
    }

    @Override
    public void printResume() {
        System.out.println("Extrado conta poupança ===");
        super.printInfo();
    }


}
