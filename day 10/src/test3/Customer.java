package test3;
public class Customer {
    private String firstName;
    private String lastName;
    public Account account;
    public Customer(String f,String l)
    {
        this.firstName=f;
        this.lastName=l;
    }
    public Account getAccount()
    {
        return this.account;
    }
    public void setAccount(Account account)
    {
        this.account=account;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
}
