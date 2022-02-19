
public interface Banking 
{
	 void getDetails();
	 int balanceAvailable();
	 void ammountDeducted(int amount) throws InsufficientAmountException;  
	 public void amountDeposited(int amount);
}
