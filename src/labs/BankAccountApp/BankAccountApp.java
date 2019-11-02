package labs.BankAccountApp;

public class BankAccountApp {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("333232323", 1000);
        BankAccount acc2 = new BankAccount("333232323", 2500);
        BankAccount acc3 = new BankAccount("333232323", 2400);

        acc1.setName("Jim");
        System.out.println(acc1.getName());
        acc1.makeDeposit(300);
        acc1.makeDeposit(333);

        acc1.accrue();
        System.out.println(acc1.toString());
    }
}

class BankAccount implements IInterest{
    // Properties of bankaccount

    // internal id
    // belongs to class
    private static int iD = 1000;

    // encapsulation
    private String accountNumber; //id + random 2digit number + 2 digits SSN
    private static final String routingNumber = "00443322442";
    private String name;
    private String SSN;
    private double balance;


    // constructor
    public BankAccount(String SSN, double initDeposit){
        balance = initDeposit;

        System.out.println("New Account created");
        iD++;

        //instance ssn to local ssn
        this.SSN = SSN;
        setAccountNumber();
    }

    private void setAccountNumber(){
        // cast as int
        int random = (int) Math.random() * 10;
        accountNumber = iD + "" + random + SSN.substring(0,2);
        System.out.println("Your Account number" + accountNumber);
    }

    public void setName(String name){
        // instence var = local var
        this.name = name;
    }

    public String getName(){
        // instence var
        return name;
    }

    public void payBill(double amount){
        balance = balance-amount;
        System.out.println("Paying bill" + amount);
        showBalance();
    }

    public void makeDeposit(double amount){
        System.out.println("Making deposit" + amount);
        balance = balance+amount;
        showBalance();
    }

    public void showBalance(){
        System.out.println("Balance"+balance);
    }

    @Override
    public void accrue() {
        balance = balance * (1 + rate/100);
        showBalance();
    }

    public String toString(){
        return "[Name " + name + "]\n[Account nmber " + accountNumber + "]";
    }
}