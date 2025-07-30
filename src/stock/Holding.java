/**
 * Holding 클래스
 * 역할: 한 종목의 거래 내역과 원금, 수익, 수익률, 수량 등을 저장
 */

package stock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import calendar.Calendar;
import result.ProfitCalculator;
import stock.Stock.DailyData;

public class Holding {
	public record HoldingStock(Stock stock, LocalDate buyDate, int buyPrice, int quantity) {} // 거래 내용 구조
	public List<HoldingStock> list = new ArrayList<>(); // 거래 내역
	
	public int principal; // 총 투자 원금
	public int sum=0; // 평가 금액 (현재 날짜 기준)
	public float ROI; // 수익률
	public int revenue; // 총 수익
	public int num=0; // 총 수량
	
	
	/**
	 * 주식 종목 매수 시 해당 거래 내용을 저장한다.
	 * 
	 *  @param nowdate 시뮬레이터의 현재 날짜
	 *  @param stock 매수한 종목
	 *  @param number 매수한 수량
	 */
	public void setHolding(LocalDate nowdate, Stock stock, int number) {
		DailyData data = stock.getDailyData(nowdate);
		HoldingStock p1 = new HoldingStock(stock, nowdate, data.buyPrice(), number);
		
		list.add(p1);
	}
	
	/**
	 * 주식 종목에 대한 매수 내역을 저장하고 있는 리스트를 반환한다.
	 * 
	 * @return 종목에 대한 매수 내역을 저장하고 있는 리스트
	 */
	public List<HoldingStock> getHoldingStock() {
		return list;
	}
	
	/**
	 * 종목 매수 전체에 대한 원금, 수익, 수량, 수익률 등의 정보를 저장한다.
	 * 
	 * @param i StockDB의 주식 종류를 저장하는 배열에서의 해당 종목의 인덱스
	 */
	public void setTotalStock(int i) {
		principal = revenue = sum = num = 0;
		
		for(HoldingStock data: list) {
			principal += data.buyPrice * data.quantity;
			int evaluation = (StockDB.getStock(i).getDailyData(Calendar.getNowDate()).buyPrice() - data.buyPrice) * data.quantity;
			revenue += evaluation;
			sum += data.buyPrice * data.quantity + evaluation;
			
			num += data.quantity;
		}
		ROI = ProfitCalculator.calculateROI(principal, revenue);
		
	}
	
}

