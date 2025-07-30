/**
 * Result 클래스
 * 역할: 최종으로 실행되어 사용자의 시뮬레이션 결과를 보여준 후 프로그램 종료
 */

package result;

import atm.ATM;
import calendar.Calendar;
import stock.Holding;
import stock.StockDB;

public class Result {
	private ATM atm;
	
	public Result(ATM atm) {
		this.atm = atm;
	}
	
	/**
	 * 시뮬레이션 마지막 날짜에 도달시 자동 실행되는 메소드로 시뮬레이션 결과를 출력한다.
	 */
	public void startResult() {
		System.out.println(Calendar.getNowDate() + " 장마감");
		
		int totalPrincipal = 0;
		int totalProfit = 0;
		
		System.out.println("보유종목 수익률 ");
		
		for(int i=0; i<StockDB.getStocksLength(); i++) {
			Holding holding = StockDB.getStock(i).getHolding();
			
			if(!holding.getHoldingStock().isEmpty()) {
				for(int j=0; j<holding.getHoldingStock().size(); j++) {
					totalPrincipal += holding.principal;
					totalProfit += holding.revenue;
				    System.out.println(StockDB.getStock(i).getName());
					System.out.println("수익률: " + holding.ROI +"%");
				}
			}
		}
		int totalAssets = atm.accountInquiry() + totalPrincipal + totalProfit;
		
		System.out.println();
		System.out.println("총자산: " + totalAssets + "원");
		System.out.println("원금: " + atm.getCmaAccount().initialBalance + "원");
		System.out.println("이자 수익: " + atm.getCmaAccount().getTotalInterest() + "원");
		
		if(totalPrincipal == 0) {
			System.out.println("보유한 주식이 없습니다." );
		} else {
			float totalROI = (totalProfit / (float) totalPrincipal) * 100;
			System.out.println("주식 총수익률: " + totalROI);
		}
		
		System.exit(0);
		
		
		
		
		
		
	}
}

