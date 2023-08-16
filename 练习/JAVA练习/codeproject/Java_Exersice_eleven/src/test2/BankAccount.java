package test2;

/**
 * @title:银行账户管理
 * @author:nanzhou
 * @date:2023.8.16
 */
/*## 银行账户管理 创建一个名为 BankAccount 的类，用于管理银行账户。

该类包含以下属性和方法：

属性：账户号码（accountNumber）、账户持有人姓名（accountHolder）、余额（balance）

方法：构造方法、获取账户号码的方法、获取账户持有人姓名的方法、获取余额的方法、存款方法、取款方法*/
public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private Double balance;

    public BankAccount() {
        this( null,null,0.0);
    }

    public BankAccount(String accountNumber, String accountHolder, Double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public Double getBalance() {
        return balance;
    }
}
