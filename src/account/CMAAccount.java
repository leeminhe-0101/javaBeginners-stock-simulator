/**
 * CMAAccount 클래스
 * 역할: 계좌의 잔액과 하루마다 반영되는 이자를 관리한다.
 */

package account;

import java.time.LocalDate;

public class CMAAccount {
	public final int initialBalance; //초기 원금
	private int balance; // 잔액
	private int totalInterest = 0; // 잔액에 대한 총 이자
	
	/**
	 * 초기 계좌의 잔액을 세팅한다.
	 */
	public CMAAccount(int initialBalance) {
		this.initialBalance = initialBalance;
		this.balance = initialBalance;
	}
	
	/**
	 * CMA 계좌의 잔액을 설정한다.
	 *
	 * @param balance 계좌의 새로운 잔액
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
	 * 1. 지난 일수만큼 CMA 계좌의 이자를 붙인다.
	 * 2. 이자를 붙여 현재 잔액을 설정한다.
	 * 3. 계산된 이자는 이자는 이자의 총합계를 나타내는 totlInterest에 저장한다.
	 * 4. 현재 잔액을 반환한다.
	 *
	 * @param beforeDate 이전 날짜
	 * @param nowDate 현재 날짜
	 * @return 계좌의 현재 잔액 (이자 반영 포함)
	 */
	public int getBalanceWithInterest(LocalDate beforeDate, LocalDate nowDate) {
		if(beforeDate.equals(nowDate)) {
			return balance;
		}
		
		CMAInterestCalculator.setInterest(balance, beforeDate, nowDate);
	    int interest = CMAInterestCalculator.getInterest();
	    totalInterest += interest;
	    balance += interest;
	    setBalance(balance);
	    return balance;  
	}
	
	/**
	 * 이자의 총합계를 나타내는 totlInterest 필드 조회 기능을 제공한다.
	 *
	 * @return 시뮬레이션 기간동안 붙은 이자의 총합
	 */
	public int getTotalInterest() {
		return totalInterest;
	}
}

