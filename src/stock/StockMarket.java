/**
 * StockMarket 클래스
 * 역할: 선택한 종목을 전량 매도하며, CMAAccount에 매도 금액을 반영한 뒤, Stock 객체의 Holding을 조작하여 거래 내역을 갱신
 */

package stock;

import account.CMAAccount;
import calendar.Calendar;

public class StockMarket {
	private CMAAccount cmaAccount;
	
	public StockMarket(CMAAccount cmaAccount) {
		this.cmaAccount = cmaAccount;
	}
	
	/**
	 * 선택한 종목의 전량을 매도하며, 매도한 시점의 주가를 반영하여 CMA 계좌로 입금한다.
	 * 
	 * @param stock 선택한 종목
	 * @param i StockDB의 주식 종류를 저장하는 배열에서의 선택한 종목의 인덱스
	 */
	public void sell(Stock stock, int i) {
		int sellAmount = stock.getHolding().num * stock.getDailyData(Calendar.getNowDate()).buyPrice();
		int balance = cmaAccount.getBalanceWithInterest(Calendar.getBeforeDate(), Calendar.getNowDate()) + sellAmount;

		cmaAccount.setBalance(balance);
		
		stock.getHolding().list.removeIf(h -> h.stock().getClass().equals(stock.getClass()));
		stock.getHolding().setTotalStock(i);
	}
}
