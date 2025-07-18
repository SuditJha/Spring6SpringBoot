package com.cts.SpringAopDemo;

import org.springframework.stereotype.Component;

@Component
public class EasyBank {

	private int pinCode = 6789;
	private int balance = 10000;
	private int tempPin;

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getTempPin() {
		return tempPin;
	}

	public void setTempPin(int tempPin) {
		this.tempPin = tempPin;
	}

	public void doDeposit(int amount) {
		balance += amount;
		System.out.println("Your  balance is " + balance);
	}

	public void doWithdraw(int amount) {
		if (amount > balance) {
			System.out.println("Insufficient Fund");
		} else {
			balance -= amount;
			System.out.println("You have successfully withdrawn " + amount);
		}
	}

	public void doChangePin(int oldPin, int pin) {
		if (oldPin != pinCode) {
			throw new RuntimeException();
		}
		String newPinStr = Integer.toString(pin);
		if (newPinStr.length() == 4 && newPinStr.charAt(0) != '0') {
			this.pinCode = pin;
		} else {
			throw new RuntimeException();
		}
	}

	public void showBalance() {
		System.out.println("Your balance is " + balance);
	}
}
