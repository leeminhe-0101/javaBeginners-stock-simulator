/**
 * CMAInterestCalculator 클래스
 * 역할: 이동한 날짜와 기존 날짜 사이에 반영된 이자를 계산
 */

package account;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CMAInterestCalculator {
	private static int interest;
	
	/**
	 * 지난 날짜와 현재 날짜 사이 간격동안 생긴 이자를 계산한다.
	 *
	 * @param balance 이자가 붙는 원금
	 * @param beforeDate 이전 날짜
	 * @param nowDate 현재 날짜
	 */
	public static void setInterest(int balance, LocalDate beforeDate, LocalDate nowDate) {
		interest = (int) (balance * 0.0000522 * ChronoUnit.DAYS.between(beforeDate, nowDate));
	}
	
	/**
	 * 위 setter에서 계산된 이자 조회기능을 제공한다.
	 *
	 * @return 위 setter에서 계산된 이자
	 */
	public static int getInterest() {
		return interest;
	}
}
