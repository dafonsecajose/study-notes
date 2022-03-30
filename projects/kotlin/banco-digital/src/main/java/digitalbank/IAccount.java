package digitalbank;

import java.security.AccessControlContext;

public interface IAccount {

    void toWithdraw(double value);

    void deposit(double value);

    void transfer(double value, IAccount destinyAccount);

    void printResume();
}
