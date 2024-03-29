package junit.entities.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.entities.Account;
import junit.factories.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();

		acc.deposit(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());

	}

	@Test
	public void depositShoudDoNothigWhenNegativeAmount() {
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;

		acc.deposit(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void fullWithDrawShouldClearBalance() {
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);

		double result = acc.fullWithDrow();

		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);

	}

	@Test
	public void withDrawShouldDecreaseBalanceWhenSuffiencetBalance() {
		double expectedValue = 100.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);

		acc.withdraw(700);

		Assertions.assertTrue(expectedValue == acc.getBalance());

	}

	@Test
	public void withDrawShouldthrowExceptionWhenInsuffiencetBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double initialBalance = 800.0;
			Account acc = AccountFactory.createAccount(initialBalance);
			acc.withdraw(900);

		}

		);

	}

}
