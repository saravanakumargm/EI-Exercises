//Handler interface
interface ApproverHandler {
    void setNextApprover(ApproverHandler nextApprover);
    void approveRequest(ExpenseRequest request);
}

//Concrete handler classes
class ManagerHandler implements ApproverHandler {
    private ApproverHandler nextApprover;

    @Override
    public void setNextApprover(ApproverHandler nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void approveRequest(ExpenseRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("Manager approved the expense of amount: " + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.approveRequest(request);
        }
    }
}

class DirectorHandler implements ApproverHandler {
    private ApproverHandler nextApprover;

    @Override
    public void setNextApprover(ApproverHandler nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void approveRequest(ExpenseRequest request) {
        if (request.getAmount() <= 10000) {
            System.out.println("Director approved the expense of amount: " + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.approveRequest(request);
        }
    }
}

class VicePresidentHandler implements ApproverHandler {
    private ApproverHandler nextApprover;

    @Override
    public void setNextApprover(ApproverHandler nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void approveRequest(ExpenseRequest request) {
        if (request.getAmount() > 10000) {
            System.out.println("Vice President approved the expense of amount: " + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.approveRequest(request);
        }
    }
}

//ExpenseRequest class
class ExpenseRequest {
    private double amount;

    public ExpenseRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

//Client
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        // Create approvers
        ApproverHandler manager = new ManagerHandler();
        ApproverHandler director = new DirectorHandler();
        ApproverHandler vicePresident = new VicePresidentHandler();


        manager.setNextApprover(director); // Set up the chain of responsibility
        director.setNextApprover(vicePresident);

        //Create expense requests with different amounts
        ExpenseRequest expense1 = new ExpenseRequest(3000);   // Should be approved by Manager
        ExpenseRequest expense2 = new ExpenseRequest(7000);   // Should be approved by Director
        ExpenseRequest expense3 = new ExpenseRequest(12000);  // Should be approved by Vice President


        manager.approveRequest(expense1);//Process expense requests
        manager.approveRequest(expense2);
        manager.approveRequest(expense3);
    }
}

/*
The Chain of Responsibility pattern is implemented in this code, where expense requests
are handled by different levels of authority (Manager, Director, Vice President) based on the
amount. Each approver checks if they can approve the request, and if not, it is passed to
the next level in the chain. This pattern provides flexibility in handling requests,
allowing the system to be easily extended with new approvers or modified approval rules
without altering the core logic.
 */
