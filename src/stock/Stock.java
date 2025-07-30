/**
 * Stock 클래스
 * 역할: 자식 클래스들이 가져야 하는 일자별 주가 데이터(Map), 각 종목의 보유 주식 내역을 관리하는 Holding 객체, 종목명 저장 구조 구현
 */

package stock;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class Stock {
	
	private Map<LocalDate, DailyData> dailyData = new HashMap<>(); // 종목 데이터
	
	Holding holding;
	String name; // 종목명

	public Stock(Holding holding, String name) {
	    this.holding = holding;
	    this.name = name;
	}
	
	/**
	 * 자식 객체인 종목에 대한 매수 내용을 저장하고 있는 holding 필드를 반환한다.
	 */
	public Holding getHolding() {
		return holding;
	}
	
	public record DailyData(int buyPrice, float comparedToPreviousDay, String hint) {} // 종목 데이터 저장 구조
	
	/**
	 * 종목이 가진 일별 데이터를 저장하는 메소드이다.
	 */
	public void setDailyData(DailyData p1, int i) {
		dailyData.put(LocalDate.of(2025, 07, 04+i), p1);
	}
	
	/**
	 * 종목이 가진 일별 데이터를 반환하는 메소드이다.
	 */
	public DailyData getDailyData(LocalDate nowdate) {
		return dailyData.get(nowdate);
	}
	
	/**
	 * 종목이 가진 종목명을 반환하는 메소드이다.
	 */
	public String getName() {
	    return name;
	}
}
