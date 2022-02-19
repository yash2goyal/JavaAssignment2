
import java.util.*;
public class SBI implements Banking 
{
	static int availableBalance = 0;

	@Override
	public void getDetails() {
		
	}

	@Override
	public int balanceAvailable() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ammountDeducted(int amount) throws InsufficientAmountException {
		if(amount > availableBalance)
		{
			throw new InsufficientAmountException("insufficient balance");
		}
		else
		{
			availableBalance -= amount;
			System.out.println("amount successfully withdrawl");
		}
	}
	public void amountDeposited(int amount)
	{
		availableBalance +=amount;
		System.out.println("amount successfully deposited");
	}

	public static void main(String[] args) {
		SBI s = new SBI();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose one of the option given below : ");
		System.out.println("1. Bank Services");
		System.out.println("2. deposit money");
		System.out.println("3. Withdraw money");
		System.out.println("4. Check balance");
		
		while(true)
		{
			int choice = sc.nextInt();
			switch(choice)
			{
			  case 1:
				  s.getDetails();
				  break;
			  case 2:
				  System.out.println("enter the amount you want to deposit");
				  int amount = sc.nextInt();
				  s.amountDeposited(amount);
				  break;
			  case 3:
				  System.out.println("enter the amount for withdrawl");
				  int amountDeducted = sc.nextInt();
				  try 
				  {
					s.ammountDeducted(amountDeducted);
				  } 
				  catch (InsufficientAmountException e) 
				  {
					System.out.println("withdrawl unsuccessful");
				  }
				  break;
			  case 4:
				  System.out.println("the available balance is "+availableBalance);
				  break;
			  default:
				  System.out.println("wrong choice");
				  break;
			}
		}
		
	}

}
