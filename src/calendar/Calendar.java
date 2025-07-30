/**
 * Calendar 클래스
 * 역할: 현재 날짜와 기존 날짜 관리
 */

package calendar;

import java.time.*;

import exception.InsufficientBalanceException;

public class Calendar {
	private static LocalDate beforeDate = LocalDate.of(2025, 07, 04); // 이전 날짜
	private static LocalDate nowDate = LocalDate.of(2025, 07, 04); // 현재 날짜
	
	/**
	 * 시뮬레이터의 현재 날짜를 설정하고 기존날짜는 저장한다.
	 * 
	 * @param money afterDate 현재 날짜
	 */
	public static void setNowDate(LocalDate afterDate) {
		beforeDate = nowDate;
		nowDate = afterDate;
	}
	
	/**
	 * 시뮬레이터의 현재 날짜 조회 기능을 제공한다.
	 * 
	 * @return 현재 날짜
	 */
	public static LocalDate getNowDate() {
		return nowDate;
	}
	
	/**
	 * 시뮬레이터의 날짜 이동 전의 날짜 조회 기능을 제공한다.
	 * 
	 * @return 이전 날짜
	 */
	public static LocalDate getBeforeDate() {
		return beforeDate;
	}
}
