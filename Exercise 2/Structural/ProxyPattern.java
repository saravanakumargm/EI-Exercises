package Structural;
// Interface for Bank Account
interface BankAccount {
    void withdraw(double amount);
    double getBalance();
}

// Real Subject: Actual Bank Account
class RealBankAccount implements BankAccount {
    private double balance;

    public RealBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// Proxy: Bank Account Proxy with Access Control
class BankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;
    private String userRole;

    public BankAccountProxy(double initialBalance, String userRole) {
        this.realBankAccount = new RealBankAccount(initialBalance);
        this.userRole = userRole;
    }

    @Override
    public void withdraw(double amount) {
        if (userRole.equalsIgnoreCase("OWNER")) {
            realBankAccount.withdraw(amount);
        } else {
            System.out.println("Access Denied: Only account owners can withdraw money.");
        }
    }

    @Override
    public double getBalance() {
        if (userRole.equalsIgnoreCase("OWNER")) {
            return realBankAccount.getBalance();
        } else {
            System.out.println("Access Denied: Only account owners can view the balance.");
            return 0.0;
        }
    }
}

// Client
public class ProxyPattern {
    public static void main(String[] args) {
        // Create an account proxy for an OWNER
        BankAccount ownerAccount = new BankAccountProxy(1000.00, "OWNER");
        System.out.println("Owner attempting to withdraw...");
        ownerAccount.withdraw(200.00);
        System.out.println("Owner's Balance: $" + ownerAccount.getBalance());

        // Create an account proxy for a GUEST
        BankAccount guestAccount = new BankAccountProxy(1000.00, "GUEST");
        System.out.println("\nGuest attempting to withdraw...");
        guestAccount.withdraw(100.00);
        System.out.println("Guest attempting to view balance...");
        System.out.println("Guest's Balance: $" + guestAccount.getBalance());
    }
}

/*
This program demonstrates the Proxy Design Pattern through a BankAccountProxy that controls
access to a RealBankAccount based on user roles. The proxy restricts sensitive operations
like withdrawing money and viewing the balance for unauthorized users.
This approach adds an extra layer of security while maintaining the same interface
for clients.
 */