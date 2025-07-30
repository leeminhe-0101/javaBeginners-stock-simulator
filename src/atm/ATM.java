/**
 * ATM 클래스
 * 역할: 계좌 필드의 잔액조회, 출금 기능 제공
 */

package atm;

import account.CMAAccount;
import calendar.Calendar;
import exception.InsufficientBalanceException;

public class ATM {
	private CMAAccount cmaAccount;

	public ATM(CMAAccount cmaAccount) {
		this.cmaAccount = cmaAccount;
	}
	
	/**
	 * CMA 계좌에서 현재 잔액을 조회하여 반환한다.
	 *
	 * @return 조회한 계좌의 현재 잔액
	 */
	public int accountInquiry() {
		int balance = cmaAccount.getBalanceWithInterest(Calendar.getBeforeDate(),Calendar.getNowDate());
		return balance;
	}
	
	/**
	 * 출금액이 CMA 계좌의 현재 잔액보다 크면 예외를 발생시키고,
	 * 작거나 같으면 현재 잔액에서 출금액 만큼 빼서 계좌의 잔액을 설정한다.
	 * 
	 * @param money 출금액
	 * @throws InsufficientBalanceException 출금액이 CMA 계좌의 현재 잔액보다 클 경우 발생
	 */
	public void withdraw(int money) throws InsufficientBalanceException {
		int balance = cmaAccount.getBalanceWithInterest(Calendar.getBeforeDate(),Calendar.getNowDate());
		
		if(money>balance){
			throw new InsufficientBalanceException("잔액이 부족합니다.");
		} else {
			balance = balance - money;
			cmaAccount.setBalance(balance);
		}
	}
	
	public CMAAccount getCmaAccount() {
		return cmaAccount;
	}
	
}
