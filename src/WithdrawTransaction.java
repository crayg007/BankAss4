public class WithdrawTransaction extends Transaction{
		
		WithdrawTransaction(BankAccount targetAccount, double amount)
		{
			this.targetAccount = targetAccount;
			this.amount = amount;
		}
		
		public void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException
		{
			if (amount < 0) 
			{
				throw new NegativeAmountException("Negative amount is unacceptable.");
			}
			else if (amount > 1000)
			{
				throw new ExceedsFraudSuspicionLimitException("Fraud Suspected. Cannot complete transaction.");
			}
		
			else if (targetAccount.getBalance() < amount)
			{
				throw new ExceedsAvailableBalanceException("Exceeds Availiable Balance.");
			}
			else
			{
				targetAccount.deposit(amount);
			}
		}

	}